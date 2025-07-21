class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] incr = new int[security.length]; 
        int[] decr = new int[security.length]; 

        decr[0] = 0;

        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i - 1]) {
                decr[i] = decr[i - 1] + 1; 
            } else {
                decr[i] = 0; 
            }
        }

        incr[security.length - 1] = 0;

        for (int j = security.length - 2; j >= 0; j--) {
            if (security[j] <= security[j + 1]) {
                incr[j] = incr[j + 1] + 1;
            } else {
                incr[j] = 0; 
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = time; i < security.length - time; i++) {
            if (decr[i] >= time && incr[i] >= time) {
                ans.add(i); 
            }
        }
        return ans;
    }
}