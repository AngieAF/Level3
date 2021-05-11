import java.util.*;

public class Level1
{
    public static boolean LineAnalysis(String line) {
        boolean flag = false;
        int begin = 0;
        ArrayList <Character> patternArr = new ArrayList<Character>();

        if(line.charAt(0) == '*') {
            flag = true;
            for(int i = 1; i < line.length(); i++) {
                if(line.charAt(i) != '*') {
                    patternArr.add(line.charAt(i));
                } else {
                    begin = i;
                    break;
                }
            }
            int k = 0;
            for(int j = begin + 1; j < line.length(); j++) {
                if(k < patternArr.size()) {
                    if(line.charAt(j) == patternArr.get(k)) {
                        flag = true;
                        k++;
                    }
                    else  {
                        flag = false;
                        break;
                    }
                } else {
                    if(line.charAt(j) != '*') {
                        flag = false;
                        break;
                    }
                    begin = j;
                    k = 0;
                }
            }
        } else flag = false;

        return flag;
    }
}
