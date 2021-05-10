package com.tulun.chap04.classandobject;

import java.util.Scanner;

/**
 * @author : nanjing
 * @date : 20:34 2021/1/25
 */

public class Teacher_1_27_ATM {//注意替换类名
    private Teacher_1_27_Bank bank; // 存储用户 银行卡信息（BankCard[]）

    public Teacher_1_27_ATM() {
        this.bank = new Teacher_1_27_Bank("招行");
    }

    private boolean register(int id,int passwd){ // 卡  存储在数组中
        // 如果以前注册过， 注册失败。
        boolean result = bank.search(id,passwd);
        if(result){ // 找到卡  注册失败
            return false;
        }
        bank.add(id,passwd);
        return true;
    }
    private boolean login(int id ,int passwd){
        // id,passwd  在数组中查找是否包含了这个卡，查找到了 登陆成功，否则 失败
        return  bank.search(id,passwd);
    }
    public void start() { // ATM开机
        while (true) {
            System.out.println("1.注册 2.登陆 3.关机");
            Scanner scanner = new Scanner(System.in);
            int chioce = scanner.nextInt();
            if (chioce == 3) {
                break;
            }
            System.out.println("请输入账号密码：");
            int id = scanner.nextInt();
            int passwd = scanner.nextInt();

            switch (chioce) {
                case 1:
                    boolean result = register(id,passwd);
                    if(result){
                        System.out.println("注册成功");
                    }else{
                        System.out.println("注册失败");
                    }
                    break;
                case 2:
                    result = login(id,passwd);
                    if(result){
                        System.out.println("登陆成功");
                        // 封装登陆成功后的操作TODO:  考虑：如何获取登陆成功的这张卡    afterLoginSuccess( )
                        System.out.println("1.取款2.存款3.转账 4.查余额 5退卡");
                        switch (chioce){
                            case 1:
                                break;
                            case 2:
                             //   ............
                        }
                    }else{
                        System.out.println("登陆失败");
                    }
                    break;
            }
        }
    }
}
