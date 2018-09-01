package dynamicProgramming;

public class KnapSack {
    public int knapSack(int wt[], int[] val, int indx, int W) {
        if (W == 0 || indx == wt.length) {
            return 0;
        }
        if (W < wt[indx]) {
            return knapSack(wt, val, indx + 1, W);
        } else {
            return Math.max(val[indx] + knapSack(wt, val, indx + 1, W - wt[indx]), knapSack(wt, val, indx + 1, W));
        }
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;

        KnapSack knapSack = new KnapSack();

        System.out.println(knapSack.knapSack(wt, val, 0, W));
    }
}
