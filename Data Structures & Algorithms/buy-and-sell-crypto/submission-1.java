class Solution 
{
    private long minPrice = Long.MAX_VALUE;
    private long maxProfit = 0;

    public int maxProfit(int[] prices)
    {
        for (int price : prices)
        {
            addPrice(price);
        }
        return (int)getMaxProfit(); //Math.toIntExact(getMaxProfit());
    }

    public void addPrice(long price)
    {
        if (price < minPrice)
        {
            minPrice = price;
        }
        else if (price - minPrice > maxProfit)
        {
            maxProfit = price - minPrice;
        }
    }

    public long getMaxProfit()
    {
        return maxProfit;
    }

}
