package com.example.smarthealthcare.service;

import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.pagination_illnessrecord;

import java.util.List;

public interface IllnessRecordService {

    pagination_illnessrecord getAllRecord(Integer indentify, IllnessRecord i, Integer pageSize, Integer currentPage);


}
