package com.example.smarthealthcare.service.impl;

import com.example.smarthealthcare.mapper.RecordMapper;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.pagination_illnessrecord;
import com.example.smarthealthcare.service.IllnessRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessRecordImpl implements IllnessRecordService {

    @Autowired
    private RecordMapper recordMapper;
  public pagination_illnessrecord getAllRecord(Integer indentify, IllnessRecord i,Integer pageSize, Integer currentPage){

      if(indentify==3)
      {
          PageHelper.startPage(currentPage,pageSize);

          List<IllnessRecord> illnessRecordList=recordMapper.getAllRecord(i);
          Page<IllnessRecord> p=(Page<IllnessRecord>) illnessRecordList;
          pagination_illnessrecord pagination_illnessrecord=new pagination_illnessrecord(p.getResult(),p.getTotal());

          return pagination_illnessrecord;
      }




      else
          return null;
    }

}
