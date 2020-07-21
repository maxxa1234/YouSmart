package com.you_smart.repositories;

import com.you_smart.enteties.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
