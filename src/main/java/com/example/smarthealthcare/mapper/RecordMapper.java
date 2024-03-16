package com.example.smarthealthcare.mapper;

import com.example.smarthealthcare.pojo.IllnessRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    public List<IllnessRecord> getAllRecord( @Param("records") IllnessRecord i) ;
}
