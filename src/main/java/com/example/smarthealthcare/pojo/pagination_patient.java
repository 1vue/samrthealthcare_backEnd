package com.example.smarthealthcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class pagination_patient {
    private List<Patient> table;

    private Long total;
}
