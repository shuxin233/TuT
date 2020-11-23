package com;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        int year;
        int month;
        int day;
        System.out.println("请输入年月日: ");
        Scanner scanner=new Scanner(System.in);
        year=scanner.nextInt();
        month=scanner.nextInt();
        day=scanner.nextInt();
        //是否合法
        if(check(year,month,day)){
            //是闰年
            if(checkyear(year)){
                //在二月
                if(month==2){
                    if(day==29){
                        month++;
                        day=1;
                    }else {
                        day++;
                    }
                }else {//不在二月
                    //一年的最后一天
                    if(day==checkmonth(month)&&month==12){
                        year++;
                        month=1;
                        day=1;
                    }else {
                        //月的最后一天
                        if(day==checkmonth(month)){
                            month++;
                            day=1;
                        }else {
                            day++;
                        }
                    }
                }
            }else {//不是闰年
                //一年的最后一天
                if(day==checkmonth(month)&&month==12){
                    year++;
                    month=1;
                    day=1;
                }else {
                    //月的最后一天
                    if(day==checkmonth(month)){
                        month++;
                        day=1;
                    }else {
                        day++;
                    }
                }
            }
            System.out.println("下一天为："+year+"年"+month+"月"+day+"日");

        }
        else {
            System.out.println("输入越界");
        }
    }
    public static boolean checkyear(int year){
        if(year % 4 == 0 && year % 100 != 0 && year % 200 != 0 && year % 300 != 0 || year % 400 == 0){
            return true;
        }else return false;
    }
    public static int checkmonth(int month){
      if(month==2){
          return 28;
      }
      if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
          return 31;
      }
      else return 30;
    }
    public static boolean check(int year,int month,int day){
        if(year<1900||year>2050)return false;
        if(month<1||month>12)return false;
        if(checkyear(year)&&month==2){
            if (day<1||day>29)return false;
        }else {
            if(day<1||day>checkmonth(month)){
                return false;
            }
        }
        return true;
    }
}



