import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException
    {  
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            Shop shop = new Shop();
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            long k = Long.parseLong(s[1]);
            s = br.readLine().trim().split(" ");
            for(String x: s){
                shop.addChocolate(Integer.parseInt(x));
            }    
            ot.println(new Solution(shop).find(n, k));
        }
        ot.close();
    }
    
    
}
class Shop{
    private static List<Integer> chocoloates;
    private static int countOfCalls;
    Shop(){
        chocoloates = new ArrayList<>();
        countOfCalls = 0;
    }
    public static void addChocolate(int price){
        chocoloates.add(price);
    }
    public static int get(int i){
        countOfCalls++;
        if(countOfCalls > 50 || i >= chocoloates.size() || i < 0)
            return -1;
        return chocoloates.get(i);
    }
}



class Solution
{
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    
    static long[] BinarySearch(int n,long k)
    {
        long ans=0;
        int low=0,high=n-1;
        long price=-1;
        int mid=-1;
        while(low<=high)
        {
            mid=(low+high)/2;
            price=shop.get(mid);
            
            if(price==k)
            {
                return new long[]{price,(long)(mid)};
            }
            else if(price<k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return new long[]{price,(long)(mid)};
    }
    
    static long find(int n, long k)
    {
        
        if(k==0) 
            return 0;
        long ans=0;
        long[] binarysearch=BinarySearch(n,k);
        int mid=(int)binarysearch[1];
        long price=binarysearch[0];
        if(price==k) 
            return 1;
        if(price==-1)
            return 0;
        if(price>k && mid>0)
        {
            int price2=shop.get(mid-1);
            ans+=(k/price2);
            k=k%price2;
        }
        else if(price<k)
        {
            ans+=(k/price);
            k=k%price;
        }
        
        return ans+find(mid,k);
    }

}
