"""
Constraints

1 <= T <= 103
1 <= N, K <= 103
1 <= A[i], B[i] <= 105

input:
5 8
11 34 50 29 17 
36 48 27 13 18 

output:
111

Total Cost = 11 + 34 + 8 + 27 + 13 + 18 = 111.
"""

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
             StringTokenizer st 
            = new StringTokenizer(br.readLine()); 
            int n=Integer.parseInt(st.nextToken());
            int tt=Integer.parseInt(st.nextToken());
             String sa[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(sa[i]);
            }
            String sb[]=br.readLine().split(" ");
            int b[]=new int[n];
            for(int i=0;i<n;i++){
                b[i]=Integer.parseInt(sb[i]);
            }
            int dpA[]=new int[n];
            int dpB[]=new int[n];
            dpA[0]=a[0];
            dpB[0]=b[0];
            for(int i=1;i<n;i++){
                dpA[i]=Math.min(dpA[i-1],dpB[i-1]+tt)+a[i];
                
//transition cost is added when we change from one machine to another machine
                
                dpB[i]=Math.min(dpB[i-1],dpA[i-1]+tt)+b[i];
            }
            out.write(Math.min(dpA[n-1],dpB[n-1])+"\n");
        }
        out.flush();
        out.close();
    }
}
