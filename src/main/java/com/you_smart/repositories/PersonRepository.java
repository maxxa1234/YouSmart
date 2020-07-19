package com.you_smart.repositories;

import com.you_smart.enteties.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
