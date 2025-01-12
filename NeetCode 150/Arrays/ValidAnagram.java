class Solution {
    public boolean isAnagram(String s, String t) {
        int freq1[] = new int [256];
        int freq2[] = new int[256];
        int n=  s.length();
        int m = t.length();
        if(n!=m)
            return false;
        for(int i=0;i<n;i++)
        {
            int asc =s.charAt(i);
            freq1[asc] = freq1[asc]+1;
        
        }
        for(int i=0;i<n;i++)
        {
            int asc =t.charAt(i);
            freq2[asc] = freq2[asc]+1;
        }
        for (int i=0;i<256;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }return true;
    }
}