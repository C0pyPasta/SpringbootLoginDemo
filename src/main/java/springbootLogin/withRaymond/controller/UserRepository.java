package springbootLogin.withRaymond.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootLogin.withRaymond.security.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}