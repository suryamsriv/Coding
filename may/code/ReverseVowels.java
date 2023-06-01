package may.code;

import java.util.*;
import java.util.List;

public class ReverseVowels {

    public String reverseVowels(String s) {
        Character vowelsArr[] = new Character[] {'a','e','i','o','u','A','E','I','O','U'};
        List<Character> vowels = Arrays.asList(vowelsArr);

        int i = 0;
        int j = s.length()-1;
        char[] arr = s.toCharArray();
        boolean firstFound = false, lastFound = false;
        while(i<j) {
            char first = s.charAt(i);
            char last = s.charAt(j);
            if(vowels.contains(first))
                firstFound = true;
            else
                i++;

            if(vowels.contains(last))
                lastFound = true;
            else
                j--;

            if(firstFound && lastFound) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                firstFound = false;
                lastFound = false;
                i++;
                j--;
            }
        }
        String result = "";
        for( i=0; i< arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
