package com.mytest2222;


import java.util.Calendar;

public class main {
    public static void main(String[] args) {



        //People people1=new People("张三","34220119510218061X","机关事业","副处长","退休",false);
        People people1=new People("张三","34220119550218062X","机关事业","普通职工",false,false);
        //注：positon的判断依据为 是否为普通职工

        People entirePeople=entirePeople(people1);//根据身份证完善people信息
        System.out.println(entirePeople);

        double[] a=function(entirePeople,"一级医院",60000,1);//a[0]为可报销多少钱，a[1]为应付多少钱

        System.out.println("可报销"+a[0]+"元，"+"应付"+a[1]+"元。");

    }

    public static People entirePeople(People people){//完善整体people信息
        People entirePeople=people;
        String id=people.getId();
        Calendar date=Calendar.getInstance();
        int nowyear=Integer.valueOf(date.get(Calendar.YEAR));//获得当前系统年份
        int year=Integer.valueOf(id.substring(6,10));//用户的出生年
        int age=nowyear-year;
        entirePeople.setAge(age);

        int sex=Integer.valueOf(id.substring(16,17));//获取身份证号的倒数第二位

        if(people.isEarly()){
            entirePeople.setState("退休");
        }else {
            if(sex==1||age==3||age==5||age==7||age==9){//判断男女
                entirePeople.setSex("男");
                if(people.getNature().equals("机关事业")){
                    if(age>=60){
                        entirePeople.setState("退休");
                    }else {
                        entirePeople.setState("在职");
                    }
                }else {//在企业单位
                    if(age>=55){
                        entirePeople.setState("退休");
                    }else {
                        entirePeople.setState("在职");
                    }
                }
            }else
            {
                entirePeople.setSex("女");
                if(people.getNature().equals("机关事业")){
                    if(people.getPosition().equals("普通职工")){
                        if(age>=55){
                            entirePeople.setState("退休");
                        }else {
                            entirePeople.setState("在职");
                        }
                    }else {
                        if(age>=60){
                            entirePeople.setState("退休");
                        }else {
                            entirePeople.setState("在职");
                        }
                    }
                }else {//在企业单位
                    if(people.getPosition().equals("普通职工")){
                        if(age>=50){
                            entirePeople.setState("退休");
                        }else {
                            entirePeople.setState("在职");
                        }
                    }else {
                        if(age>=55){
                            entirePeople.setState("退休");
                        }else {
                            entirePeople.setState("在职");
                        }
                    }
                }
            }
        }


        return entirePeople;
    }

