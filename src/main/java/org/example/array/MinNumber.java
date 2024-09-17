package org.example.array;

public class MinNumber {

    public int MinNumber (int[] array) {

        //edge
        if(array == null || array .length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int minNum = 0;

        for (int i = 0; i < array.length; i++) {

            if(array[i] > minNum) {
                minNum = array[i];
            };
        }

        return minNum;

    }

    public int secondMax (int[] arr) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            //edge case incase the value is greater than the second max
            //but less than and not equal to max
            else if(arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    //we can solve this problem using the sum of nth term formular
    public int findMissingNo(int[] arr) {
        int len = arr.length + 1;
        int sum = (len * (len + 1))/2;
        for(int num:arr) {
            sum-=num;
        }
        return sum;
    }

    public static void main (String[] args) {
        int[] egArr = new int[]{1,4,7,2,5,6};
        MinNumber minNumber = new MinNumber();

        System.out.println(minNumber.findMissingNo(egArr));

    }
}
