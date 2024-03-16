package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.RecordMapper;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.service.IllnessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessRecordImpl implements IllnessRecordService {

    @Autowired
    private RecordMapper recordMapper;
  public   List<IllnessRecord> getAllRecord(Integer indentify,IllnessRecord i){

      if(indentify==3)
        return recordMapper.getAllRecord(i);
      else
          return null;
    }

}
