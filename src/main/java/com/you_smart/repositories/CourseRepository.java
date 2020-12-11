package com.you_smart.repositories;

import com.you_smart.enteties.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id);
}
