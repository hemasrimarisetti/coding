"""
Constraints

1 <= T <= 100000
1 <= N <= 100000

Test Case 1
You can get a sum of 3 in the ways:
(1,1,1), (1,2), (2,1), (3)


"""
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        int queries[]=new int[t];
        int max=100000;
        int mod=1000000007;
        for(int i=0;i<t;i++){
            queries[i]=Integer.parseInt(br.readLine());
            }
        long dp[]=new long[max+1];
        
        dp[0]=1;
        for(int i=1;i<=5;i++){
            dp[i]=1<<(i-1);
        }
        
        for(int i=6;i<=max;i++){
            dp[i] = ((dp[i-1] + dp[i-2]) % mod + (dp[i-3] + dp[i-4]) % mod + (dp[i-5] + dp[i-6]) % mod) % mod;
        }
        for(int i=0;i<t;i++){
            
            out.write( dp[queries[i]]%mod+"\n");
        }
        out.flush();
        out.close();
    }
}