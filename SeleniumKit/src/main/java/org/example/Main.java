package org.example;

import DBUtils.SQLconnection;
import javaDSA.logicBuildingProblems.BasicProblems;
import javaDSA.logicBuildingProblems.EasyProblems;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EasyProblems easy = new EasyProblems();
        BasicProblems BP = new BasicProblems();
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


        SQLconnection sqLconnection = new SQLconnection();
        sqLconnection.getConnection();

    }
}