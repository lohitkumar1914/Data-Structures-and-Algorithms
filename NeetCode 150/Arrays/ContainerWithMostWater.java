class Solution {
    public int maxArea(int[] height) {
       int left=0;
        int right=height.length-1;
        int max_area=0;
        while(left<right){
            max_area=Math.max(max_area,(right-left)* Math.min(height[right],height[left]));
            if(height[left]<height[right]){
                left++;
            }else{
            right--;
        }
        }
        return max_area;
    }
}