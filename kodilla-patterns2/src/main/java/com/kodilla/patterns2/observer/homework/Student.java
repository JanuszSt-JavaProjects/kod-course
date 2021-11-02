package com.kodilla.patterns2.observer.homework;

public class Student {
   private int id;
   private String name;

   public Student(int id, String name) {
      this.id = id;
      this.name = name;
   }

   @Override
   public String toString() {
      return "Student{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
   }
}