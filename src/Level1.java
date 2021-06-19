import java.util.*;

public class Level1
{
    public static boolean white_walkers(String village) {
        int c = 0, counter = 0;
        char num = ' ';
        int num_pos = 0;
        for(int s = 0; s < village.length(); s++) {
            if(Character.isDigit(village.charAt(s))) {
                c++;
                if(c > 1) {
                    if((Integer.parseInt(String.valueOf(num)) +
                            Integer.parseInt(String.valueOf(village.charAt(s))) == 10)) {
                        for(int i = s - 1; i > num_pos; i--) {
                            if(village.charAt(i) == '=')
                                counter++;
                        }
                        if(counter != 3) return false;
                        counter = 0;
                    }
                }
                num = village.charAt(s);
                num_pos = s;
            }

        }
        if(c  <= 1) return false;
        return true;
    }
}
