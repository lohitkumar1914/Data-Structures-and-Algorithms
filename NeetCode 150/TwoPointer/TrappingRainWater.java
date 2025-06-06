class Solution {
    public int trap(int[] height) {
       int left = 0;
        int right = height.length - 1;
        
        int total = 0;
        int leftMax = height[0];
        int rightMax = height[right];
        
        while(left<right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                    total=total+leftMax-height[left];
                left++;
            }
            else{
                rightMax = Math.max(rightMax,height[right]);
                    total = total+rightMax-height[right];
                right--;
            }
        }
        return total;
    }
}