package Irl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;

public class ApexClearing
{

//    public void connect(InetAddress ipaddress, int port) throws IOException {
//
//        Socket endpoint = new Socket(ipaddress, port);
//    }
//

    public static void main(String[] args) throws UnknownHostException {

        HashMap<String, HashMap<String, Integer[]>> tickerToExchangeToPrice = new HashMap<String, HashMap<String, Integer[]>>();

        // connect to ip address and port
        InetAddress ipaddress = InetAddress.getByName("199.83.14.77");
        int port = 7777;


        BufferedReader reader;

        try {
            Socket endpoint = new Socket(ipaddress, port);
            reader = new BufferedReader(new InputStreamReader((endpoint.getInputStream()), "UTF-8") );

            StringBuilder inputStream = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);

                // streaming data comes in here


                // parse the input line and tokenize the : ticker, exchange, bid, offer


                String[] tokens = line.split("\\|");
                String orderType = tokens[0];

                if (orderType.equals("Q")) {
                    String ticker = tokens[1];
                    String exchange = tokens[2];
                    Integer bid = Integer.parseInt(tokens[3]);
                    Integer offer = Integer.parseInt(tokens[4]);
                    Integer[] newPrices = new Integer[]{bid, offer};

//                    System.out.println("ticker = " + ticker);
//                    System.out.println("exchange = " + exchange);
//                    System.out.println("bid = " + bid);
//                    System.out.println("offer = " + offer);

                    // check if the ticker exists or does not exist yet
                    if (tickerToExchangeToPrice.get(ticker) != null) {
                        // update exchange with new bid and offer integers
                        tickerToExchangeToPrice.get(ticker).put(exchange, newPrices);
                    } else {
                        // does not exist
                        HashMap<String, Integer[]> newTickerValue = new HashMap<String, Integer[]>();

                        newTickerValue.put(exchange, newPrices);
                        tickerToExchangeToPrice.put(ticker, newTickerValue);
                    }


                    // compute the mbbo for each new line that comes in
                    //        String NBBO = symbol + bestBid @ bestOffer

                    int currentBid = Integer.MIN_VALUE;
                    int currentOffer = Integer.MAX_VALUE;
                    for(String currentExchange : tickerToExchangeToPrice.get(ticker).keySet()) {
                        currentBid = Math.max(currentBid, tickerToExchangeToPrice.get(ticker).get(currentExchange)[0]);
                        currentOffer = Math.min(currentOffer, tickerToExchangeToPrice.get(ticker).get(currentExchange)[1]);
                    }
                    String NBBO = ticker + currentBid + " @ " + currentOffer;
                    System.out.println("NBBO for " + ticker + " = " + NBBO);
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        init();
//
//        double bestBid = Math.max(420.71, 420.70);
//        bestBid = Math.max(bestBid, 420.71);
//
//
//        double bestOffer = Math.min(420.76, 420.75);
//        bestOffer = Math.min(bestOffer, 420.75);


//        String NBBO = symbol bestBid @ bestOffer

//        System.out.println("bestOffer = "+ bestOffer);
//        System.out.println("bestBid = "+ bestBid);

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


            double bestBid = Math.max(420.70, 420.71);
            bestBid = Math.max(420.71, 420.70);

            double bestOffer =


 */








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

//    private static void testMaxProfit() {
//
//        boolean testResult;
//
//        int[] inputPrices = new int[]{7,1,5,3,6,4};
//        int outputExpectedResult = 5;
//
//        int outputActualResult = maxProfit(inputPrices);
//        testResult = (outputExpectedResult == outputActualResult);
//
//        System.out.println("Test results for 'testMaxProfit():    "+ testResult );
//        System.out.println("    ");
//        System.out.println("    inputPrices = " + Arrays.toString(inputPrices) );
//        System.out.println("    outputExpectedResult = " + outputExpectedResult );
//        System.out.println("    outputActualResult = " + outputActualResult );
//        System.out.println("    ");
//    }
//
//
//
//    public static int maxProfit(int[] prices) {
//        int minprice = Integer.MAX_VALUE;
//        int maxprofit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minprice)
//                minprice = prices[i];
//            else if (prices[i] - minprice > maxprofit)
//                maxprofit = prices[i] - minprice;
//        }
//        return maxprofit;
//    }



}



