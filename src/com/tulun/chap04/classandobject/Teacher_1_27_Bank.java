package com.tulun.chap04.classandobject;

import java.util.Arrays;

/**
 * @author : nanjing
 * @date : 20:39 2021/1/25
 */
public class Teacher_1_27_Bank {
    private String bankName;
    private Teacher_1_27_BankCard[] userCards;
    private int size;// 存储的有效银行卡的个数
    public Teacher_1_27_Bank(String bankName){
        this.bankName = bankName;
        userCards = new Teacher_1_27_BankCard[10];
    }
    public void add(int id,int passwd){
        if(size == userCards.length){
            userCards = Arrays.copyOf(userCards,userCards.length*2);
        }
        userCards[size ++] = new Teacher_1_27_BankCard(id,passwd);
    }
    public boolean search(int id,int passwd){
        for(int i = 0;i<size;i++){
            if(userCards[i].getId() == id && userCards[i].getPasswd() == passwd){
                return true;
            }
        }
        return false;
    }

}
