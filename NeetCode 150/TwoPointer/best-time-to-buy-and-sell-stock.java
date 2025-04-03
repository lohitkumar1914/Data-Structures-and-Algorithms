
class Solution {
    public int maxProfit(int[] arr) {
        int minprice=arr[0];
        int profit=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            minprice=Math.min(arr[i],minprice);
            profit=arr[i]-minprice;
            max=Math.max(max,profit);
        }
    return max;
    }
}