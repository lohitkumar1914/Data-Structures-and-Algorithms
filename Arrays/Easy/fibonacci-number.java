class Solution {
    public int fib(int n) {
        int a = 0 , b = 1;
        int sum = 0 ;
        if( n == 1 || n == 0)
        {
            return n;
        }
        for(int i=2;i<=n;i++)
        {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}