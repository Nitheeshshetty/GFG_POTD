import java.io.*;
import java.util.*;

class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){     
            int N;
            N = Integer.parseInt(br.readLine());
            int[] A = IntArray.input(br, N);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            IntArray.print(res);  
        }
    }
}


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        HashMap<Integer,Integer>map2=new HashMap<>();
        for(int i=0;i<N;i++)
        {
            map1.put(A[i],map1.getOrDefault(A[i],0)+1);
        }
        ArrayList<Integer>al=new ArrayList<>();
        for(int i=0;i<N;i++){
            map1.put(A[i],map1.get(A[i])-1);
            if(map1.get(A[i])==0)
                map1.remove(A[i]);
            int cur=map2.size()-map1.size();
            al.add(cur);
            map2.put(A[i],map2.getOrDefault(A[i],0)+1);
        }
        return al;
    }
}
        
