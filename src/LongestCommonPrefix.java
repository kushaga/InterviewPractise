public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        return lcp(strs, 0, strs.length - 1);
    }

    public String lcp(String[] strs, int l, int h) {
        if (l == h) {
            return strs[l];
        }
        int mid = (l + h) / 2;
        String lcpR = lcp(strs, l, mid);
        String lcpL = lcp(strs, mid + 1, h);
        if (lcpL == "" || lcpR == "") {
            return "";
        }
        return commonPrefix(lcpL, lcpR);
    }

    public String commonPrefix(String str1, String str2) {
        int size1 = str1.length();
        int size2 = str2.length();
        int size = size1 > size2 ? size2 : size1;
        String res = "";
        for (int i = 0; i < size; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            res = res + str1.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strings = { "flower", "flow", "flight" };
        String[] strings1 = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix.longestCommonPrefix(strings));
        System.out.println(longestCommonPrefix.longestCommonPrefix(strings1));
    }
}
