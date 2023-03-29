package springbootLogin.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springbootLogin.domain.TestClass;

@Component
public interface AdministratorOmgevingRepository extends CrudRepository<TestClass, Long> {

}