package com.obj.exercise;

public class StockTest {
    public static void main(String[] args) {
        Stock st = new Stock("ORCL", "Oracle", 34.5, 33.35);
        System.out.println("symbol: " + st.symbol + ", current price: " + st.getCurrentP() +
                ", current price change percentage: " + st.getChangePercentage() + "%");
        st.setCurrentP(40); // invoking setCurrentP(); does not need to use getCurrentP()
        System.out.printf("symbol: %s, current price: %.2f, current price change percentage: %.2f%%",
                st.symbol, st.getCurrentP(), st.getChangePercentage());

    }


}
