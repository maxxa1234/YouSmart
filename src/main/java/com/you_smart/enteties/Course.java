package com.you_smart.enteties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name = "type")
    private  String  type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private User user;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn (name = "course_id"),
            inverseJoinColumns = @JoinColumn (name = "student_id")
    )
    private Set<User> students;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(User user) {
        this.students.add(user);
    }
}
