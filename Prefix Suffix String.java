import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0)
        {
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}



class TrieNode 
{
    TrieNode[] children = new TrieNode[26];
}

class Trie 
{
    TrieNode root = new TrieNode();
    public void insert(String s) 
    {
        TrieNode curr = root;
        for (int i=0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) 
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
    }
    
    public boolean search(String s) 
    {
        TrieNode curr = root;
        for (int i=0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) 
            {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}

class Solution
{
    public int prefixSuffixString(String s1[],String s2[]) 
    {
        Trie t1 = new Trie();
        Trie t2 = new Trie();
        int count = 0;
        for (String s : s1) 
        {
            t1.insert(s);
            String rev = new StringBuilder(s).reverse().toString();
            t2.insert(rev);
        }
        for (String s : s2) 
        {
           boolean found = false;
           found |= t1.search(s);          
           String rev = new StringBuilder(s).reverse().toString();           
           found |= t2.search(rev);
           if (found) 
               count++;
        }
        return count;
    }
}
