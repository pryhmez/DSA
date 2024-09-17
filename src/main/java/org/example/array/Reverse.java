package org.example.array;

public class Reverse {

    //this is achievable using pointers
    public int[] reverseArray(int numbers[], int start, int end) {
        while(start < end ) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return numbers;
    }

    //using pointers i and j where i focuses on non-zero
    //while j focuses on zero components
    //we perform a swap when j is pointing to a zero component
    //and i is pointing to a nonzero component
    public int[] moveZeroes(int[] arr) {

        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }

        return arr;
    }

    public boolean isPalindrome(String text) {
        String[] word = text.split("");
        int i = 0;
        int j = word.length - 1;

        while(i < j) {

            if(!word[i].equals(word[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void printArray(int[] arr) {
       for(int number: arr) {
           System.out.print(number + " ");
       }
        System.out.println();
    }

    public int[] resizeArray(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return temp;
    }

    public static void main(String[] args)  {

        int[] egArray = new int[]{0, 4,5,24,4,5,0,0,0,0,4,0,43,1,0};
        boolean ans = false;

        Reverse rev = new Reverse();
//        rev.printArray(rev.reverseArray(rev.moveZeroes(egArray), 0, egArray.length-1));
//        rev.printArray(
//                rev.resizeArray(egArray, 20)
//        );
        ans = rev.isPalindrome("merrem");
        System.out.println(ans);

    }
}
