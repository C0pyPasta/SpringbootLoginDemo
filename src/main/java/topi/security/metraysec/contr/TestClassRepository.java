package topi.security.metraysec.contr;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import topi.security.metraysec.domein.TestClass;

@Component
public interface TestClassRepository extends CrudRepository<TestClass, Long>{

}