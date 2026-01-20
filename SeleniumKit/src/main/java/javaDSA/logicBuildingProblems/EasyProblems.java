package javaDSA.logicBuildingProblems;

public class EasyProblems {

//    Given a number n, find the sum of its digits.

    public int sumOfDigit(int n){
        int sizeOfDigit=Integer.toString(n).length();
        int sum=0;
        for(int i=0;i<sizeOfDigit;i++){
            sum = sizeOfDigit --;
        }
        return sum;
    }


}
