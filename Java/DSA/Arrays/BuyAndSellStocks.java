import java.util.*;

class BuyAndSellStocks{
	/*
        here we have an array which have values
        1 2 5 6 87 6
        these are the stock prices, we have to find when we should buy and sell a stock
        remember, first we buy and then we sell it, 
            so buy index will be same or less than sell index
    */
    int[] a = {7,1,5,3,6,4};
    int minBuyingPrice = a[0];
    int maxSellingPrice = 0;
    for (int i = 1; i < a.length ; i++) {
        int cost = a[i] - minBuyingPrice;
        maxSellingPrice = Math.max(cost, maxSellingPrice);
        minBuyingPrice = Math.min(minBuyingPrice, a[i]);
    }
    System.out.println("minBuyingPrice : "+minBuyingPrice);
    System.out.println("maxSellingPrice : "+maxSellingPrice);
}