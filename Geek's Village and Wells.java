import java.util.*;
import java.io.*;

class Gfg 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0)
        {  
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++)
            {
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++)
                    c[i][j]=s[j].charAt(0);
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                out.println();
            }
        }
        out.close();
    }
}


class Solution
{
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};    
    private boolean areCoordinatesValid(int row, int col, int n, int m) 
    {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int[][] output = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i < n; i++) 
        {
            for (int j=0; j < m; j++) 
            {
                if (c[i][j] == 'W')
                    queue.offer(new int[]{0, i, j});
            }
        }        
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            while (size-- > 0) 
            {
                int[] curr = queue.poll();
                int row = curr[1];
                int col = curr[2];
                int dist = curr[0];
                for (int[] dir : dirs) 
                {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];
                    if (areCoordinatesValid(nRow, nCol, n, m) && output[nRow][nCol] == 0 && c[nRow][nCol] != 'N' && c[nRow][nCol] != 'W') 
                    {
                        queue.offer(new int[]{dist + 1, nRow, nCol});
                        output[nRow][nCol] = dist + 1;
                        
                    }    
                }
            }
        }
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (c[i][j] == '.') {
                    output[i][j] = 0;
                }
                else if (c[i][j] == 'H') {
                    if (output[i][j] == 0) {
                        output[i][j] = -1;
                    } else {
                        output[i][j] = 2 * output[i][j];
                    }
                } 
            }
        }
        return output;
    }
}
