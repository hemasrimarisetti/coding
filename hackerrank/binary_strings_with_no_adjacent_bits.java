"""Constraints

1 <= T <= 100000
1 <= N <= 100000

Test Case 1
You can construct the following binary strings of length 3 with no adjacent 1s:
000, 001, 010, 100, 101

""""

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
       
        int queries[]=new int[t];
        for(int i=0;i<t;i++){
            queries[i]=Integer.parseInt(br.readLine());
        }
        int max=100000;
        int mod=1000000007;
        int dp0[]=new int[max+1];
        int dp1[]=new int[max+1];
        dp0[1]=1;
        dp1[1]=1;
        for(int i=2;i<=max;i++){
            dp0[i]=(dp0[i-1]+dp1[i-1])%mod;//to place 0 in ith position we can have any of  0 or 1 in previus position i.e(i-1)
            dp1[i]=(dp0[i-1])%mod;//to place 1 bit in ith position we can have only  0 in previus position i.e(i-1) bcz no adjacent bits should be setbits

        }
        for(int i=0;i<queries.length;i++){
            long result=(dp0[queries[i]]+dp1[queries[i]])%mod;
            out.write(result+"\n");
        }
        out.flush();
        out.close();
    }
}