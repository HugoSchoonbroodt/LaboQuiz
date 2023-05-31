package anthohugo.laboquiz.repositories;

import anthohugo.laboquiz.domains.entities.User;

public interface UserRepository extends BaseRepository<Long, User> {

    User findByUsername(String username);
}