class Solution {
    int value(char ch)
    {
        if(ch=='I')
            return 1;
        if(ch=='V')
            return 5;
        if(ch=='X')
            return 10;
        if(ch=='L')
            return 50;
        if(ch=='C')
            return 100;
        if(ch=='D')
            return 500;
        if(ch=='M')
            return 1000;
        else
return 0;    }

    public int romanToInt(String s) {
        int n = s.length();
        int ans = value(s.charAt(n-1));
        for(int i=n-2;i>=0;i--)
        {
           int cur = value(s.charAt(i));
           int next = value(s.charAt(i+1));
           if(cur<next)
           {
               ans-=cur;
           }
           else
           {
               ans+=cur;
           }
        }
        return ans;

    }
}