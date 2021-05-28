import java.util.*;

public class Level1
{
        public static String BiggerGreater(String input) {
            String temp_str = "";
            String initial_str = "", min_str = "";
            int known_counter = 0;
            int dif = 0, min_dif = 1000;
            boolean change_flag = false;

            for(int i = 0; i < input.length(); i++) {
                char c = ' ';
                temp_str = "";
                initial_str = "";
                c = input.charAt(i);

                for(known_counter = 0; known_counter < i; known_counter++)
                    initial_str += input.charAt(known_counter);

                for(int j = i + 1; j < input.length(); j++) {
                    temp_str = initial_str;
                    temp_str += input.charAt(j);
                    dif = input.charAt(j) - input.charAt(i);
                    if(dif > 0 && dif < min_dif) {
                        dif = min_dif;
                        change_flag = true;
                    }
                    for(int k = i; k < input.length(); k++) {
                        if(k != i) {
                            if(k == j) temp_str += c;
                            else temp_str += input.charAt(k);
                        }
                    }
                    if(change_flag == true) {
                        min_str = "";
                        min_str = temp_str;
                        change_flag = false;
                    }
                }
            }

            return min_str;
        }

}
