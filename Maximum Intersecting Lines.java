import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int maxIntersections(int[][] lines, int N) 
    {
        TreeMap<Integer, Integer> lineMap = new TreeMap<>();
        for(int[] line : lines)
        {
            int start = line[0], end = line[1] + 1;
            lineMap.putIfAbsent(start, 0);
            lineMap.putIfAbsent(end, 0);
            lineMap.put(start, lineMap.get(start) + 1);
            lineMap.put(end, lineMap.get(end) - 1);
        }
        int res = 0, cnt = 0;
        for(Map.Entry<Integer, Integer> entry : lineMap.entrySet()){
            cnt = cnt + entry.getValue();
            res = Math.max(res, cnt);
        }
        return res;
    }
}
