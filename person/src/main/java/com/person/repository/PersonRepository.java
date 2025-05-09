package com.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
