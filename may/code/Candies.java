package may.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> hasMaxCandies = new ArrayList<>();
//        boolean[] hasMaxCandies = new boolean[candies.length];
        int max = 0;
        for(int i=0; i < candies.length; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
        }
        for(int i=0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= max ) {
                hasMaxCandies.add(true);
            }
            else {
                hasMaxCandies.add(false);
            }
        }

        return hasMaxCandies;
    }

}
