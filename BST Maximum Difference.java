import java.io.*;
import java.util.*;

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

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}



class Solution
{
    public static int maxDifferenceBST(Node root,int target)
    {
        Node node = findNode(root, target);
        if (node == null)
            return -1;
        int sum1 = sum(root, node.data) - node.data;
        int sum2 = minSum(node) - node.data;
        return sum1 - sum2;
    }

    private static Node findNode(Node root, int target) {
        if (root == null || root.data == target)
            return root;
        if (root.data > target)
            return findNode(root.left, target);
        else 
            return findNode(root.right, target);
    }


    private static int sum(Node node, int target) 
    {
        if (node == null)
            return 0;
        if (node.data == target)
            return node.data;
        if (node.data > target)
            return node.data + sum(node.left, target);
        else
            return node.data + sum(node.right, target);
    }

    private static int minSum(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
        if (node.left == null)
            return node.data + minSum(node.right);
        if (node.right == null)
            return node.data + minSum(node.left);
        return Math.min(node.data + minSum(node.left), node.data + minSum(node.right));
    }
}
