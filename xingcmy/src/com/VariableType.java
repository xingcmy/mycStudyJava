package com;

import com.cn.TypeCmd;

import java.io.File;

public class VariableType {
    public VariableType(){

    }
    public static int getType(Object data){
        if (data instanceof String){
            return TypeCmd.STRING;
        }else if (data instanceof Integer){
            return TypeCmd.INT;
        }else if (data instanceof File){
            return TypeCmd.FILE;
        }else if (data instanceof StringBuffer){
            return TypeCmd.STRINGBUFFER;
        }else if (data instanceof StringBuilder){
            return TypeCmd.STRINGBUILDER;
        }else if (data instanceof Double){
            return TypeCmd.DOUBLE;
        }else if (data instanceof Float){
            return TypeCmd.FLOAT;
        }else if (data instanceof Short){
            return TypeCmd.SHORT;
        }else if (data instanceof Long){
            return TypeCmd.LONG;
        }else if (data instanceof Byte){
            return TypeCmd.BYTE;
        }else if (data instanceof Character){

        }else if (data instanceof Boolean){
            return TypeCmd.BOOLEAN;
        }
        return 1024;
    }
}
