import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG 
{    
    static Node buildTree(String str)
    {    
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));        
        Queue<Node> queue = new LinkedList<>();         
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) 
	{
            Node currNode = queue.peek();
            queue.remove();                
            String currVal = ip[i];               
            if(!currVal.equals("N")) 
	    {                    
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int k=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                int ans=ob.goodSubtrees(root,k);
                out.println(ans);
                    t--;
            
            }
            out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int count = 0;
    static void find(HashSet<Integer> set , Node root , int k)
    {
        if(root == null)
        {
            return ;
        }
        HashSet<Integer> left_set = new HashSet<>();
        HashSet<Integer> right_set = new HashSet<>();
        find(left_set , root.left , k);
        find(right_set , root.right , k);
        left_set.addAll(right_set);
        left_set.add(root.data);
        if(left_set.size() <= k)
        {
            count++;
        }
        set.addAll(left_set);
    }
    
    public static int goodSubtrees(Node root,int k)
    {
        count = 0;
        HashSet<Integer> set = new HashSet<>();
        find(set , root , k);
        return count;
    }
}
