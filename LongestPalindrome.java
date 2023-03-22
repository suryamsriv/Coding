/*
5. Longest Palindromic Substring
Medium
24.4K
1.4K
Companies
Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

public class LongestPalindrome {
     public String longestPalindrome(String s) {

            int max = 0;
            String longestPalindrome = "";

            int i =0;
            String str = "";
            int k = 0;
            while(k < s.length()) {
                str += s.charAt(i);
                if(isPalindrome(str, 0 , str.length() - 1)) {
                    if(str.length() > max) {
                        max = str.length();
                        longestPalindrome = str;
                        if(longestPalindrome.length() == s.length())
                            break;
                    }
                }
                i++;
                if(i == s.length()) {
                    i = ++k;
                    str = "";
                }
            }
            return longestPalindrome;
        }

        private boolean isPalindrome(String str, int start, int end) {

            while(start < end) {
                if(str.charAt(start++) != str.charAt(end--))
                    return false;
            }
            return true;
        }

}
