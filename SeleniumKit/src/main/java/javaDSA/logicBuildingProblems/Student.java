package javaDSA.logicBuildingProblems;

import java.util.Comparator;

public class Student {

       int rollNumber;
       String name;
       String address;

       public Student(int rollNumber, String name, String address){
           this.rollNumber = rollNumber;
           this.name = name;
           this.address = address;
       }

       public String toString(){
           return "rollNumber::" + rollNumber + " | name::" + name + " | address::" + address;
       }

    public static class SortByRoll implements Comparator<Student> {

        public int compare(Student s1, Student s2){
            return s1.rollNumber - s2.rollNumber;
        }
    }







}
