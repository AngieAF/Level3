import java.util.ArrayList;

public class BiggerGreater {
    public static void main(String[] args) {
        System.out.println(BiggerGreater("вкиб"));
    }

    public static String BiggerGreater(String input) {

        char dec_element = ' ';
        int ind = 0;
        char sym1 = ' ', sym2 = ' ';

        findDecliningElement(input, dec_element, ind, sym1, sym2);

        int dif = 0,  swap_ind = 0;
        dif = input.charAt(ind + 1) - input.charAt(ind);
        for(int j = ind; j < input.length() - 1; j++) {
            // if the word is lexicographically smallest
            if((input.charAt(j + 1) - dec_element) <= dif && (input.charAt(j + 1) - dec_element) > 0) {
                dif = input.charAt(j + 1) - dec_element;
                swap_ind = j + 1;
            }
        }

            if(dif <= 0) return "";
            System.out.println(dif);

        String temp_str = "";
            for(int i = 0; i < input.length(); i++) {
                if(i == ind) {
                    temp_str += input.charAt(swap_ind);
                } else if(i == swap_ind) {
                    temp_str += input.charAt(ind);
                } else temp_str += input.charAt(i);
            }
        System.out.println(temp_str);

       String res = "";
            for(int j = 0; j <= ind; j++)
                res += temp_str.charAt(j);
            System.out.println(res);


            for(int i = temp_str.length() - 1; i > ind; i--) {
                res += temp_str.charAt(i);
            }
        System.out.println(res);

        return res;
    }

    public static void findDecliningElement(String input, char dec_element, int ind, char sym1, char sym2){
        for(int i = input.length() - 1; i > 0; i--) {
            sym1 = input.charAt(i - 1);
            sym2 = input.charAt(i);
            if (sym1 <= sym2) {
                dec_element = input.charAt(i - 1);
                ind = i - 1;
                //System.out.println(dec_element);
                break;
            }
        }
    }


}