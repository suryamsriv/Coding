import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (var i : nums) {
            if (map.get(i) != null)
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (var i : map.keySet())
            if (map.get(i) == 1) {
                singleNumber = i;
                break;
            }

        return singleNumber;
    }
}
