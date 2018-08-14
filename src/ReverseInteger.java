public class ReverseInteger {
    public static int reverse(int x) {
        boolean neg = false;
        if (x < 1) {
            neg = true;
            x = (x) * (-1);
        }
        int rev_num = 0, prev_rev_num = 0;

        while (x != 0) {
            int curr_digit = x % 10;
            rev_num = (rev_num * 10) + curr_digit;

            if ((rev_num - curr_digit) / 10 != prev_rev_num) {
                System.out.println("Integer overflow....");
                return 0;
            }
            prev_rev_num = rev_num;
            x = x / 10;
        }

        if (neg) {
            return (rev_num) * (-1);
        } else {
            return rev_num;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
