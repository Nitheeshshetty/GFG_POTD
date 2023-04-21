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
            i++;
            if(i >= ip.length)
                break;                
            currVal = ip[i];
            if(!currVal.equals("N")) 
	    {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }        
        return root;
    }
    
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int t=Integer.parseInt(br.readLine());
        while(t > 0)
	{
            String line = br.readLine().trim();
            Node root = buildTree(line);
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution{
    static Node search(Node root,int home)
    {
        if(root==null)return null;
        if(root.data==home) return root;
        
        Node l=search(root.left,home);
        if(l!=null)return l;
        Node r=search(root.right,home);
        return r;
    }
    
    static void CreateConnection(Node root,HashMap<Node,Node> parent,Node p)
    {
        if(root==null)
            return;
        parent.put(root,p);
        CreateConnection(root.left,parent,root); 
        CreateConnection(root.right,parent,root);
    }
    
    static int ladoos(Node root, int home, int k)
    {
        Node target = search(root,home);
        HashMap<Node,Node> parent= new HashMap<>();
        CreateConnection(root,parent,null);
        HashSet<Node> visited= new HashSet<>();
        int Sum=0;
        Queue<Node>q= new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(q.size()>0)
        {
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                Node temp= q.poll();
                Sum+=temp.data;
                
                if(temp.left!=null && !visited.contains(temp.left)) //left SubTree
                {
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)) //right SubTree
                {
                    q.add(temp.right);
                    visited.add(temp.right);
                }
                if(parent.get(temp)!=null &&!visited.contains(parent.get(temp)))
                {
                    q.add(parent.get(temp));
                    visited.add(parent.get(temp));
                }
            }
            k--;
            if(k<0)break;
        }
        return Sum;
        
    }
}

