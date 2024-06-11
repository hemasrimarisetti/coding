Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.



class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        
        HashMap<String , Integer> map = new HashMap<String , Integer>();
        //to get the frequency of the each word
        for(String str : arr){
            
            map.put( str , map.getOrDefault(str , 0 ) + 1);
        }
        
        Set<String> st = map.keySet();
        
        int max = -1 ;
//below loop is for finding the maximum value
        for(String str : st){
            
            if(map.get(str) > max ){
                max = map.get(str);
            }
        }
         
        int secMax = -1 ;
        String ans = "";
//finding the second max
        for(String s : st){
            
            if(map.get(s) > secMax && map.get(s) != max && map.get(s) < max ){
                secMax = map.get(s);
                ans = s;
            }
        }
        
        return ans ;
    }
}