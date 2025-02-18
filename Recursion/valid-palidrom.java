class Solution {
  public boolean check(String st , int i , int n){
    if(i>=n/2) return true;
    if(st.charAt(i)!= st.charAt(n-i-1)) return false;

    return check(st , i+1 , n);
  }
    public boolean isPalindrome(String st) {
      st = st.replaceAll("[^a-zA-Z0-9]","").toLowerCase();;
      int n = st.length();
      return check(st,0,n);
    }
}