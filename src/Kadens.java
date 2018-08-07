public class Kadens {
    public static void main(String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadanes(a));
    }

    static int kadanes(int arr[]) {
        int max = arr[0];
        int currentMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (currentMax < 0) {
                currentMax = 0;
            }
            currentMax += arr[i];
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
