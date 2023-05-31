package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.repositories.BaseRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;


public class BaseRepositoryImpl<TKey, TEntity> implements BaseRepository<TKey, TEntity> {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public BaseRepositoryImpl() {
        this.emf = Persistence.createEntityManagerFactory("LaboQuizData");
        this.em = emf.createEntityManager();
    }

    @Override
    public void add(TEntity entity) {
        if (entity != null) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } else {
            throw new IllegalArgumentException("L'objet entity ne peut pas être null");
        }
    }

    @Override
    public void update(Class<TEntity> entityClass, TKey id, TEntity updatedEntity) {
        TEntity entity = em.find(entityClass, id);
        if (entity != null) {
            em.getTransaction().begin();
            em.merge(updatedEntity);
            em.getTransaction().commit();
        }
    }

    @Override
    public Optional<TEntity> getOne(Class<TEntity> entityClass, TKey id) {
        TEntity entity = em.find(entityClass, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public List<TEntity> getAll(Class<TEntity> entityClass) {
        String queryString = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        TypedQuery<TEntity> query = em.createQuery(queryString, entityClass);
        List<TEntity> entities = query.getResultList();
        entities.forEach(System.out::println);
        em.clear();
        return entities;
    }


    @Override
    public void delete(Class<TEntity> entityClass, TKey id) {
        TEntity entity = em.find(entityClass, id);
        if (entity != null) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
    }
}