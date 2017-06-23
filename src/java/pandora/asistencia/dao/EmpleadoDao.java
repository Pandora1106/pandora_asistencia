/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pandora.asistencia.entity.Empleado;
import pandora.asistencia.service.EmpleadoService;
import pandora.asistencia.service.EntityCrud;

/**
 *
 * @author Ricardo
 */

public class EmpleadoDao extends EntityCrud<Empleado> implements EmpleadoService{
    
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
    
}
