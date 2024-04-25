package com.davidcodes.StudentManagementSystems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id") // Use the same column name as in Course entity
    private String studentId;

    @Column(name = "full_name") // Use underscore notation for column names
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "matrix_number")
    private String matrixNumber;

    @Column(name = "department")
    private String department;
}
