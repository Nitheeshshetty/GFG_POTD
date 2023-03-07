//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    
		    Complete obj = new Complete();
		    String res = obj.maximumFrequency(line);
		    
		    System.out.println(res);
		}
	}
}


            




// } Driver Code Ends


//User function Template for Java

class Complete{
    // Function for finding maximum and value pair
    public static String maximumFrequency (String S) {
        String[] arr=S.split(" ");
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i])==false){
                map.put(arr[i],1);
            }
            else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        String ans="";
        int cnt=0;
        for(String ele:arr){
            if(map.get(ele)>cnt){
                ans=ele;
                cnt=map.get(ele);
            }
        }
        String an=String.valueOf(cnt);
        return ans+" "+an;
    }
    
    
}
