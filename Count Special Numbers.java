import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    static class FastReader
    { 
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        Integer nextInt(){
            return Integer.parseInt(next());
        }
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {
            int i = 0;
            int N = sc.nextInt();
            int arr[] = new int[(int)(N)];
            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            out.println(ob.countSpecialNumbers(N, arr));
        }
        out.flush();
    }
}



class Solution {
    public int countSpecialNumbers(int N, int arr[]) 
    {
        int max = -1;
        for(int n : arr){
            max = Math.max(max, n);
        }
        int[] hash = new int[max+1];
        int len = hash.length;
        for(int i=0; i<N; i++)
        {
            int start = arr[i];
            if(hash[start] <= 1)
            {
                for(int j=start; j<len; j=j+start)
                {
                    hash[j]++;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++){
            if(hash[arr[i]] > 1) ans++;
        }
        return ans;
    }
}
