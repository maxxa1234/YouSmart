package com.you_smart.enteties;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;

    @OneToMany(mappedBy = "user")
    private Set<Course> courses;

//    @ManyToMany( cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "students_courses",
//            joinColumns = @JoinColumn (name = "student_id"),
//            inverseJoinColumns = @JoinColumn (name = "course_id")
//    )
    @ManyToMany(mappedBy = "students")
    private Set<Course> coursesForStudents;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Course> getCoursesForStudents() {
        return coursesForStudents;
    }

    public void setCoursesForStudents(Set<Course> coursesForStudents) {
        this.coursesForStudents = coursesForStudents;
    }
}
