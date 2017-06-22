/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ricardo
 * @param <T>
 */

public abstract class EntityCrud<T> {
    
    EntityManagerFactory emf;
    EntityManager em;
    Class<T> obj;
    
    
    public EntityCrud(Class<T> obj){
        emf = Persistence.createEntityManagerFactory("pandora_asistenciaPU");
        em = emf.createEntityManager();
        this.obj = obj;
    }
    
   public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void edit(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void remove(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    public T find(Object id) {
        return em.find(obj, id);
    }

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(obj));
        return em.createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(obj));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(obj);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}