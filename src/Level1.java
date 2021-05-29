import java.util.*;

public class Level1
{
    public static String BiggerGreater(String input) {
        char dec_element = ' ';
        int ind = 0, dif = 0, swap_ind = 0;
        String temp_str = "", res = "";
        char sym1 = ' ', sym2 = ' ';

        for(int i = input.length() - 1; i > 0; i--) {
            sym1 = input.charAt(i - 1);
            sym2 = input.charAt(i);
            if (sym1 <= sym2) {
                dec_element = input.charAt(i - 1);
                ind = i - 1;
                break;
            }
        }

        dif = input.charAt(ind + 1) - input.charAt(ind);
        for(int j = ind; j < input.length() - 1; j++) {
            if((input.charAt(j + 1) - dec_element) <= dif && (input.charAt(j + 1) - dec_element) > 0) {
                dif = input.charAt(j + 1) - dec_element;
                swap_ind = j + 1;
            }
        }
        if(dif <= 0) return "";

        for(int i = 0; i < input.length(); i++) {
            if(i == ind) {
                temp_str += input.charAt(swap_ind);
            } else if(i == swap_ind) {
                temp_str += input.charAt(ind);
            } else temp_str += input.charAt(i);
        }

        for(int j = 0; j <= ind; j++)
            res += temp_str.charAt(j);

        for(int i = temp_str.length() - 1; i > ind; i--) {
            res += temp_str.charAt(i);
        }

        return res;
    }
}
