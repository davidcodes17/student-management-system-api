package com.davidcodes.StudentManagementSystems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginStudent {
    private String email;
    private String matrixNumber;
}
