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
import pandora.asistencia.entity.Horario;
import pandora.asistencia.entity.Empleado;
import pandora.asistencia.service.HorarioService;
import pandora.asistencia.service.EntityCrud;
import pandora.asistencia.util.Conn;

/**
 *
 * @author Ricardo
 */

public class HorarioDao extends EntityCrud<Horario> implements HorarioService {

    EntityManagerFactory emf;
    EntityManager em;

    public HorarioDao(Class<Horario> obj) {
        super(obj);
        emf = Persistence.createEntityManagerFactory("pandora_asistenciaPU");
        em = emf.createEntityManager();
    }

    @Override
    public Horario getIngreso(int nroDocumento) {
        Query query = em.createNamedQuery("Horario.getIngreso");
        query.setParameter("nroDocumento", nroDocumento);
        try {
            return (Horario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Horario getSalida(int nroDocumento) {
        Query query = em.createNamedQuery("Horario.getSalida");
        query.setParameter("nroDocumento", nroDocumento);
        try {
            return (Horario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void updateByMerge(int nroDocumento) {
        Query query = em.createNativeQuery("SELECT * FROM Horario a WHERE DAY(a.ingreso) = DAY(CURDATE()) AND a.nroDocumento = ?");
        query.setParameter(1, nroDocumento);
        Horario as = (Horario) query.getSingleResult();
        System.out.println(as);
        as.setSalida(new Date());
        em.getTransaction().begin();
        em.merge(as);
        em.getTransaction().commit();
    }

    @Override
    public void persistHorario(Horario horario, int nroDocumento) {
        Empleado empleado = em.find(Empleado.class, nroDocumento);
        horario.setNroDocumento(empleado);
        em.getTransaction().begin();
        em.persist(horario);
        em.getTransaction().commit();
    }
    
    @Override
    public Horario validarIngreso(int nroDocumento) {
        Query query = em.createNamedQuery("Horario.validarIngreso");
        query.setParameter("idUsuario", nroDocumento);
        try {
            return (Horario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Override
    public Horario validarSalida(int nroDocumento) {
        Query query = em.createNamedQuery("Horario.validarSalida");
        query.setParameter("idUsuario", nroDocumento);
        try {
            return (Horario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public static void updateJDBC(int nroDocumento) throws SQLException {        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;        
        String updateTableSQL = "UPDATE Horario SET salida = Now() WHERE nroDocumento = ? AND DAY(ingreso) = DAY(CURDATE())";
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