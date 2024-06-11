Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"

Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
 

class Solution {
   public int findSubString(String str) {
    HashMap<Character, Integer> count = new HashMap<>();
    int n = str.length();
    int ans = Integer.MAX_VALUE;
    int size = 0;  // Number of distinct characters in the string

    // Count the frequency of each character in the entire string
    for (int i = 0; i < n; i++) {
        char ch = str.charAt(i);
        count.put(ch, count.getOrDefault(ch, 0) + 1);
        if (count.get(ch) == 1) {
            size++;//for getting distinct characters
        }
    }

    // Reset the count array
    count.clear();

    int i = 0, j = 0;

    while (j < n) {
        char ch = str.charAt(j);

        count.put(ch, count.getOrDefault(ch, 0) + 1);

        while (count.get(str.charAt(i)) > 1) {
            count.put(str.charAt(i), count.get(str.charAt(i)) - 1);
            i++;
        }
//before updating answer we are checking for whether the elements in the window are equal to the distinct elements
        if (size == count.size()) {
            ans = Math.min(ans, j - i + 1);
        }

        j++;
    }

    return ans;
}

}

