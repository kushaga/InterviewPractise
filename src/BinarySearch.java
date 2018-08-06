public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };

        System.out.println(search(arr, 10, 0, arr.length - 1));
        System.out.println(search(arr, 40, 0, arr.length - 1));
        System.out.println(search(arr, 50, 0, arr.length - 1));
        System.out.println(search(arr, 2, 0, arr.length - 1));
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
            } else {
                if (arr[mid] < num) {
                    return search(arr, num, mid + 1, h);
                } else {
                    return search(arr, num, l, mid - 1);
                }
            }
        }
    }
}
