// Tortoise.java
package com.reptile;
import com.mammal.Hare;

public class Tortoise extends Hare {
   protected void race(Hare hare) {
      hare.init();    // x1
      hare.race();    // x2
      System.out.print("tortoise-");
    }
    public static void main(String[] args) {
       var tortoise = new Tortoise();
       var hare = new Hare();
       tortoise.race(hare);
   } }
