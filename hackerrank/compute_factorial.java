"""Constraints

1 <= T <= 1000000
0 <= N <= 1000000

Sample Input 0

3
5
20
50
Sample Output 0

120
146326063
318608048"""



import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
          
        int T = Integer.parseInt(br.readLine());
        
        int MOD = 1000000007;
        int MAX_N = 1000000;
        
        int[] queries = new int[T];
        for (int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine());
        }
        
        long[] factorial = new long[MAX_N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            factorial[i] = (factorial[i - 1] * i) MOD;
"""here we are calculating factorial for each and every one upto max_n and by using this factorial table we are getting answer for the queries efficiently"""
        }
        
        for (int i = 0; i < T; i++) {
            out.write(factorial[queries[i]] + "\n");
        }
        
        out.flush();
        out.close();
    }
}