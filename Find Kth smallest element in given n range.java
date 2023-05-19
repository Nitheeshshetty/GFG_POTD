//{ Driver Code Starts

import java.io.*;

import java.util.*;

class GFG{

    public static void main(String args[]) throws IOException { 

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out=new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());

        

        while(t-- > 0){

            int n=Integer.parseInt(in.readLine().trim());

            int range[][]=new int[n][2];

            for(int i=0;i<n;i++){

                String s[]=in.readLine().trim().split(" ");

                range[i][0]=Integer.parseInt(s[0]);

                range[i][1]=Integer.parseInt(s[1]);

            }

            int q=Integer.parseInt(in.readLine().trim());

            int Q[]=new int[q];

            String s[]=in.readLine().trim().split(" ");

            for(int i=0;i<q;i++){

                Q[i]=Integer.parseInt(s[i]);

            }

            Solution ob=new Solution();

            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){

                out.print(i+" ");

            }out.println();

        }

        out.close();

    } 

}

// } Driver Code Ends

class Solution {

    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {       

        Arrays.sort(range, new Comparator<int[]>(){

           @Override

           public int compare(int[] a, int[] b) {

               return a[0]-b[0]; // because smallest number should be at the beginning.

           }

        });

        int ri=0;  // upto this index merged non overlapping range will exist.

        for(int i=1; i<n; i++) {

            if(range[i][0]<=range[ri][1]) {

                range[ri][1] = Math.max(range[ri][1], range[i][1]);

            } else {

                ri++;       // add as new interval

                range[ri]=range[i];

            }

        }

        int N=ri+1;

        int[] arr = new int[N];

        for(int i=0; i<N; i++) {

            arr[i] = range[i][1]-range[i][0]+1; // number of elements in this range.

        }

        // find presum of arr[] will give number of elements at paticular index.

        for(int i=1; i<N; i++) {

            arr[i]=arr[i]+arr[i-1];

        }

        // for each kth, find which index in presum does it exist by finding ceil using binary search.

        ArrayList<Integer> list = new ArrayList<>();

        for(int k:queries) {

            if(k>arr[N-1]) {

                list.add(-1);

                continue;

            }

            int idx = binarySearchCeil(arr, k);

            int[] currRange = range[idx];

            int belowFromUpperBound = arr[idx]-k;

            list.add(currRange[1]-belowFromUpperBound);

        }

        return list;

    }

    private static int binarySearchCeil(int[] arr, int K) {

        int l=0;

        int h=arr.length-1;

        int ceil=-1;        

        while(l<=h) {

            int m=(l+h)/2;

            if(arr[m] >= K) {

                ceil=m;

                h=m-1;

            } else { l=m+1; }

        }

        return ceil;

    }

}

        

