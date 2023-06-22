package june.testcases;

import june.Code;
import may.code.Candies;
import may.code.ReverseVowels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void testReversedString() {

        String s1 = "The sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";


        assertEquals( "blue is sky The", new Code().reverseWords(s1));
        assertEquals("world hello", new Code().reverseWords(s2));
        assertEquals("example good a" , new Code().reverseWords(s3));

    }


}