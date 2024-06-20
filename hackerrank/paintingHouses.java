"""
Constraints

1 <= T <= 100
1 <= N <= 103
1 <= R[i],G[i],B[i] <= 103


input:
6
7 3 8 6 1 2 
5 6 7 2 4 3 
10 1 4 9 7 6 

    
output:
18

"""
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        int test=Integer.parseInt(br.readLine());
        while(test-->0){
            int n=Integer.parseInt(br.readLine());
            int r[]=new int[n];
            int g[]=new int[n];
            int b[]=new int[n];
            String rs[]=br.readLine().split(" ");
            for(int i=0;i<n;i++){
                r[i]=Integer.parseInt(rs[i]);
            }
            String gs[]=br.readLine().split(" ");
            for(int i=0;i<n;i++){
                g[i]=Integer.parseInt(gs[i]);
            }
            String bs[]=br.readLine().split(" ");
            for(int i=0;i<n;i++){
                b[i]=Integer.parseInt(bs[i]);
            }
            int dpR[]=new int[n];
            int dpG[]=new int[n];
            int dpB[]=new int[n];
            dpR[0]=r[0];
            dpG[0]=g[0];
            dpB[0]=b[0];
            for(int i=1;i<n;i++){
                dpR[i]=Math.min(dpG[i-1],dpB[i-1])+r[i];
//if we consider one then no adjacent house should have same color for that reason we are considering other 2 colors rather than that
                dpG[i]=Math.min(dpR[i-1],dpB[i-1])+g[i];
                dpB[i]=Math.min(dpR[i-1],dpG[i-1])+b[i];
            }
            int min=Math.min(dpR[n-1],dpG[n-1]);
            out.write(Math.min(min,dpB[n-1])+"\n");
        }
        out.flush();
        out.close();
    }
}
