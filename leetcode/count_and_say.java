Example 1:

Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
Example 2:

Input: n = 1

Output: "1"

recursive approach

class Solution {
    public String countAndSay(int n) {
         if(n==1)return "1";//base case
         String s=countAndSay(n-1);
         int c=0;
         StringBuilder sb=new StringBuilder();
         for(int i=0;i<s.length();i++){
            c++;//count of the current character
             /*it checks for index to avoid indexout of bounds exception at i+1 if the characters at i and i+1 are not equal then it appends the ouput with count and character at that specific index and make the count as 0*/
            if(i==s.length()-1||s.charAt(i)!=s.charAt(i+1)){
                sb.append(c).append(s.charAt(i));
                c=0;
            }
         }
         return sb.toString();

    }
}