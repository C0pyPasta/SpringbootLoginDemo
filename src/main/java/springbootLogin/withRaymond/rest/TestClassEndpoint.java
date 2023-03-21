package springbootLogin.withRaymond.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootLogin.withRaymond.controller.TestClassRepository;
import springbootLogin.withRaymond.domain.TestClass;

@RestController
public class TestClassEndpoint {
	@Autowired
	TestClassRepository testClassRepo;

	@GetMapping("sayHello")
	public void go() {
		System.out.println("Hello");
		testClassRepo.save(new TestClass());
	}
}
