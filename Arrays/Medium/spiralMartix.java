class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int row = matrix.length;
        int col = matrix[0].length;

        int tot = row * col;
        //int ans[] = new int[tot];
        List<Integer> ans = new ArrayList<>();
        int k =0;

        int d = 0;
        int sr = 0, er = row-1, sc = 0, ec = col -1;

        while(sr<=er && sc<=ec)
        {
            if(d == 0)
            {
                for(int i = sc;i<=ec;i++){
                    ans.add(matrix[sr][i]);}
                d++;
                sr++;
            }
            else if(d==1)
            {
                for(int i=sr;i<=er;i++)
                    ans.add(matrix[i][ec]);
                ec--;
                d++;
            }
            else if(d==2)
            {
                for(int i = ec;i>=sc;i--)
                    ans.add(matrix[er][i]);
                d++;
                er--;
            }
            else
            {
                for(int i=er;i>=sr;i--)
                    ans.add(matrix[i][sc]);
                d=0;
                sc++;
            }
        }

        return ans;





    }
}