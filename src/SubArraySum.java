//num of subarrays with sum < k
public class SubArraySum {
    //assumption - the arrays cointains only +ve numbers
    public static void main(String[] args) {
        int[] arr = { 1, 11, 2, 3, 15 };
        int[] arr1 = {2, 5, 6};

        System.out.println(numSubarrays(arr, 10));
        System.out.println(numSubarrays(arr1, 10));
    }

    static int numSubarrays(int arr[], int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
