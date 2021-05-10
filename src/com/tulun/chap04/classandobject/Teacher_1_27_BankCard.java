package com.tulun.chap04.classandobject;

/**
 * @author : nanjing
 * @date : 20:45 2021/1/25
 */
public class Teacher_1_27_BankCard {
    private int id;
    private int passwd;
    private int money;

    //alt+insert  或者 右击Generate...  constructor

    public Teacher_1_27_BankCard(int id, int passwd) {
        this.id = id;
        this.passwd = passwd;
    }
    public int getId(){
        return id;
    }
    public int getPasswd(){
        return passwd;
    }
}
