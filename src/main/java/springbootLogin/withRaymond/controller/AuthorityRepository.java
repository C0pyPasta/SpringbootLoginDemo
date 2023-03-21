package springbootLogin.withRaymond.controller;

import springbootLogin.withRaymond.security.Authority;
import springbootLogin.withRaymond.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(AuthorityName name);

}