package com;

import java.util.Scanner;
public class test1 {
    public static void main(String [] args)
    {
        String aa;
        String bb;
        String cc;
        System.out.println("请输入三角形的三边: ");
        Scanner scanner=new Scanner(System.in);
        aa=scanner.next();
        bb=scanner.next();
        cc=scanner.next();
        if(aa.equals("-")||bb.equals("-")||cc.equals("-")){
            System.out.println("请输入数据");
        }else {
            int flag1=0;
            char[] a1=aa.toCharArray();
            char[] b1=bb.toCharArray();
            char[] c1=cc.toCharArray();

            for (char temp:a1) {
                if(temp=='.'){
                    flag1=1;
                }
            }
            for (char temp:b1) {
                if(temp=='.'){
                    flag1=1;
                }
            }
            for (char temp:c1) {
                if(temp=='.'){
                    flag1=1;
                }
            }
            //不含有小数
            if(flag1==0){
                double a=Double.parseDouble(aa);
                double b=Double.parseDouble(bb);
                double c=Double.parseDouble(cc);
                if(a<=0||b<=0||c<=0||a>100||b>100||c>100){
                    System.out.println("输入非法");
                }else {
                    //是否能构成三角形
                    if(a+b>c&&a+c>b&&b+c>a)
                    {
                        int flag=0;
                        //判断是否是等腰或等边三角形
                        if(a==b||a==c||b==c)
                        {
                            if(a==b&&a==c)
                            {
                                System.out.println("该三角形是等边三角形！");
                                flag=1;
                            }
                            else
                            {
                                System.out.println("该三角形是普通的等腰三角形！");
                                flag=1;
                            }
                        }
                        //判断是否是直角三角形
                        double r1=a*a+b*b-c*c;
                        double r2=a*a+c*c-b;
                        double r3=b*b+c*c-a*a;
                        if(r1==0||r2==0||r3==0)
                        {
                            System.out.println("该三角形是直角三角形！");
                            flag=1;
                        }
                        //一般三角形
                        if(flag==0){
                            System.out.println("该三角形是一般三角形");
                        }
                    }else {
                        System.out.println("不能构成三角形");
                    }
                }

            }else {
                System.out.println("含有小数，输入非法");
            }

        }
    }
}