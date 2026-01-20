package javaDSA.logicBuildingProblems;

public class BasicProblems {

//    Given a number n, check whether it is even or odd. Return true for even and false for odd.
    public boolean checkEvenOrOdd(int n){
        int rem = n%2;
        if(rem==1){
            System.out.println("Number "+n+" is even");
            return true;
        }else {
            System.out.println("Number "+n+" is even");
            return false;
        }
    }
//    Given a number n, we need to print its table.
    public void multiplicationTable(int n){
        for(int i=1;i<=10; i++ ){
            System.out.println(n +"*"+ i + "=" + n*i);
        }
   }

//    Program for sum of n natural numbers

    public int sumOfNatural(int n){
//        Calculate the sum of all integers from 1 to n by iterating through a loop.
        int sum = 0;
        for(int i =1;i<=n;i++){
            sum = sum+i;
        }
        return sum;
    }

    public int sumOfNatural2(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("n should be zero or a non-negative integer, as neither zero nor negative numbers are considered natural numbers.");
        }
        if (n == 1)
            return 1;
        return n + sumOfNatural2(n - 1);
    }

    public void swapNumbers(int x,int y){
        int temp = x;
        x=y;
        y=temp;
    }

}
