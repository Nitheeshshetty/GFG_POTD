//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    public boolean check(int n){
        if(n<=1)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public int minp(int n){
        for(int i=n;i>=2;i--)
            if(check(i)==true)
                return i;
        return n;
    }

    public int maxp(int n){
        for(int i=n+1;i<2*n;i++)
            if(check(i)==true)
                return i;
        return n;
    }

    Node primeList(Node head)
    {
        Node p=head;
        while(p!=null){
            int n=p.val;
            if(n==1)
                p.val=2;
            else if(!check(n)){
                if(n-minp(n)>maxp(n)-n)
                    p.val=maxp(n);
                else
                    p.val=minp(n);
            }
            p=p.next;
        }
        return head;
    }
}
