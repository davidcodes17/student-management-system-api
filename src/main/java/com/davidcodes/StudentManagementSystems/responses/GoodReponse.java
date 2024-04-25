package com.davidcodes.StudentManagementSystems.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodReponse {

    private String message;
    private Object data;
}
