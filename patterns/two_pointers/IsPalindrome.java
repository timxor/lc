class ValidPalindrome {

    public static String isPalindrome(String s) {
        System.out.println("String to check: " + s + ". Length of string: " + s.length());
        int left = 0;
        int right = s.length() - 1;
        int i = 1;
        // The terminating condition for the loop is when both the pointers reach the same element or when they cross each other.
        while (left < right) {
            System.out.println("In iteration " + i + ", left = " + left + ", right = " + right);
            System.out.println("The current element being pointed to by the left pointer is '" + s.charAt(left) + "'");
            System.out.println("The current element being pointed to by the right pointer is '" + s.charAt(right) + "'");
            left = left + 1; // Heading towards the right
            right = right - 1; // Heading towards the left
            i = i + 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        System.out.println("Loop terminated with left = " + left + ", right = " + right);
        return "The pointers have either reached the same index, or have crossed each other, hence we don't need to look further.";
    }

    //Driver code
    public static void main(String[] arg) {
        String[] testCase = {
                "RACECAR",
                "ABBA",
                "TART"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case # " + (k + 1));
            System.out.println(isPalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}




















