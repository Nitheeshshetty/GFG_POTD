import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int t = Integer.parseInt(br.readLine()); 
        while(t > 0){
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]); 
            String S = br.readLine(); 
            Solution ob = new Solution();
            System.out.println(ob.solve(X,Y,S)); 
            t--;
        }
    } 
} 



//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    String s1="pr",s2="rp";
	    if(Y>X){
	        int t=X;
	        X=Y;
	        Y=t;
	        String temp=s1;
	        s1=s2;
	        s2=temp;
	    }
	    long ans=0;
	    Stack<Character>st=new Stack<>();
	    for(int i=S.length()-1;i>=0;i--){
	        int cur=S.charAt(i);
	        char f=s1.charAt(0),s=s1.charAt(1);
	        if(st.size()>0 && cur==f && st.peek()==s)
	        {
	            st.pop();
	            ans+=X;
	        }
	        else{
	            st.push(S.charAt(i));
	        }
	    }
	    StringBuilder sb=new StringBuilder();
	    while(!st.isEmpty()){
	        sb.append(st.pop());
	    }
	    String S1=sb.toString();
	    for(int i=S1.length()-1;i>=0;i--){
	        int cur=S1.charAt(i);
	        char f1=s2.charAt(0),s11=s2.charAt(1);
	        if(st.size()>0 && cur==f1 && st.peek()==s11)
	        {
	            st.pop();
	            ans+=Y;
	        }
	        else{
	            st.push(S1.charAt(i));
	        }
	    }
	    return ans;
	}
} 
