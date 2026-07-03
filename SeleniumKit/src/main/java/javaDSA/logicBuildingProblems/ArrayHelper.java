package javaDSA.logicBuildingProblems;


import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class ArrayHelper {

    // Sort integer and character arrays in ascending order

    public void sortIntAndChar(){

        char[] ch = {'a', 'c', 'f', 'd'};
        int[] num = {1,4,6,3,7,};
        Arrays.sort(ch);
        Arrays.sort(num);
        System.out.println(Arrays.toString(ch));
        System.out.println(Arrays.toString(num));

    }

    // Descending Order Sorting

    public void sortIntAndStringDesc(){

        String[] str = {"jai", "apple", "sandeep", "pradeep", "piky"};
        Integer[] num = {1,4,6,3,7,};
        Arrays.sort(str, Collections.reverseOrder());
        Arrays.sort(num, Collections.reverseOrder());
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(num));

    }

    // Example To Sort Subarray

    public void subArray(){
        int[] array = {1,5,3,7,9,2};
        System.out.println(array.length);
        Arrays.sort(array, 2, array.length);
        System.out.println(Arrays.toString(array));
    }

    // Find the largest number from the array

    public static void largestNumber(){
        int[] arr = {2,5,3,7,9,8};
        int n  = arr.length;
        Arrays.sort(arr);
        System.out.println("Largest of array is::"+arr[n-1]);
    }

    // Find the second-largest number from the array
    public static void secondLargest(){
        int[] arr = {2,5,3,7,9,8};
        int n = arr.length;
        Arrays.sort(arr);
        int secondLarge = arr[n-2];
        System.out.println("secondLarge::"+secondLarge);
    }

    // Reverse an array
    public static void reverseAnArray(){
        int[] arr = {1,2,3,4,5,6};
        int n = arr.length;
        int[] temp = new int[n];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[n-1];
            n--;
        }
        System.out.println(Arrays.toString(temp));

    }

    // Move all zeros to end in an array
    public static void moveAllZeroAtEnd(){
        int[] arr = {1,0,2,0,8,5,3,0,5};
        int n = arr.length;
        int[] temp = new int[n];
        Arrays.sort(arr);
        int j =0;
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                temp[j] = arr[i];
                j++;
            }
        }
        while(j < n){
            temp[j++] = 0;
        }
        System.out.println(Arrays.toString(temp));
    }

    // Add +1 to every element in the array
    public static void addPlusOne(){
        int[] arr = {9,9,9,9,9};
        int n = arr.length;
        for(int i = 0; i < n; i++){
            arr[i] = arr[i] + 1;
        }
        System.out.println(Arrays.toString(arr));
    }


    // Remove duplicates from an array
    public static void removeDuplicatesArray(){
        int[] arr = {1,1,3,3,2,4,4,4,5,5,7,7,9,9};
        int n = arr.length;
        HashSet<Integer> s = new HashSet<>();
        Arrays.sort(arr);
        for(int i = 0; i < n ; i++){
            if(!s.contains(arr[i])){
                s.add(arr[i]);
            }
        }
        System.out.println(s);
    }

    // Get occurrence of duplicate elements
    public static void getCountDuplicateEle(){
        int[] arr = {1,3,4,5,6,3,4,65,7,8,4,3,23,344,5,56,66,6,6,65,64,34,3,3};
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j =0;
        for (int i = 0; i < n ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println(map);

    }

   public static int majorityElement() {
        int[] arr = {1, 1, 2, 1, 3, 5, 1,2,2,2,2};
        int n = arr.length;

        // Loop to consider each element as
        // a candidate for majority
        for (int i = 0; i < n; i++) {
            int count = 0;

            // Inner loop to count the frequency of arr[i]
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            // Check if count of arr[i] is more
            // than half the size of the array
            if (count > n / 2) {
                return arr[i];
            }
        }

        // If no majority element found, return -1
        return -1;
   }
   

   // Bubble sorting

    public static void bubbleSort(){
        int[] arr = {7, 8 ,3,2,1};
        int n = arr.length;
        for(int i =0; i< n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] >  arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i =0; i< n; i++){
            System.out.println(arr[i]);
        }

    }

    //selection sort
    public static void selectionSort(){
        int[] arr = {7,8,3,1,2};
        for(int i = 0; i < arr.length; i++){
            int smallest = i;
            for(int j =i+1;j<arr.length;j++){
                if(arr[smallest] > arr[j]){
                    smallest =j;
                }
            }
            //swap with smallest number

            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0;i<arr.length;i++){
            List list =new ArrayList();
            list.add(arr[i]);
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void majorityElementInArr(){
        int [] arr= {1,2,1,1,2,3,3,3,3};
        int n = arr.length;
        for(int val: arr){
            int count = 0;
            for(int ele : arr){
                if(val == ele){
                    count++;
                }
            }
            if (count > n/2){
                System.out.println(val+"is majority element");
                break;
            }
        }
    }

    public static int[] reverseArray(){
        int[] arr = {1,2,4,8,7,5,3};
        int first = 0;
        int last = arr.length-1;
        while(first < last){
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            first++;
            last--;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void isAnagram(String str1, String str2){
        str1 = "anagram";
        str2 = "nagaram";
        String sorted1 = "";
        String sorted2 = "";
        if(str1.length() != str2.length()){
            System.out.println(str1+ " and " + str2 + " are not anagram");
        }else{
            sorted1 = sortAnString(str1);
            sorted2 = sortAnString(str2);
        }
        if(sorted1.equals(sorted2)){
            System.out.println(str1+ " and " + str2 + " are anagram");
        }


    }


    public static String sortAnString(String str){
//        String str ="sandeep";
        char[] ch = str.toCharArray();
        for(int i =0; i <ch.length; i++){
            for (int j =0;j<ch.length-1-i;j++){
                if (ch[j] > ch[j+1]) {
                    char temp = ch[j];
                    ch[j]= ch[j+1];
                    ch[j+1] = temp;
                }
            }
        }
        System.out.println(String.valueOf(ch));
        return String.valueOf(ch);


    }

    public static void majorityElementFind(){
//        Given an array nums of size n, return the majority element.
//        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
        int [] arr = {2,2,1,1,1,2,2};
        int n= arr.length;

        // sort all the element
        for(int i=0; i<n-1;i++){
            for(int j =0; j<n-1-i;j++){
                if(arr[j] > arr[j+1]){
                    //swap the array value
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        //iterate and count the occorance of the element

        for (int i =0; i<n-1;i++){
            int count = 0;
           for(int j =0; j<n-1;j++){
               if(arr[i]==arr[j+1]){
                   count++;
               }
           }
            if(count>n/2){
                System.out.println(arr[i]+ " is mjr ele");
            }
        }

    }

    public static void mergeSortedArray(){
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,5,6};
        int[] finalArray = new int[nums1.length+nums2.length];
        for (int i=0; i<nums1.length;i++){
            finalArray[i] = nums1[i];
        }
        for (int i=0; i<nums2.length;i++){
            finalArray[nums1.length + i] = nums2[i];
        }
        System.out.println(Arrays.toString(finalArray));
        for(int i = 0; i< finalArray.length-1;i++){
            for (int j = 0; j < finalArray.length-1-i;j++){
                if(finalArray[j]>finalArray[j+1]){
                    int temp = finalArray[j];
                    finalArray[j] = finalArray[j+1];
                    finalArray[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(finalArray));

    }

    public static void findUniqueNumber(){
        int[] arr = {1,5,4,4,1,2,1,2};
        for (int i = 0; i < arr.length;i++){
            int count = 0;
            for (int j =0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(arr[i]);
            }
        }
    }

    // Find occorance of each character
    public static void occurrenceOfChar(){
        String str = "iiidmsjsjsmdndxuenmsdiksn";
        char[] ch= str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<ch.length;i++){
             if(map.containsKey(ch[i])){
                 map.put(ch[i],map.get(ch[i])+1);
             }else {
                 map.put(ch[i],1);
             }
        }
        System.out.println(map);
    }

    public static void sortColors(){
        int[] arr = {2,0,2,1,1,0};
        for(int i = 0;i<arr.length-1;i++){
            for(int j =0; j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void findDuplicate(){
        int[] arr = {1,3,4,2,2,4,4};
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0;i<arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }else{
                System.out.println(arr[i] + " is duplicate number");
            }
        }
    }

    public static boolean isPalindrome(){
        boolean flag= false;
        String s = "A man, a plan, a canal: Panama";
        s= s.replaceAll("[^a-zA-Z0-9 ]", "").replace(" ","").toLowerCase();
        System.out.println(s);
        char[] ch = s.toCharArray();
        String temp = "";
        for (int i=ch.length-1;i>=0;i--){
            temp =temp+ch[i];
        }
        System.out.println(temp);
        if (s.equals(temp)){
            flag =true;
        }
        System.out.println(flag);
        return flag;
    }

    public static boolean isAnagramString(String s, String t) {
        boolean flag = false;
        String str1 = new String(sortString(s));
        String str2 = new String(sortString(t));


        if(str1.equals(str2)){
            flag = true;
        }
        return flag;
    }

    public static String sortString(String str){
        char[] ch = str.toCharArray();
        for(int i =0; i < ch.length-1;i++){
            for(int j=0;j<ch.length-1-i;j++){
                if(ch[j] > ch[j+1]){
                    char temp = ch[j];
                    ch[j] = ch[j+1];
                    ch[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ch));
        return Arrays.toString(ch);
    }

    public static void main(String[] args) {
        System.out.println(isAnagramString("anagram","nagaram"));
    }

}
