//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        int []a=new int[26];
        int []b=new int[26];
        ArrayList<Node>ans=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            char d=s.charAt(i);
            b[d-'a']++;
        }
        int i=0,j=0;
        Node f=head,sl=head;
        while(f!=null)
        {
            char p=f.data;
            a[p-'a']++;
            if(j-i+1==s.length())
            {
                boolean ok=true;
                for(int k=0;k<26;k++)
                    if(a[k]!=b[k])
                        ok=false;
                if(ok==true)
                {
                    Node head1=new Node(sl.data);
                    Node ll;
                    ll=head1;
                    sl=sl.next;
                    while(sl!=null && f!=null && sl.next!=null && sl!=f)
                    {
                        Node k=new Node(sl.data);
                        ll.next=k;
                        ll=k;
                        sl=sl.next;
                    }
                    Node k=new Node(sl.data);
                    ll.next=k;
                    ll=k;
                    sl=sl.next;
                    for(int l=0;l<26;l++)
                        a[l]=0;
                    i=j+1;
                    ans.add(head1);
                }
                else
                {
                    char d=sl.data;
                    a[d-'a']--;
                    i++;
                    sl=sl.next;
                }
            }
            j++;
            f=f.next;
        }
        return ans;
    }
}
