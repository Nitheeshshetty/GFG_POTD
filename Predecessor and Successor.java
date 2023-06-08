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
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
 
        return root;
    }
	    
    static void printInorder(Node root)
    {
        if(root == null)
            return; 
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    
    static Node pre,suc;
    public static void main (String[] args) throws IOException
    {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());    
	while(t-- > 0)
	{
	    String s = br.readLine();
    	    Node root = buildTree(s);
	    int k=Integer.parseInt(br.readLine());
            pre=null;
            suc=null;
            findPreSuc(root,k);
            if(pre!=null){
                    System.out.print(pre.data+" ");
            }
  	    else{
                    System.out.print("-1 ");
                }
                if(suc!=null){
                    System.out.println(suc.data);
                }else{
                    System.out.println("-1 ");
                }
        }
    }


//Function to check whether a Binary Tree is BST or not.
    public static void findPreSuc(Node root, int key)
    {
        Queue<Node> pq = new LinkedList<>();
        pq.add(root);
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.data < key && (pre == null || pre.data < cur.data))
            {
                pre = cur;
            }   
            if(cur.data > key && (suc == null || suc.data > cur.data))
            {
                suc = cur;
            }
            if(cur.left != null)
                pq.add(cur.left);
            if(cur.right != null)
                pq.add(cur.right);
        }
    }
}
