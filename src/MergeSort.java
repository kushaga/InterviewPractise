public class MergeSort {

    public static void main(String[] args) {
        int arr[] = { 200, 2, 3, 4, 40, 10 };
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, mid, low, high);
        }
    }

    public static void merge(int[] arr, int mid, int low, int high) {
        int[] temp = new int[high - low + 1];
        int cnt1 = low;
        int cnt2 = mid + 1;
        int i = 0;
        while (cnt1 <= mid && cnt2 <= high) {
            if (arr[cnt1] < arr[cnt2]) {
                temp[i] = arr[cnt1];
                cnt1++;
            } else {
                temp[i] = arr[cnt2];
                cnt2++;
            }
            i++;
        }

        while (cnt1 <= mid) {
            temp[i] = arr[cnt1];
            i++;
            cnt1++;
        }

        while (cnt2 <= high ) {
            temp[i] = arr[cnt2];
            i++;
            cnt2++;
        }

        for (int j = low, k = 0; j <= high && k < temp.length; j++, k++) {
            arr[j] = temp[k];
        }
    }
}
