package Irl;


import java.util.Arrays;

public class ApexClearing
{


    public static void main(String[] args){
        init();

        testMaxProfit();
    }


    public static void init(){
        System.out.println();
        System.out.println("Starting ApexClearning.java");
        System.out.println();
        System.out.println("Stopping ApexClearning.java");
        System.out.println();
    }

     /*
            Best Time to Buy and Sell Stock

            Approach 2: One Pass

            Time Complexity: O(n)

            Space Complexity: O(1)

    */

    private static void testMaxProfit() {

        boolean testResult;

        int[] inputPrices = new int[]{7,1,5,3,6,4};
        int outputExpectedResult = 5;

        int outputActualResult = maxProfit(inputPrices);
        testResult = (outputExpectedResult == outputActualResult);

        System.out.println("Test results for 'testMaxProfit():    "+ testResult );
        System.out.println("    ");
        System.out.println("    inputPrices = " + Arrays.toString(inputPrices) );
        System.out.println("    outputExpectedResult = " + outputExpectedResult );
        System.out.println("    outputActualResult = " + outputActualResult );
        System.out.println("    ");
    }



    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}



/*

NBBO = National Best Bid and Offer

when buying
best available (lowest) offer price

when selling
best available (highest) bid price


sell(){
    double nbboSellOrder = findBestHighestBidPrice()
}



buy(){
    double nbboBuyOrder = findBestLowestOfferPrice()
}






 */