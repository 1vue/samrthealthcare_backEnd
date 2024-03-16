package com.example.smarthealthcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IllnessRecord {
    private String patientName;
    private String docterName;

//    疾病种类
    private String kind;

//    病情程度
    private String degree;

//    看病时间
    private LocalDateTime time;


}
