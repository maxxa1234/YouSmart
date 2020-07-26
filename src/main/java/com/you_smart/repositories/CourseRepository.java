package com.you_smart.repositories;

import com.you_smart.enteties.Course;
import com.you_smart.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByUser(User user);

    Optional<Course> findById(Long id);
}
