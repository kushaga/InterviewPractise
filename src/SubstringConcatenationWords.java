import java.util.ArrayList;
import java.util.List;

//given a string, s, and a list of words, words, that are all of the same length.
// Find all starting indices of substring(s) in s that is a
// concatenation of each word in words exactly once and without any intervening characters.
public class SubstringConcatenationWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length < 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        List<String> permsWords = new ArrayList<>();
        findPermutations(words, 0, words.length - 1, "", permsWords);

        for (String word : permsWords) {
            List<Integer> indx = findWord(word, s);
            if (indx.size() > 0) {
                res.addAll(indx);
            }
        }
        return res;
    }

    public List<Integer> findWord(String substring, String str) {
        List<Integer> indx = new ArrayList<>();
        int i = 0;
        for (Character c : str.toCharArray()) {
            if (c == substring.charAt(0)) {
                if ((i + substring.length() <= str.length()) && str.substring(i, i + substring.length())
                                .equals(substring)) {
                    indx.add(i);
                }
            }
            i++;
        }
        return indx;
    }

    public void findPermutations(String[] words, int current, int n, String res, List<String> perms) {
        if (current == n) {
            res = res + words[current];
            perms.add(res);
            return;
        }

        for (int i = current; i <= n; i++) {
            //swap
            String temp = words[current];
            words[current] = words[i];
            words[i] = temp;

            String s1 = res;
            s1 = s1 + words[current];

            findPermutations(words, current + 1, n, s1, perms);

            //swap
            temp = words[i];
            words[i] = words[current];
            words[current] = temp;
        }
    }

    public static void main(String[] args) {
        SubstringConcatenationWords concatenationWords = new SubstringConcatenationWords();
        String[] words = { "foo", "bar" };
        for (int i : concatenationWords.findSubstring("barfoothefoobarman", words)) {
            System.out.println(i);
        }
    }
}
