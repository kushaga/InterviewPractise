public class IntToRoman {

    public String intToRoman(int num) {
        String res = "";
        String[] th = { "", "M", "MM", "MMM" };
        String[] hund = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] ten = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        res = res + th[num / 1000];
        num = num % 1000;
        res = res + hund[num / 100];
        num = num % 100;
        res = res + ten[num / 10];
        num = num % 10;
        res = res + ones[num];
        return res;
    }

    int romanToDecimal(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }

    int value(char r) {
        if (r == 'I') return 1;
        if (r == 'V') return 5;
        if (r == 'X') return 10;
        if (r == 'L') return 50;
        if (r == 'C') return 100;
        if (r == 'D') return 500;
        if (r == 'M') return 1000;
        return -1;
    }

    //limit number ranges from 0 to 3999
    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(1994));
        System.out.println(intToRoman.romanToDecimal(intToRoman.intToRoman(1994)));
    }
}
