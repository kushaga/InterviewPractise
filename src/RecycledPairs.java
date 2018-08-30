import java.util.Arrays;
import java.util.HashSet;

public class RecycledPairs {
    static int recycledPairs(int[] a) {
        int count = 0;

        // Sorting array
        Arrays.sort(a);
        int n = a.length;

        // Removing duplicates by creating new array temp.
        int[] temp = new int[n];
        Arrays.fill(temp, -1);
        int j = 0;

        for (int i = 0; i < n - 1; i++)
            if (a[i] != a[i + 1]) temp[j++] = a[i];
        temp[j++] = a[n - 1];
        int size = n;

        // Finding number of locations in temp which are occupied from copying.
        for (int i = n - 1; i >= 0; i--)
            if (temp[i] != -1) {
                size = i;
                break;
            }

        // Hashset to store new Rotations
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < size + 1; i++) {

            // Clearing hashset for each number in temp.
            hs.clear();
            int x = temp[i];

            // Finding number of digits of taken number
            int d1 = (int) Math.log10(temp[i]) + 1;

            int f = (int) Math.pow(10, d1 - 1);
            for (j = 1; j <= d1 - 1; j++) {

                // Remainder
                int r = x % 10;

                // Quotient
                int q = x / 10;

                // Forming new number by rotating.
                x = r * f + q;

                // Number of digits of newly formed rotated number
                // to avoid duplicate numbers.
                int d2 = (int) Math.log10(x) + 1;

                // Inserting formed rotated number to set s
                if (!hs.contains(x)) {
                    hs.add(x);

                    // Checking for number of digits of new number.
                    if ((d1 == d2)) {
                        // Searching for the formed element in rest of array.
                        int position = Arrays.binarySearch(temp, i + 1, size + 1, x);

                        // If position found
                        if (position >= 0) {
                            // Increment counter.
                            count++;
                        }
                    }
                }
            }
        }

        // Return counter
        return count;
    }



    public static void main(String[] args) {
        int a[] = { 1212, 2121 };
        int result = recycledPairs(a);
        System.out.println(result);
    }
}
