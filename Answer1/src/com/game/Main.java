package com.game;

import java.util.Scanner;

public class Main {
   
   static Scanner sc = new Scanner(System.in);
   
   // MENU
   public static void showMenu() {
      System.out.println("======================= M E N U =======================");
      System.out.println("1 . Member Changer");
      System.out.println("2 . Show All Player");
      System.out.println("3 . Start");
      System.out.println("0 . Exit");
      System.out.println("=======================================================");
   }
   
   // 인원 변경 
   public static User[] changeMember() {
      
      System.out.print("게임에 참여할 인원을 입력해주세요 : ");
      int member = sc.nextInt();
      User[] user = new User[member];
            
      for(int i = 0; i < user.length; i++) {
         user[i] = new User();
         System.out.print((i + 1) + " Player Name : ");
         user[i].setName(sc.next());
         System.out.print(user[i].getName() + "'s Point : ");
         user[i].setPoint(sc.nextInt());
      }
      return user;
   }
   
   // Play Game
   public static User[] start(User[] user) {
      
      for(int i = 0; i < user.length; i++) {
         // 가장 낮은 점수가 당첨 ( 확률 조정 코드 )
         int rand = (int) (Math.random() * 1000000) + 1;
         user[i].setTemp((rand / ( user[i].getPoint() / 2 )));
      }
      user = inputRank(user);
      return user;
   }
   
   
   // Ranking System
   public static User[] inputRank(User[] user) {
      for(int i = 0; i < user.length; i++) {
         int userRank = user.length + 1;
         for(int j = 0; j < user.length; j++) {
            if(user[i].getTemp() >= user[j].getTemp()) {
               userRank--;
            }
         }
         user[i].setRank(userRank);
      }
      return user;
   }
   
   // 최종 출력
   public static void outResult(User[] user) {
      System.out.println("Name\tPoint\tResult\tRank");
      for(int i = 0; i < user.length; i++) {
         for(int j = 0; j < user.length; j++) {
            if(user[j].getRank() == (i + 1)) {
               System.out.println(user[j].getName() + "\t" + user[j].getPoint() + "\t" + user[j].getTemp() + "\t" + user[j].getRank());
            }
         }
      }
   }
   
   public static void main(String[] args) {
      
      User[] user = null;
      boolean memberChangeFlag = true;
      int userChoice;
      
      while(true) {
         // 인원 변경 메소드
         if(memberChangeFlag) {
            user = changeMember();
            memberChangeFlag = false;
         }
         
         showMenu();
         userChoice = sc.nextInt();
         
         switch(userChoice) {
            case 1 :
               memberChangeFlag = true;
               break;
            case 2 :
               for(int i = 0; i < user.length; i++) {
                  System.out.println((i + 1) + " : " + user[i].getName() + " / " + user[i].getPoint() + " / " + user[i].getRank());
               }
               break;
            case 3 :
               user = start(user);
               outResult(user);
               break;
            case 0 :
               sc.close();
               System.out.println("종료합니다.");
               System.exit(0);
            default :
               System.out.println("잘못 입력하셨습니다.");
               break;
         }
      }
   }
}