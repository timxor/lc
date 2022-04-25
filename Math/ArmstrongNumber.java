package Math;

// https://leetcode.com/problems/armstrong-number/

// memory bank
//
// convert int to String
//          String nString = Integer.toString(n)
//
// get length of an int
//          int length = String.valueOf(n).length()
//
// convert int to int[] array
//          int digits[] = new int[length]
//          for.... digits[i] = nString.charAt(i) - '0'
//
//

public class ArmstrongNumber {

    public boolean isArmstrong(int n) {

        boolean isArmstrongNumber = false;
        String nString = Integer.toString(n);
        int length = String.valueOf(n).length();
        int sum = 0;

        int digits[] = new int[length];
        for(int i = 0; i < length; i++){
            digits[i] = nString.charAt(i) - '0';
        }

        for (int i = 0; i < length; i ++){
            sum += Math.pow(digits[i], length);
        }

        if (sum == n){isArmstrongNumber = true;}

        return isArmstrongNumber;
    }

}
