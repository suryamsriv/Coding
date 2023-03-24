/*
7. Reverse Integer
Medium
10.1K
11.8K
Companies
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
 */

public class ReverseSignedInteger {
        public int reverse(int x) {
            int sign = 1;

            if(x < 0) {
                sign = -1;
                x = x * sign;
            }

            int reverse = 0;
            while(x != 0) {
                int d = x % 10;
                reverse = reverse * 10 + d;
                x = x / 10;
                if((reverse<(-214748364) && x!=0) || (reverse > 214748364 && x!=0))
                    return 0;
            }
            reverse = reverse * sign;
            return reverse;
        }
}
