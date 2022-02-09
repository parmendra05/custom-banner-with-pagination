package com.pack;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	@Autowired
	MyRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void defaultData() {
		ArrayList<Person> personList=new ArrayList<>();
		personList.add(new Person(12548, "Aleena",  "Jaipur", "RJ"));
		personList.add(new Person(95545, "Simon",  "Bangalore", "KA"));
		personList.add(new Person(96325, "Ravi",  "pune", "MH"));
		personList.add(new Person(12587, "Diksha",  "Jainagar", "UP"));
		personList.add(new Person(78932, "Zakir",  "Delhi", "DL"));
		repo.saveAll(personList);
	}
	
	@GetMapping("/msg/{message}")
	public String msg(@PathVariable String message) {
		return message;
	}
	
	@GetMapping("/get")
	public List<Person> myFindAllPerson() {
		//return repo.findAll();
		//return repo.findAll(Sort.by("city"));
		return repo.findAll(Sort.by("name").descending());
	}
	
	@GetMapping("/get/{page}")
	public List<Person> myFindAllByPage(@PathVariable Integer page) {
		return repo.findAll(PageRequest.of(page, 2)).getContent();
	}

}
