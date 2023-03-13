import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}


//User function Template for Java
class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        int n = matrix.length;
        int x0 = 0, y0 = 0;
        long[] rowRed = new long[n];
        long[] colRed = new long[n];
        long leftDiagRed = 0;
        long rightDiagRed = 0;
        for(int i = 0; i < n; ++i) {
            leftDiagRed += matrix[i][i];
            rightDiagRed += matrix[i][n - i - 1];
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    x0 = i;
                    y0 = j;
                }
                rowRed[i] += matrix[i][j];
                colRed[j] += matrix[i][j];
            }
        }
        
        long colReqSum = y0 != 0 ? colRed[y0 - 1] : colRed[y0 + 1];
        long rowReqSum = x0 != 0 ? rowRed[x0 - 1] : rowRed[x0 + 1];
        long diff = colReqSum - colRed[y0];
        if(diff <= 0 || diff != rowReqSum - rowRed[x0]) {
            return -1;
        }
        if(x0 == y0) {
            leftDiagRed += diff;
        }
        if(x0 == (n - y0 - 1)) {
            rightDiagRed += diff;
        }
        if(leftDiagRed != rightDiagRed) {
            return -1;
        }
        rowRed[x0] += diff;
        colRed[y0] += diff;
        for(long num : rowRed) {
            if(num != leftDiagRed) {
                return -1;
            }
        }
        for(long num : colRed) {
            if(num != rightDiagRed) {
                return -1;
            }
        }
        return diff;
    }
}
