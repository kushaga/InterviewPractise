import java.util.ArrayList;
import java.util.List;

public class StringtoInt {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int num = 0;
            boolean isNeg = false;
            boolean isFirst = false;
            char[] chars = str.toCharArray();
            List<Character> numList = new ArrayList<Character>();

            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    if (i - 1 >= 0 && !isFirst) {
                        if (chars[i - 1] == ' ') {
                            return 0;
                        }
                    }
                    if (i - 1 >= 0 && !Character.isDigit(chars[i - 1]) && !isFirst) {
                        break;
                    }
                    numList.add(chars[i]);
                    if (!isNeg && (i - 1 >= 0) && chars[i - 1] == '-') {
                        isNeg = true;
                    }
                    if (i + 1 < chars.length && !Character.isDigit(chars[i + 1]) && !isFirst) {
                        break;
                    }

                    isFirst = true;
                }
                if (chars[i] == '-' || chars[i] == '+') {
                    isFirst = true;
                }
            }
            String res = "";
            for (Character c : numList) {
                res = res + c;
            }

            if (numList.size() == 0) {
                return 0;
            }

            num = Integer.parseInt(res);
            if (isNeg) {
                return -num;
            } else {
                return num;
            }
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        StringtoInt stringtoInt = new StringtoInt();
        System.out.println(stringtoInt.myAtoi("words and 987"));
        System.out.println(stringtoInt.myAtoi("3.14159"));
        System.out.println(stringtoInt.myAtoi(".1"));
        System.out.println(stringtoInt.myAtoi("   -42"));
    }
}
