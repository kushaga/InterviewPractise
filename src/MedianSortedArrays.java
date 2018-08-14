public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null && nums2 == null)) {
            return -1;
        }
        double median = 0;
        if ((nums1 == null && nums2 != null) || (nums1.length == 0 && nums2.length > 0)) {
            median = median(nums2);
        } else if ((nums2 == null && nums1 != null) || (nums2.length == 0 && nums1.length > 0)) {
            median = median(nums1);
        } else {
            //use merge
            int num = nums1.length + nums2.length;
            if (num % 2 == 0) {
                median = (findElement(nums1, nums2, num / 2) + findElement(nums1, nums2, (num / 2) - 1)) / 2.0;
            } else {
                median = findElement(nums1, nums2, (int) Math.ceil(num / 2));
            }
        }
        return median;
    }

    double median(int[] n) {
        double median = 0;
        if (n.length % 2 == 0) {
            //even
            int num = (int) ((n.length) / 2.0);
            median = (n[num - 1] + n[num]) / 2.0;
        } else {
            //odd
            median = n[(int) Math.ceil(n.length / 2.0) - 1];
        }
        return median;
    }

    int findElement(int[] arr1, int[] arr2, int n) {
        int cnt1 = 0;
        int cnt2 = 0;
        int k = 0, num = -1;
        boolean isfound = false;
        while (cnt1 < arr1.length && cnt2 < arr2.length) {
            if (arr1[cnt1] < arr2[cnt2]) {
                if (n == k) {
                    num = arr1[cnt1];
                    isfound = true;
                    break;
                }
                cnt1++;
            } else {
                if (n == k) {
                    num = arr2[cnt2];
                    isfound = true;
                    break;
                }
                cnt2++;
            }
            k++;
        }

        if (cnt1 == arr1.length && cnt2 < arr2.length && !isfound) {
            while (cnt2 < arr2.length) {
                if (k == n) {
                    num = arr2[cnt2];
                    isfound = true;
                    break;
                }
                cnt2++;
                k++;
            }
        }

        if (cnt2 == arr2.length && cnt1 < arr1.length && !isfound) {
            while (cnt1 < arr1.length) {
                if (k == n) {
                    num = arr1[cnt1];
                    isfound = true;
                    break;
                }
                cnt1++;
                k++;
            }
        }

        return num;
    }

    public static void main(String args[]) {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        int[] num1 = { 1 };
        int[] num2 = { 1 };
        System.out.println(medianSortedArrays.findMedianSortedArrays(num1, num2));
    }
}
