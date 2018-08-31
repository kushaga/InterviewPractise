import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
public class MakeCombinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        comb(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void comb(int n, int k, int cur_indx, List<Integer> currList, List<List<Integer>> res) {
        if (k == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer a : currList) {
                tmp.add(a);
            }
            res.add(tmp);
            return;
        }

        for (int i = cur_indx; i <= n; i++) {
            currList.add(i);
            comb(n, k - 1, cur_indx + 1, currList, res);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String args[]) {
        MakeCombinations combinations = new MakeCombinations();
        combinations.combine(4, 2);
    }
}
