
/*
3. Longest Substring Without Repeating Characters
Medium
32.8K
1.4K
Companies
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
        public int lengthOfLongestSubstring(String s) {

            Set<Character> chSet = new HashSet<>();
            int max = 0;
            boolean stringParsed = false;

            for(int i=0; i< s.length(); i++) {
                StringBuilder str = new StringBuilder();
                for(int j=i; j<s.length() ; j++) {
                    char current = s.charAt(j);
                    if(chSet.contains(current))
                    {
                        chSet.clear();
                        str.append(s.substring(i, j));
                        break;
                    }
                    else
                        chSet.add(current);

                    if(j == s.length() - 1) {
                        stringParsed = true;
                        str.append(s.substring(i, j + 1));
                    }
                }
                if(str.toString().length() > max)
                    max = str.toString().length();

                if(stringParsed == true)
                    break;
            }

            return max;
        }
}
