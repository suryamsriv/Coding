package may.testcase;

import may.code.Candies;
import may.code.ReverseVowels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void testKidsWithCandies() {

        int input1[] = {2, 3, 5, 1, 3};
        boolean[] outputArr1 = {true, true, true, false, true};

        int input2[] = {4, 2, 1, 1, 2};
        boolean[] outputArr2 = {true, false, false, false, false};

        int input3[] = {12, 1, 12};
        boolean[] outputArr3 = {true, false, true};


        assertEquals(getOutputArrList(outputArr1) , new Candies().kidsWithCandies(input1, 3));
        assertEquals(getOutputArrList(outputArr2) , new Candies().kidsWithCandies(input2, 1));
        assertEquals(getOutputArrList(outputArr3) , new Candies().kidsWithCandies(input3, 10));

    }

    private List<Boolean> getOutputArrList(boolean outputArr[]) {
        List<Boolean> output1 = new ArrayList<>();
        for(int i=0; i< outputArr.length; i++) {
            output1.add(outputArr[i]);
        }
        return output1;
    }


    @org.junit.Test
    public void testReverseVowels() {
        String str1 = "hello";
        String str2 = "leetcode";
        assertEquals("holle" , new ReverseVowels().reverseVowels(str1));
        assertEquals("leotcede" , new ReverseVowels().reverseVowels(str2));
    }
}