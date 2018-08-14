import java.util.HashMap;

//Given a string,find the length of the longest substring without repeating characters.
//Examples:
//Given "abcabcbb",the answer is"abc",which the length is 3.
//Given "bbbbb",the answer is"b",with the length of 1.
//Given "pwwkew",the answer is"wke",with the length of 3.
// Note that the answer must be a substring,"pwke"is a subsequence and not a substring.
//
public class LongestSubsequenceNonRepeating {
    public static void main(String[] args) {
        String s = "pwwkew";
        HashMap<Character, Integer> map;
        char[] arr = s.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            map = new HashMap<>();
            int currentMax = 0, j, k = -1;
            for (j = i; j < arr.length; j++) {
                if (map.containsKey(arr[j])) {
                    k = map.get(arr[j]);
                    break;
                } else {
                    map.put(arr[j], j);
                    currentMax++;
                }
            }
            if (k != -1) {
                i = k;
            } else {
                i = j;
            }
            maxLen = Math.max(maxLen, currentMax);
        }
        System.out.println(maxLen);
    }
}
