/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pandora.asistencia.entity.Asistencia;
import pandora.asistencia.entity.Empleado;
import pandora.asistencia.service.AsistenciaService;
import pandora.asistencia.service.EntityCrud;
import pandora.asistencia.util.Conn;

/**
 *
 * @author Ricardo
 */

public class AsistenciaDao extends EntityCrud<Asistencia> implements AsistenciaService {

    EntityManagerFactory emf;
    EntityManager em;

    public AsistenciaDao(Class<Asistencia> obj) {
        super(obj);
        emf = Persistence.createEntityManagerFactory("pandora_asistenciaPU");
        em = emf.createEntityManager();
    }

    @Override
    public Asistencia getIngreso(int nroDocumento) {
        Query query = em.createNamedQuery("Asistencia.getIngreso");
        query.setParameter("nroDocumento", nroDocumento);
        try {
            return (Asistencia) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Asistencia getSalida(int nroDocumento) {
        Query query = em.createNamedQuery("Asistencia.getSalida");
        query.setParameter("nroDocumento", nroDocumento);
        try {
            return (Asistencia) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void updateByMerge(int nroDocumento) {
        Query query = em.createNativeQuery("SELECT * FROM Asistencia a WHERE DAY(a.horaIngreso) = DAY(CURDATE()) AND a.idUsuario = ?");
        query.setParameter(1, nroDocumento);
        Asistencia as = (Asistencia) query.getSingleResult();
        System.out.println(as);
        as.setHoraSalida(new Date());
        em.getTransaction().begin();
        em.merge(as);
        em.getTransaction().commit();
    }

    @Override
    public void persistAsistencia(Asistencia asistencia, int nroDocumento) {
        Empleado empleado = em.find(Empleado.class, nroDocumento);
        asistencia.setNroDocumento(empleado);
        em.getTransaction().begin();
        em.persist(asistencia);
        em.getTransaction().commit();
    }
    
    @Override
    public Asistencia validarIngreso(int nroDocumento) {
        Query query = em.createNamedQuery("Asistencia.validarIngreso");
        query.setParameter("idUsuario", nroDocumento);
        try {
            return (Asistencia) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Override
    public Asistencia validarSalida(int nroDocumento) {
        Query query = em.createNamedQuery("Asistencia.validarSalida");
        query.setParameter("idUsuario", nroDocumento);
        try {
            return (Asistencia) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public static void updateJDBC(int nroDocumento) throws SQLException {        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;        
        String updateTableSQL = "UPDATE Asistencia SET horaSalida = Now() WHERE nroDocumento = ? AND DAY(horaIngreso) = DAY(CURDATE())";
        try {
            dbConnection = Conn.getConnection();            
            preparedStatement = dbConnection.prepareStatement(updateTableSQL);
            preparedStatement.setInt(1, nroDocumento);
            preparedStatement.executeUpdate();
            System.out.println("updateo");
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
    }
}