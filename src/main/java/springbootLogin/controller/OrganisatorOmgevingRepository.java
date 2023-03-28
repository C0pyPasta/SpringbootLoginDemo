package springbootLogin.controller;

import org.springframework.data.repository.CrudRepository;
import springbootLogin.domain.TestClass;

public interface OrganisatorOmgevingRepository extends CrudRepository<TestClass, Long> {

}