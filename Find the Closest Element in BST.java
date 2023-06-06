import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              Node currNode = q.remove();
              String currVal = s[i];
              if(!currVal.equals("N")) 
              {
                  currNode.left = new Node(Integer.parseInt(currVal));
                  q.add(currNode.left);
              }
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int k = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.minDiff(root,k));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
*/

class Solution
{
    static int minDiff(Node  root, int K) 
    { 
        int min = Integer.MAX_VALUE;
        Node curr = root;
        while(curr != null)
        {
            int d = Math.abs(K-curr.data);
            if(d < min){
                min = d;
            }
            if(K<curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return min;
    } 
}

