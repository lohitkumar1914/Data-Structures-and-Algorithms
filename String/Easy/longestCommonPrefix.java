// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//          if (strs == null || strs.length == 0)
//             return "";
//         Arrays.sort(strs);
//         String first=strs[0];
//         String last=strs[strs.length - 1];
//         int minlength=Math.min(first.length(),last.length());
//         int i=0;
//         while(i<minlength && first.charAt(i)==last.charAt(i)){
//             i++;
//         }
//         if (i==0)
//             return "";

//         return first.substring(0,i);
         
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for(int i= 1 ; i<strs.length ; i++){
            while(!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0, prefix.length()-1);
            }
        }

        return prefix ;
        
    }
}