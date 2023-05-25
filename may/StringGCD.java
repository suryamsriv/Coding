// https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&id=leetcode-75

/*
1071. Greatest Common Divisor of Strings
Easy
3.5K
557
Companies
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""


Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
 */

package may;

public class StringGCD {
        public String gcdOfStrings(String str1, String str2) {
            String x = "";
            int strRemains = str2.length();
            int count = 0;
            int gcd = 0;

            while(strRemains > 0) {
                int startIndex = 0;
                int endIndex = str2.length();
                while(endIndex <= str1.length()) {
                    // System.out.print("StartIndex: " + startIndex + " EndIndex: " + endIndex);
                    // System.out.print(" str1: " + str1.substring(startIndex, endIndex) );
                    if(str1.substring(startIndex, endIndex).equals(str2)) {
                        count++;
                        startIndex = endIndex;
                        endIndex += str2.length();
                    }
                    else {
                        break;
                    }
                }
                // System.out.println(" count: " + count + " str2: " + str2 );
                if(count > gcd) {
                    x = str2;
                    gcd = count;
                }
                count = 0;
                str2 = str2.substring(0, str2.length() - 1);
                strRemains = str2.length();
            }


            return x;
        }
}
