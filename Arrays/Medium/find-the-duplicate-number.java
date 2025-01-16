class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int x=Math.abs(nums[i]);
            if(nums[x]<0){
                return x;
            }
            nums[x]=-nums[x];
        }
        return -1;
    }
}