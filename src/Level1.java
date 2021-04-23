import java.util.*;

public class Level1
{
    public static String BigMinus(String s1, String s2) {
        if(s1.length() < s2.length()) {
            String t = "";
            t = s1;
            s1 = s2;
            s2 = t;
        } else if(s1.length() == s2.length()) {
            for(int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) < s2.charAt(i)) {
                    String t = "";
                    s1 = t;
                    s1 = s2;
                    s2 = t;
                }
            }
        }

        String s1_reversed = "", s2_reversed = "";
        String res = "";
        for(int i = 0; i < s1.length(); i++)
            s1_reversed += s1.charAt(s1.length() - 1 - i);

        for(int i = 0; i < s2.length(); i++)
            s2_reversed += s2.charAt(s2.length() - 1 - i);

        int carry = 0;

        for(int i = 0; i < s2.length(); i++) {
            int sub = (int)(s1_reversed.charAt(i)) - (int)(s2_reversed.charAt(i)) - carry;

            if(sub < 0) {
                carry = 1;
                sub += 10;
            }
            else carry = 0;

            res += String.valueOf(sub);
        }

        for(int i = s2_reversed.length(); i < s1.length(); i++) {
            int sub = (s1_reversed.charAt(i) - '0') - carry;

            if(sub < 0) {
                carry = 1;
                sub += 10;
            }
            else carry = 0;

            res += String.valueOf(sub);
        }

        String res_reversed = "";
        for(int i = 0; i < res.length(); i++)
            res_reversed += res.charAt(res.length() - 1 - i);

        if(Integer.parseInt(res_reversed) == 0) {
            res_reversed = "0";
        }

        return res_reversed;
    }
}
