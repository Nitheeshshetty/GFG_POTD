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
        left = null;
        right = null;
    }

    public static Node buildTree(String str) 
    {
        if (str.length() == 0 || str.charAt(0) == 'N') 
            return null;
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) 
        {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) 
            {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) 
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) 
            {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException 
    {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) 
    {
        if (root == null) 
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) 
        {
            int target;
            target = Integer.parseInt(br.readLine());
            Node root = Node.inputTree(br);
            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);
            System.out.println(res);
        }
    }
}



class Quad
{
    int sum,size,min,max;
    Quad(int sum,int size,int min,int max)
    {
        this.sum=sum;this.size=size;this.min=min;this.max=max;
    }
}
class Solution 
{
    int ans=Integer.MAX_VALUE;
    Quad solve(Node root,int target)
    {
        if(root==null)
            return new Quad(0,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Quad left=solve(root.left,target);
        Quad right=solve(root.right,target);
        int curr=root.data+left.sum+right.sum; 
        if(root.data>left.max && root.data<right.min)
        {
            if(target==curr)
                ans=Math.min(ans,1+left.size+right.size);
            return new Quad(curr,1+left.size+right.size,Math.min(left.min,root.data),Math.max(right.max,root.data));
        }
        return new Quad(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public int minSubtreeSumBST(int target, Node root) 
    {
        solve(root,target);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