    public static double[] function(People people,String hospital,double price,int time){
        double result=0;//可以报销的总钱
        if(hospital.equals("一级医院")){
            if(time==1){//第一次
                if(price<=800){
                    result=0;
                }else {
                    if(people.getState().equals("在职")){
                            if(price<=55000+800){
                                result=(price-800)*0.85;
                            }
                            if(price<150000+800&&price>55000+800) {
                                result=55000*0.85+(price-800-55000)*0.80;
                            }
                            if(price>=150000+800) {
                                result=55000*0.85+(150000-55000)*0.80;
                            }
                    }else {//不在职
                        if(people.getAge()>=70||people.isLaomo()){//老工人或者劳模
                            if(price<=150000+800){
                                result=(price-800)*0.95;
                            }else {
                                result=150000*0.95;
                            }
                        }else {//非老工人或劳模
                            if(price<=55000+800){
                                result=(price-800)*0.90;
                            }
                            if(price<150000+800&&price>55000+800) {
                                result=55000*0.90+(price-800-55000)*0.80;
                            }
                            if(price>=150000+800) {
                                result=55000*0.90+(150000-55000)*0.80;
                            }

                        }
                    }
                }
            }else {//非第一次
                if(price<=270){
                    result=0;
                }else {
                    if(people.getState().equals("在职")){
                        if(price<=55000+270){
                            result=(price-270)*0.85;
                        }
                        if(price<150000+270&&price>55000+270) {
                            result=55000*0.85+(price-270-55000)*0.80;
                        }
                        if(price>=150000+270) {
                            result=55000*0.85+(150000-55000)*0.80;
                        }
                    }else {//不在职
                        if(people.getAge()>=70||people.isLaomo()){//老工人或者劳模
                            if(price<=150000+270){
                                result=(price-270)*0.95;
                            }else {
                                result=150000*0.95;
                            }
                        }else {//非老工人或劳模
                            if(price<=55000+270){
                                result=(price-270)*0.90;
                            }
                            if(price<150000+270&&price>55000+270) {
                                result=55000*0.90+(price-270-55000)*0.80;
                            }
                            if(price>=150000+270) {
                                result=55000*0.90+(150000-55000)*0.80;
                            }
                        }
                    }
                }
            }
        }


        if(hospital.equals("二级医院")){
            if(time==1){//第一次
                if(price<=1100){
                    result=0;
                }else {
                    if(people.getState().equals("在职")){
                        if(price<=55000+1100){
                            result=(price-1100)*0.85;
                        }
                        if(price<150000+1100&&price>55000+1100) {
                            result=55000*0.85+(price-1100-55000)*0.80;
                        }
                        if(price>=150000+1100) {
                            result=55000*0.85+(150000-55000)*0.80;
                        }
                    }else {//不在职
                        if(people.getAge()>=70||people.isLaomo()){//老工人或者劳模
                            if(price<=150000+1100){
                                result=(price-1100)*0.95;
                            }else {
                                result=150000*0.95;
                            }
                        }else {//非老工人或劳模
                            if(price<=55000+1100){
                                result=(price-1100)*0.90;
                            }
                            if(price<150000+1100&&price>55000+1100) {
                                result=55000*0.90+(price-1100-55000)*0.80;
                            }
                            if(price>=150000+1100) {
                                result=55000*0.90+(150000-55000)*0.80;
                            }

                        }
                    }
                }
            }else {//非第一次
                if(price<=350){
                    result=0;
                }else {
                    if(people.getState().equals("在职")){
                        if(price<=55000+350){
                            result=(price-350)*0.85;
                        }
                        if(price<150000+350&&price>55000+350) {
                            result=55000*0.85+(price-350-55000)*0.80;
                        }
                        if(price>=150000+350) {
                            result=55000*0.85+(150000-55000)*0.80;
                        }
                    }else {//不在职
                        if(people.getAge()>=70||people.isLaomo()){//老工人或者劳模
                            if(price<=150000+350){
                                result=(price-350)*0.95;
                            }else {
                                result=150000*0.95;
                            }
                        }else {//非老工人或劳模
                            if(price<=55000+350){
                                result=(price-350)*0.90;
                            }
                            if(price<150000+350&&price>55000+350) {
                                result=55000*0.90+(price-350-55000)*0.80;
                            }
                            if(price>=150000+270) {
                                result=55000*0.90+(150000-55000)*0.80;
                            }
                        }
                    }
                }
            }
        }


        if(hospital.equals("三级医院")){
            if(time==1){//第一次
                if(price<=1700){
                    result=0;
                }else {
                    if(people.getState().equals("在职")){
                        if(price<=55000+1700){
                            result=(price-1700)*0.85;
                        }
                        if(price<150000+1700&&price>55000+1700) {
                            result=55000*0.85+(price-1700-55000)*0.80;
                        }
                        if(price>=150000+1700) {
                            result=55000*0.85+(150000-55000)*0.80;
                        }
                    }else {//不在职
                        if(people.getAge()>=70||people.isLaomo()){//老工人或者劳模
                            if(price<=150000+1700){
                                result=(price-1700)*0.95;
                            }else {
                                result=150000*0.95;
                            }
                        }else {//非老工人或劳模
                            if(price<=55000+1700){
                                result=(price-1700)*0.90;
                            }
                            if(price<150000+1700&&price>55000+1700) {
                                result=55000*0.90+(price-1700-55000)*0.80;
                            }
                            if(price>=150000+1700) {
                                result=55000*0.90+(150000-55000)*0.80;
                            }

                        }
                    }
                }
            }else {//非第一次
                if(price<=500){
                    result=0;
                }else {
                    if(people.getState().equals("在职")){
                        if(price<=55000+500){
                            result=(price-500)*0.85;
                        }
                        if(price<150000+500&&price>55000+500) {
                            result=55000*0.85+(price-500-55000)*0.80;
                        }
                        if(price>=150000+500) {
                            result=55000*0.85+(150000-55000)*0.80;
                        }
                    }else {//不在职
                        if(people.getAge()>=70||people.isLaomo()){//老工人或者劳模
                            if(price<=150000+500){
                                result=(price-500)*0.95;
                            }else {
                                result=150000*0.95;
                            }
                        }else {//非老工人或劳模
                            if(price<=55000+500){
                                result=(price-500)*0.90;
                            }
                            if(price<150000+500&&price>55000+500) {
                                result=55000*0.90+(price-500-55000)*0.80;
                            }
                            if(price>=150000+500) {
                                result=55000*0.90+(150000-55000)*0.80;
                            }
                        }
                    }
                }
            }
        }

        double[] a=new double[2];
        a[0]=result;//报销
        a[1]=price-result;//应付多少钱
        return a;
    }
}





class People{
    private String name;//姓名
    private String id;//身份证号
    private String nature;//单位性质
    private String position;//职务
    private String state;//就业状态
    private boolean laomo;//是否劳模
    private int age;//年龄
    private String sex;//性别
    private boolean early;//是否提前退休


    public People(){};

    public People(String name, String id, String nature, String position, boolean laomo,boolean early) {
        this.name = name;
        this.id = id;
        this.nature = nature;
        this.position = position;
        this.laomo = laomo;
        this.early=early;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", nature='" + nature + '\'' +
                ", position='" + position + '\'' +
                ", state='" + state + '\'' +
                ", laomo=" + laomo +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isLaomo() {
        return laomo;
    }

    public void setLaomo(boolean laomo) {
        this.laomo = laomo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isEarly() {
        return early;
    }

    public void setEarly(boolean early) {
        this.early = early;
    }
}
