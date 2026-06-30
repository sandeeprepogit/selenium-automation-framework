package org.example;

import DBUtils.SQLconnection;
import javaDSA.logicBuildingProblems.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EasyProblems easy = new EasyProblems();
        BasicProblems BP = new BasicProblems();
        ArrayHelper arrHelp = new ArrayHelper();
//        BP.che ckEvenOrOdd(15);
//        BP.multiplicationTable(20);
//        System.out.println(BP.sumOfNatural2(20));
//        easy.reverseAString("Sandeep");
//        easy.reverseSentence("sandeep is an QA");
//        easy.factorialOfNumber(3);
//        easy.isPalindrome();


//        AddComplexNumber c1 = new AddComplexNumber(5, 3);
//        System.out.print("First number: ");
//        c1.show(); // Output: 5 + i3
//
//        // Create second complex number: 7 + 2i
//        AddComplexNumber c2 = new AddComplexNumber(7, 2);
//        System.out.print("Second number: ");
//        c2.show(); // Output: 7 + i2
//
//        // Add the two complex numbers
//        AddComplexNumber result = add(c1, c2);
//        System.out.print("Sum: ");
//        result.show(); // Output: 12 + i5

//        BankAccount bankAccount = new BankAccount();
//        bankAccount.fetchAccountDetails("10001");
//        System.out.println(bankAccount.getAccountNumber());
//        System.out.println(bankAccount.getBalance());
//        System.out.println(bankAccount.isActive());
//        bankAccount.deposit(1000);

//        easy.countChar();
//        arrHelp.sortIntAndStringDesc();


        Student[] students = {
                new Student(112, "Ram", "MP"),
                new Student(343, "Shyam", "UP"),
                new Student(254, "Hari", "Delhi")
        };
        Arrays.sort(students, new Student.SortByRoll());

        for (Student s: students){
            System.out.println(s);
        }



    }
}