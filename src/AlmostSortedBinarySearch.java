public class AlmostSortedBinarySearch {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 10, 4, 40 };

        System.out.println(search(arr, 4, 0, arr.length - 1));
    }

    /**
     * @param arr
     * @param num to search
     * @param l   - starting point
     * @param h   - ending point
     * @return - position of element in the array
     */
    public static int search(int arr[], int num, int l, int h) {
        if (l > h) {
            return -1;
        } else {
            int mid = (h + l) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid - 1] == num && mid - 1 > 0) {
                return mid - 1;
            } else if (arr[mid + 1] == num && mid + 1 < arr.length) {
                return mid + 1;
            } else {
                if (arr[mid] < num) {
                    return search(arr, num, mid + 2, h);
                } else {
                    return search(arr, num, l, mid - 2);
                }
            }
        }
    }
}
