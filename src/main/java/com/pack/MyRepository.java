package com.pack;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<Person, Integer> {

}
