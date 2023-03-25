import java.util.*;
import java.io.*;

class Solution
{
	public static String removeBrackets(String Exp){
		char[] expChars = Exp.toCharArray();
        int n = expChars.length;
        int[] ans = new int[n + 1]; 
        Arrays.fill(ans, 1); 
        int[] lastOperator = new int[n + 1]; 
        int[] nextOperator = new int[n + 1];
        int l = -1;
        for (int i = 0; i < n; i++) {
            lastOperator[i] = l; 
            if (expChars[i] == '*' || expChars[i] == '+' || expChars[i] == '-' || expChars[i] == '/') 
            {
                l = expChars[i];
            }
        }
        l = -1;
        for(int i = n - 1; i >= 0; i--) {
            nextOperator[i] = l; 
            if(expChars[i] == '*' || expChars[i] == '+' || expChars[i] == '-' || expChars[i] == '/') 
            {
                l = expChars[i]; 
            }
        }

        Stack<Integer> st = new Stack<>(); 
        int[] operatorSign = new int[256]; 
        int[] operatorMap = new int[256]; 
        Arrays.fill(operatorSign, -1); 
        char[] operators = {'*', '+', '-', '/'};
        for (int p = 0; p < n; p++) {
            for (char x : operators) {
                operatorMap[x] = 0; 
                if(x == expChars[p]) {
                    operatorSign[x] = p; 
                }
            }
            if (expChars[p] == '(') {
                st.push(p); 
            }
            else if (expChars[p] == ')') {
                int i = st.pop();
                int j = p; 
                int next = nextOperator[j]; 
                int last = lastOperator[i]; 
                for (char x : operators) {
                    if (operatorSign[x] >= i) {
                        operatorMap[x] = 1; 
                    }
                }
                boolean isValid = false;
                if (i > 0 && j + 1 < n && expChars[i - 1] == '(' && expChars[j + 1] == ')') {
                    isValid = true;
                }
                if (operatorMap['+'] == 0 && operatorMap['*'] == 0 && operatorMap['-'] == 0 && operatorMap['/'] == 0) {
                    isValid = true;
                }
                if(last == -1 && next == -1) {
                    isValid = true;
                }
                if (last == '/') {
                }
                else if (last == '-' && (operatorMap['+'] == 1 || operatorMap['-'] == 1)) {
            
                }
                else if (operatorMap['-'] == 0 && operatorMap['+'] == 0) {
                    isValid = true;
                }
                else {
                    if ((last == -1 || last == '+' || last == '-') && (next == -1 || next == '+' || next == '-')) {
                        isValid = true;
                    }
                }
                if (isValid) {
                    ans[i] = 0;
                    ans[j] = 0;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ans[i] > 0) {
                res.append(expChars[i]);
            }
        }
        return res.toString();
	  }
}


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String Exp = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.removeBrackets(Exp));
        }
        
    }
}
