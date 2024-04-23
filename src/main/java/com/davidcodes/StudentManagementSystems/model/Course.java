package com.davidcodes.StudentManagementSystems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "students")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @Column(name = "courseId")
    private String courseId;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "department")
    private String department;

    @Column(name = "courseDocumentLink")
    private String courseDocumentLink;

}
