package com;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

public class Date {

    private String time;
    public Date(){
        super();
        SimpleDateFormat formatter=new SimpleDateFormat("YYYYMMddhhmmss");
        java.util.Date date=new java.util.Date(System.currentTimeMillis());
        this.time=formatter.format(date);
        //System.out.println(this.time);
    }

    public int getYear(){
        long fTime=Long.parseLong(time);
        int year= (int) (fTime/Math.pow(10,10));
        return year;
    }

    public int getYear(@NotNull String date){
        String dTime=null;
        int year=0;
        int l=date.length();
        if (l<8){
            dTime=time;
        }else {
            dTime=date;
        }
        int length=dTime.length();
        if (length==14){
            long fTime=Long.parseLong(dTime);
            if (fTime>Math.pow(10,13)){
                year= (int) (fTime/Math.pow(10,10));
            }
        }else if (length==8){
            Integer fTime=Integer.parseInt(dTime);
            year= (int) (fTime/Math.pow(10,4));
        }
        return year;
    }

    public int getYear(int date) throws Exception {
        if (date>Math.pow(10,7)){
            int year= (int) (date/Math.pow(10,4));
            return year;
        }else {
            throw new Exception("Time format error!");
        }
    }

    public int getYear(long date) throws Exception {
        if (date>Math.pow(10,13)){
            int year= (int) (date/Math.pow(10,10));
            return year;
        }else {
            throw new Exception("Time format error!");
        }
    }

    public int getMonth(){
        long fTime=Long.parseLong(time);
        int yearMonth= (int) (fTime/Math.pow(10,8));
        int month=yearMonth%100;
        return month;
    }

    public int getMonth(@NotNull String date){
        String dTime=null;
        int month=0;
        int l=date.length();
        if (l<8){
            dTime=time;
        }else {
            dTime=date;
        }
        int length=dTime.length();
        if (length==14){
            long fTime=Long.parseLong(dTime);
            if (fTime>Math.pow(10,13)){
                int yearMonth= (int) (fTime/Math.pow(10,8));
                month=yearMonth%100;
            }
        }else if (length==8){
            Integer fTime=Integer.parseInt(dTime);
            int yearMonth= (int) (fTime/Math.pow(10,2));
            month=yearMonth%100;
        }
        return month;
    }

    public int getMonth(int date) throws Exception {
        if (date>Math.pow(10,7)){
            int yearMonth= (int) (date/Math.pow(10,2));
            int month=yearMonth%100;
            return month;
        }else {
            throw new Exception("Time format error!");
        }

    }

    public int getMonth(long date) throws Exception {
        if (date > Math.pow(10, 13)) {
            int yearMonth = (int) (date / Math.pow(10, 8));
            int month = yearMonth % 100;
            return month;
        } else {
            throw new Exception("Time format error!");
        }
    }

    public int getDay(){
        long fTime=Long.parseLong(time);
        int yearMonthDay= (int) (fTime/Math.pow(10,6));
        int day=yearMonthDay%100;
        return day;
    }

    public int getDay(@NotNull String date){
        String dTime=null;
        int day=0;
        int l=date.length();
        if (l<8){
            dTime=time;
        }else {
            dTime=date;
        }
        int length=dTime.length();
        if (length==14){
            long fTime=Long.parseLong(dTime);
            if (fTime>Math.pow(10,13)){
                int yearMonthDay= (int) (fTime/Math.pow(10,6));
                day=yearMonthDay%100;
            }
        }else if (length==8){
            Integer fTime=Integer.parseInt(dTime);
            day=fTime%100;
        }
        return day;
    }

    public int getDay(int date)throws Exception{
        if (date>Math.pow(10,7)){
            int day=date%100;
            return day;
        }else {
            throw new Exception("Time format error!");
        }
    }
    public int getDay(long date) throws Exception {
        if (date>Math.pow(10,13)){
            int yearMonthDay= (int) (date/Math.pow(10,6));
            int day=yearMonthDay%100;
            return day;
        }else {
            throw new Exception("Time format error!");
        }
    }
}
