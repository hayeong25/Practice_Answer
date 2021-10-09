package com.game;

public class User {
	
   private String name;
   private int point;
   private int temp;
   private int rank;
   
   public User() {
      rank = 0;
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getPoint() {
      return point;
   }
   public void setPoint(int point) {
      this.point = point;
   }
   public int getTemp() {
      return temp;
   }

   public void setTemp(int temp) {
      this.temp = temp;
   }
   public int getRank() {
      return rank;
   }
   public void setRank(int rank) {
      this.rank = rank;
   }
   
}