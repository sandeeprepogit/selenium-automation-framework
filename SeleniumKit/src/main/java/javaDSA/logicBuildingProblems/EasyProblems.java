package javaDSA.logicBuildingProblems;

public class EasyProblems {

    //    Given a number n, find the sum of its digits.
    public int sumOfDigit(int n) {
        int sizeOfDigit = Integer.toString(n).length();
        int sum = 0;
        for (int i = 0; i < sizeOfDigit; i++) {
            sum = sizeOfDigit--;
        }
        return sum;
    }

    public String reverseAString(String string) {
        // get the length of trhe string and store in INT variable
        // iterate over the string and the all the characters from last to first and store in a temp variable
        int sizeOfString = string.length();
        String temp = "";
        for (int i = sizeOfString - 1; i >= 0; i--) {
            temp = temp + string.charAt(i);
        }
//        System.out.println("Using for loop we get:" + temp);
//        temp = new StringBuilder(temp).reverse().toString();
//        System.out.println("Using reverse method we get::" + temp);
        return temp;
    }

    public void reverseSentence(String sentence) {
        EasyProblems easyProblems = new EasyProblems();
        String[] str = sentence.split(" ");
        String temp = "";
        for (int i = str.length - 1; i >= 0; i--) {
            String reversed = easyProblems.reverseAString(str[i]);
            temp = temp + reversed + " ";
        }
        System.out.println("After reversing sentence::" + temp);

    }


}
