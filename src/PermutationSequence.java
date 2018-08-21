import java.util.ArrayList;
import java.util.List;

//Given n and k, return the kth permutation sequence.
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        String res = "";
        List<String> list = new ArrayList<>();
        int fact = 0;
        for (int i = 0; i < n; i++) {
            fact = fact + factorial(n - 1);
            if (k <= fact) {
                //for this we need to find the res
                StringBuilder builder = new StringBuilder();
                //builder.append(i);
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        builder.append(j + 1);
                    }
                }
                combination(builder.toString().toCharArray(), 0, list);
                if (fact - k - 1 > 0) {
                    res = (i + 1) + "" + list.get(fact - k - 1);
                } else {
                    res = (i + 1) + "" + list.get(0);
                }

                break;
            }
        }

        return res;
    }

    public void combination(char[] str, int indx, List<String> list) {
        if (indx < str.length) {
            if (indx == str.length - 1) {
                String res = "";
                for (int i = 0; i < str.length; i++) {
                    res += str[i];
                }
                list.add(res);
                return;
            }

            for (int i = indx; i < str.length; i++) {
                //swap i , indx
                swap(str, i, indx);
                //permute i+1
                combination(str, indx + 1, list);
                //swap , indx , i
                swap(str, i, indx);
            }
        }
        return;
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void main(String[] args) {
        PermutationSequence sequence = new PermutationSequence();
        sequence.getPermutation(2, 2);
    }
}
