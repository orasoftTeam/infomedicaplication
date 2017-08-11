/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEmpleado;
import com.infomedic.entity.TblEmpleadoxservicio;
import com.infomedic.entity.TblHorarioxempleadoxservicio;
import com.infomedic.forms.EmpleadoServicioForm;
import com.infomedic.forms.HorarioXServicioForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
@Stateless
public class HorarioXServicioFacade extends AbstractFacade<TblHorarioxempleadoxservicio, HorarioXServicioForm>{
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblEmpleado empleado;
    
    public HorarioXServicioFacade(){
        super(TblHorarioxempleadoxservicio.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public boolean agregarHorarioServ(HorarioXServicioForm hor){
        boolean flag=true;
        try{
            if(hor==null || hor.getIdempleadoxservicio()==null){
                flag=false;
            }
            else{
                TblHorarioxempleadoxservicio horxserv= new TblHorarioxempleadoxservicio();
                TblEmpleadoxservicio empxserv= findServById(hor.getIdempleadoxservicio());
                horxserv.setIdempleadoxservicio(empxserv);
                horxserv.setDia(new BigInteger(hor.getDia()));
                horxserv.setHorainicio(new BigInteger(hor.getHorainicio()));
                horxserv.setHorafin(new BigInteger(hor.getHorafin()));
                create(horxserv);
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            flag=false;
        }
        return flag;
    }
    /*
    public boolean agregarServicioEmp(EmpleadoServicioForm serv) {
        
        boolean flag = true;
        try {
            if (serv == null) {
                flag = false;
            } else if (serv.getIdempleadoxservicio() == null) {
                TblEmpleadoxservicio empServ= new TblEmpleadoxservicio();
                empServ.setIdempleado(empleado);
                empServ.setIdservicio(new BigInteger(serv.getIdservicio()));
                empServ.setEstadoservicio('A');
                create(empServ);
                /*
                espec.setNombreespecialidad(espForm.getNombreEspecialidad().toUpperCase());
                this.create(espec);
                 
            } else {
                TblEmpleadoxservicio empServ= findById(serv.getIdempleadoxservicio());
                empServ.setIdempleado(empleado);
                empServ.setIdservicio(new BigInteger(serv.getIdservicio()));
                empServ.setEstadoservicio(serv.getEstadoservicio().charAt(0));
                edit(empServ);
                /*
                TblEspecialidad spec = find(new BigDecimal(espForm.getIdEspecialidad()));
                spec.setNombreespecialidad(espForm.getNombreEspecialidad().toUpperCase());
                this.edit(spec);
                 
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            flag = false;
        }

        return flag;
    }
    */
    public List<HorarioXServicioForm> getAllByEmp(String idempleado) {
        List<TblHorarioxempleadoxservicio> listaTmpEmpServ;
        List<HorarioXServicioForm> listaTmpEmpServForm;
        
        try {
            listaTmpEmpServ = findByIdEmp(idempleado);
            if(listaTmpEmpServ.isEmpty()) {
                listaTmpEmpServForm = new ArrayList<HorarioXServicioForm>();
            } else {
                listaTmpEmpServForm = this.entityToDtoList(listaTmpEmpServ, new HorarioXServicioForm());
            }
        } catch(Exception ex) {
           listaTmpEmpServForm =  new ArrayList<HorarioXServicioForm>();
        }
        
        return listaTmpEmpServForm;
    }
    
    public List<HorarioXServicioForm> getAllByServ(String idServ) {
        List<TblHorarioxempleadoxservicio> listaTmpEmpServ;
        List<HorarioXServicioForm> listaTmpEmpServForm;
        
        try {
            listaTmpEmpServ = findByIdServ(idServ);
            if(listaTmpEmpServ.isEmpty()) {
                listaTmpEmpServForm = new ArrayList<HorarioXServicioForm>();
            } else {
                listaTmpEmpServForm = this.entityToDtoList(listaTmpEmpServ, new HorarioXServicioForm());
            }
        } catch(Exception ex) {
           listaTmpEmpServForm =  new ArrayList<HorarioXServicioForm>();
        }
        
        return listaTmpEmpServForm;
    }
    
    public List<HorarioXServicioForm> getAllByServDiaHora(String idServ, String dia, String hora) {
        List<TblHorarioxempleadoxservicio> listaTmpEmpServ;
        List<HorarioXServicioForm> listaTmpEmpServForm;
        
        try {
            listaTmpEmpServ = findByIdServDiaHoraIni(idServ, dia, hora);
            if(listaTmpEmpServ.isEmpty()) {
                listaTmpEmpServForm = new ArrayList<HorarioXServicioForm>();
            } else {
                listaTmpEmpServForm = this.entityToDtoList(listaTmpEmpServ, new HorarioXServicioForm());
            }
        } catch(Exception ex) {
           listaTmpEmpServForm =  new ArrayList<HorarioXServicioForm>();
        }
        
        return listaTmpEmpServForm;
    }
    
    public TblEmpleadoxservicio findServById(String idempleadoxservicio){
        Query q= getEntityManager().createNativeQuery("select * from tbl_empleadoxservicio where idempleadoxservicio=? and estadoservicio='A'", TblEmpleadoxservicio.class);
        q.setParameter(1, new BigInteger(idempleadoxservicio));
        //q.setParameter(2, nit);
        List<TblEmpleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new TblEmpleadoxservicio():temp.get(0);
    }
    
    public List<TblHorarioxempleadoxservicio> findByIdEmp(String idempleado){
        Query q= getEntityManager().createNativeQuery("select * from tbl_horarioxempleadoxservicio where idempleadoxservicio in (select idempleadoxservicio from TBL_EMPLEADOXSERVICIO where idempleado=? AND estadoservicio='A')", TblHorarioxempleadoxservicio.class);
        q.setParameter(1, idempleado);
        //q.setParameter(2, nit);
        List<TblHorarioxempleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new ArrayList<TblHorarioxempleadoxservicio>():temp;
    }
    
    public List<TblHorarioxempleadoxservicio> findByIdServ(String idServ){
        Query q= getEntityManager().createNativeQuery("select * from tbl_horarioxempleadoxservicio where idempleadoxservicio in (select idempleadoxservicio from TBL_EMPLEADOXSERVICIO where idservicio=? AND estadoservicio='A') order by horafin asc", TblHorarioxempleadoxservicio.class);
        q.setParameter(1, idServ);
        //q.setParameter(2, nit);
        List<TblHorarioxempleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new ArrayList<TblHorarioxempleadoxservicio>():temp;
    }
    
    public List<TblHorarioxempleadoxservicio> findByIdServDiaHoraIni(String idServ, String dia, String hora){
        Query q= getEntityManager().createNativeQuery("select * from tbl_horarioxempleadoxservicio where idempleadoxservicio in (select idempleadoxservicio from TBL_EMPLEADOXSERVICIO where idservicio=? AND estadoservicio='A') and dia=? order by horainicio asc", TblHorarioxempleadoxservicio.class);
        q.setParameter(1, new BigInteger(idServ));
        q.setParameter(2, new BigInteger(dia));
        //q.setParameter(3, new BigInteger(hora));
        //q.setParameter(2, nit);
        List<TblHorarioxempleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new ArrayList<TblHorarioxempleadoxservicio>():temp;
    }
    
    public boolean eliminarHorariosXServicio(String idempleadoxservicio){
        boolean flag=true;
         PreparedStatement preparedStatement = null;
	 String deleteSQL = "DELETE TBL_HORARIOXEMPLEADOXSERVICIO WHERE IDEMPLEADOXSERVICIO = ?";
        try{
            //getEntityManager().getTransaction().begin();
            java.sql.Connection connection = getEntityManager().unwrap(java.sql.Connection.class);
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setBigDecimal(1, new BigDecimal(idempleadoxservicio));
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
		preparedStatement.close();
            }
            //getEntityManager().getTransaction().commit();           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
           //getEntityManager().getTransaction().rollback(); 
           flag=false;
        }
        return flag;
    }
    
    public boolean eliminarHorariosById(String idhorarioxservicio){
        boolean flag=true;
         PreparedStatement preparedStatement = null;
	 String deleteSQL = "DELETE TBL_HORARIOXEMPLEADOXSERVICIO WHERE IDHORARIOXEMPLEADOXSERVICIO = ?";
        try{
            //getEntityManager().getTransaction().begin();
            java.sql.Connection connection = getEntityManager().unwrap(java.sql.Connection.class);
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setBigDecimal(1, new BigDecimal(idhorarioxservicio));
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
		preparedStatement.close();
            }
            //getEntityManager().getTransaction().commit();           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
           //getEntityManager().getTransaction().rollback(); 
           flag=false;
        }
        return flag;
    }
}
