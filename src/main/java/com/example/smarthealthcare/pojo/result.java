package com.example.smarthealthcare.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class result {
    private Integer code;
    private String msg;
    private Object data;

    private Integer indentify;
    public static result success(Object data){
        return new result(1,"success",data,null);
    }

    public static result success(Object data,Integer kind){return new result(1,"success",data,kind);}
    public static result success(){
        return new result(1,"success",null,null);
    }

    public static result error(String msg){
        return new result(0,msg,null,null);
    }

    public static result error(String msg,Integer kind){return new result(0,msg,null,kind);}
}
