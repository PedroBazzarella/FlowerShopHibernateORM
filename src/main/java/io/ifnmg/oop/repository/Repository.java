package io.ifnmg.oop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Repository<T extends ProjectEntity> implements IRepository<T> {

    private final Class<T> entityClass;

    protected Repository() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Override
    public Long saveOrUpdate(T e) {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {

            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                if (e.getId() == null || e.getId() == 0) {
                    em.persist(e);
                } else {
                    em.merge(e);
                }
                tx.commit();
            } catch (Exception ex) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                    throw ex;
                }
            }
        }

        return e.getId();
    }

    @Override
    public List<T> findAll() {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {

            TypedQuery<T> query = em.createQuery("SELECT e FROM "+entityClass.getSimpleName()+" e", entityClass);
            return query.getResultList();
        }
    }

    @Override
    public T findById(Long id) {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {

            TypedQuery<T> query = em.createQuery("SELECT e FROM "+entityClass.getSimpleName()+" e WHERE e.id = :id",
                    entityClass);
            query.setParameter("id", id);

            return query.getSingleResultOrNull();
        }
    }

    @Override
    public boolean delete(T e) {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                e = em.merge(e);
                em.remove(e);
                tx.commit();
                return true;

            } catch (Exception ex) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                    throw ex;
                }
            }

            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {

            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Query query = em.createQuery("DELETE FROM "+entityClass.getSimpleName()+" e WHERE e.id = :id");
                query.setParameter("id", id);
                int deletions = query.executeUpdate();

                tx.commit();
                return deletions > 0;

            } catch (Exception ex) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                    throw ex;
                }
            }

            return false;
        }
    }

}