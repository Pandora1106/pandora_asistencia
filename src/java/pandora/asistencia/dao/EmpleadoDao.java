/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pandora.asistencia.entity.Empleado;
import pandora.asistencia.entity.Masterparametro;
import pandora.asistencia.entity.Parametro;
import pandora.asistencia.service.EmpleadoService;
import pandora.asistencia.service.EntityCrud;
import pandora.asistencia.util.Conn;

/**
 *
 * @author Ricardo
 */
public class EmpleadoDao extends EntityCrud<Empleado> implements EmpleadoService, Serializable {

    EntityManagerFactory emf;
    EntityManager em;

    public EmpleadoDao(Class<Empleado> obj) {
        super(obj);
        emf = Persistence.createEntityManagerFactory("pandora_asistenciaPU");
        em = emf.createEntityManager();
    }

    @Override
    public Empleado validar(int nroDocumento, String password) {
        Query query = em.createNamedQuery("Empleado.validar");
        query.setParameter("nroDocumento", nroDocumento);
        query.setParameter("password", password);
        try {
            return (Empleado) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<Empleado> findByNroDocumento(int nroDocumento) {
        Query query = em.createNamedQuery("Empleado.findByNroDocumento");
        query.setParameter("nroDocumento", nroDocumento);
        try {
            return (List<Empleado>) query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<Empleado> findByStatus(int estado) {
        Query query = em.createNamedQuery("Empleado.findByEstado");
        query.setParameter("estado", estado);
        try {
            return (List<Empleado>) query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Empleado> searchEmployee(Empleado empleado) throws SQLException{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        Statement	stmt	            =	null;
        List<Empleado> listaEmpleados   =   null;
        StringBuilder 	query	=	new StringBuilder();
        query.append(" SELECT * FROM empleado WHERE 1 = 1 ");
         if(empleado.getNombres() != null)
            query.append(" AND nombres LIKE "+"'"+empleado.getNombres()+"%"+"'");
         if(empleado.getNroDocumento() != null)
            query.append(" AND nroDocumento = "+empleado.getNroDocumento()+" ");
         if(empleado.getEstado() != null)
            query.append(" AND estado = "+empleado.getEstado()+" ");
        
        
        try {
            listaEmpleados = new ArrayList();
            dbConnection = Conn.getConnection();
            stmt         = Conn.createStatement();
            
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, empleado.getNombres());
            preparedStatement.setInt(2, empleado.getNroDocumento());
            preparedStatement.setInt(3, empleado.getEstado());
            
            ResultSet rs = stmt.executeQuery(query.toString());
            while (rs.next()) {
                Empleado emp = new Empleado();
                empleado.setNroDocumento(rs.getInt("nroDocumento"));
                empleado.setNombres(rs.getString("nombres"));
                empleado.setApePaterno(rs.getString("apePaterno"));
                empleado.setApeMaterno(rs.getString("apeMaterno"));
                empleado.setPassword(rs.getString("password"));
                empleado.setEstado(rs.getInt("estado"));
                empleado.setTipoDocumento(rs.getInt("tipoDocumento"));
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return listaEmpleados;
    }
    
    //Useless by now    
    public List<Empleado> findByNameJDBC(String nombre) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        List<Empleado> listaEmpleados = null;
        String selectTableSQL = "SELECT * FROM empleado WHERE nombres LIKE '?%'";
        try {
            listaEmpleados = new ArrayList();
            dbConnection = Conn.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setNroDocumento(rs.getInt("nroDocumento"));
                empleado.setNombres(rs.getString("nombres"));
                empleado.setApePaterno(rs.getString("apePaterno"));
                empleado.setApeMaterno(rs.getString("apeMaterno"));
                empleado.setPassword(rs.getString("password"));
                empleado.setEstado(rs.getInt("estado"));
                empleado.setTipoDocumento(rs.getInt("tipoDocumento"));
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return listaEmpleados;
    }

    public List<Parametro> getListaDatoJDBC(String descripcion) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        List<Parametro> listaParametros = null;
        String selectTableSQL = "SELECT p.idMasterParametro, p.idParametro, p.dato FROM Parametro p, Masterparametro mp WHERE mp.descripcion = ? AND p.idMasterParametro = mp.idMasterParametro";
        try {
            listaParametros = new ArrayList();
            dbConnection = Conn.getConnection();
            preparedStatement = dbConnection.prepareStatement(selectTableSQL);
            preparedStatement.setString(1, descripcion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Masterparametro master = new Masterparametro();
                master.setIdMasterParametro(rs.getInt("idMasterParametro"));
                Parametro param = new Parametro();
                param.setIdMasterParametro(master);
                param.setIdParametro(rs.getInt("idParametro"));
                param.setDato(rs.getString("dato"));
                listaParametros.add(param);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return listaParametros;
    }

    @Override
    public String getNombre(int nroDocumento) {        
        Query query = em.createNamedQuery("Empleado.getNombreCompleto");
        query.setParameter("nroDocumento", nroDocumento);        
        try {
            return (String) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    } 

}
