public class PanlindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        int rev = reverse(x);
        if (rev == x) {
            return true;
        } else {
            return false;
        }
    }

    public int reverse(int x) {
        int prev_num = 0, rev_num = 0;

        while (x != 0) {
            int cur_dig = x % 10;
            rev_num = (rev_num * 10) + cur_dig;
            if ((rev_num - cur_dig) / 10 != prev_num) {
                return -1;
            }
            prev_num = rev_num;
            x = x / 10;
        }

        return rev_num;
    }

    public static void main(String[] args) {
        PanlindromeNumber number =  new PanlindromeNumber();
        System.out.println(number.isPalindrome(-121));
        System.out.println(number.isPalindrome(121));
    }
}
