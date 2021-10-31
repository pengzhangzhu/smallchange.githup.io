package com.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
        //零钱通菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key;
        //零钱通明细
        String details = "__________零钱通明细___________";
        //零钱通入账
        double money;
        double balance = 0.0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        //消费金额
        double fee;
        String consume;
        //退出优化

    public void menu(){
        do{
            System.out.println("==========零件通菜单========");
            System.out.println("\t\t\t1 零件通明细");
            System.out.println("\t\t\t2 零件通入账");
            System.out.println("\t\t\t3 消费金额");
            System.out.println("\t\t\t4 退出");
            System.out.print("请选择（1-4）: ");
            key = scanner.next();

            switch(key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.fee();
                    break;
                case "4":
                   this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新输入");
            }
        }while (loop);
    }
    public void detail(){
        System.out.println(details);
    }
    public void income(){
        System.out.println("请输入收益入账金额");
        money = scanner.nextDouble();
        if(money < 0){
            System.out.println("收益金额范围应该大于0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n" +"收益入账\t" + money +"\t" + sdf.format(date) + "\t" + balance;
        System.out.println(details);
    }
    public void fee(){
        System.out.println("请输入消费金额");
        fee = scanner.nextDouble();
        if (fee <= 0 || fee > balance){
            System.out.println("你的消费金额应该在0-" + balance);
            return;
        }
        System.out.println("请输入消费原因");
        consume = scanner.next();
        balance -= fee;
        details += "\n" +consume + "\t" + fee +"\t" + sdf.format(date) + "\t" + balance;
        System.out.println(details);
    }
    public void exit(){
        String choice;
        do {
            System.out.println("你确定要退出么？y/n");
            choice = scanner.next();
        } while (!choice.equals("y") && !choice.equals("n"));
        if(choice.equals("y")){
            loop = false;
        }
    }
}
