class Solution{
    public int maxProfit(int[] prices){
        int n=prices.length;
        int maxDiff = 0;
        int minPrice = Integer.MAX_VALUE;   

        for(int i=0;i<n;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i]; 
            }
            else if(prices[i]-minPrice>maxDiff){
                maxDiff = prices[i]-minPrice;
            }

        }
        return maxDiff;
    }
}