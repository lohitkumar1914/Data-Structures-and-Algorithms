class Solution {
    public int longestConsecutive(int[] nums) {
      if (nums.length==0){
        return 0;
      }
      HashSet<Integer> numset = new HashSet<>();
      for(int i=0;i<nums.length;i++){
      numset.add(nums[i]);
    }
    int ans=1;
    for(int nim:numset){
        if(numset.contains(nim-1)){
            continue;
        }
        else{
            int currentnum=nim;
            int currentsub=1;
            while(numset.contains(currentnum+1)){
                currentnum++;
                currentsub++;

            }
            ans=Math.max(ans,currentsub);

        }
    }
    return ans;
}
}