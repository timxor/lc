/*

    -----------------------------------------------------------------------------------------------------------------
    Write an algorithm to determine if a number n is happy.
    -----------------------------------------------------------------------------------------------------------------
    A happy number is a number defined by the following process:

    * Starting with any positive integer, replace the number by the sum of the squares of its digits.
    * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    * Those numbers for which this process ends in 1 are happy.

    Return true if n is a happy number, and false if not.
     
    -----------------------------------------------------------------------------------------------------------------
    Example 1:
    Input: n = 19
    Output: true

    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

    Example 2:
    Input: n = 2
    Output: false
    -----------------------------------------------------------------------------------------------------------------

*/

/*

    Naive approach - time complexity = O(log n)
    
    Optimized approach - fast and slow pointers = O(log n), space complexity = O(1)

*/

// leetcode solution
// https://leetcode.com/problems/happy-number/editorial/

class HappyNumber {

     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}






// raul solution - div mod with hash set


class Solution {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}




















// educative solution
// 
class HappyNumberEducative {
  
  public static int sumOfSquaredDigits(int number) {
      int totalSum = 0;
      while (number != 0) {
        int digit = number % 10;
        number = number / 10;
        totalSum += (Math.pow(digit, 2));
      }
      return totalSum;
  }
  public static boolean isHappyNumber(int n) {
      int slowPointer = n; 
      int fastPointer = sumOfSquaredDigits(n); 

      while (fastPointer != 1 && slowPointer != fastPointer) {
          slowPointer = sumOfSquaredDigits(slowPointer);
          fastPointer =  sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
      }
      return fastPointer == 1;
  }

  public static void main(String args[]) {
    int a[] = {1, 5, 19, 25, 7};
    for (int i = 0; i < a.length; i++) {
      System.out.println((i + 1) + ".\tInput Number: " + a[i]);
      String output = isHappyNumber(a[i]) ? "True" : "False";
      
      System.out.println("\n\tIs it a happy number? " + output);
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}











