package anthohugo.laboquiz.repositories.impl;

import anthohugo.laboquiz.domains.entities.User;
import anthohugo.laboquiz.repositories.UserRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserRepositoryImpl extends BaseRepositoryImpl<Long, User> implements UserRepository, Serializable {


    @Override
    public User findByUsername(String username) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        List<User> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

}