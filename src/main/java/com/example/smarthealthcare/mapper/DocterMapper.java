package com.example.smarthealthcare.mapper;

import com.example.smarthealthcare.pojo.Docter;
import com.example.smarthealthcare.pojo.IllnessRecord;
import com.example.smarthealthcare.pojo.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocterMapper {


    Docter getInfo(String userName);

    Integer getId(String userName);

    List<IllnessRecord> searchRecord(Integer userId, @Param("records") IllnessRecord record);

    void addRecord(Integer patientId, Integer docterId, @Param("records") IllnessRecord record);

    List<Reservation> getReservation(Integer docterId, Integer status, String patientName);

   void dealReservation(Integer id, Integer status);
}
