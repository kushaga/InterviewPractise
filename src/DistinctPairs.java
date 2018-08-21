import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctPairs {
    //num pairs with sum=k
    static int numberOfPairs(int[] a, long k) {
        Arrays.sort(a);
        int l = 0, h = a.length - 1;
        Map<Integer, Integer> res = new HashMap<>();
        while (l <= h) {
            if (a[l] + a[h] == k) {
                if (l != h) {
                    res.putIfAbsent(a[l], a[h]);
                }
                l++;
            }
            if (a[l] + a[h] < k) {
                l++;
            }
            if (a[l] + a[h] > k) {
                h--;
            }
        }

        return res.size();
    }

    public static void main(String args[]) {
        int[] input = { 6, 12, 3, 9, 3, 5, 1, 12 };
        numberOfPairs(input, 12);
    }
}
