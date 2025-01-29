class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int current=0;
        for(int num:nums){
            if(count==0)
                current=num;
            if(num==current){
                count++;
            }
            else{
                count--;
            }
        }
        return current;
    }
}