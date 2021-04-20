import java.util.*;

public class Level1
{
    public static String TheRabbitsFoot(String s, boolean encode) {

        ArrayList<Character> fin = new ArrayList<>();
        int len = 0;
        double root = 0.0;
        int rowNumber = 0;
        int columnNumber = 0;


        if (encode) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ')
                    fin.add(s.charAt(i));
            }
            System.out.println(fin);

            len = fin.size();
            root = Math.sqrt(len);

            String str = String.valueOf(root);
            System.out.println(str);

            rowNumber = Integer.parseInt(String.valueOf(str.charAt(0)));
            System.out.println(rowNumber);

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.')
                    columnNumber = Integer.parseInt(String.valueOf(str.charAt(i + 1)));
            }
            System.out.println(columnNumber);

            while (rowNumber * columnNumber < len) {
                if (rowNumber > columnNumber)
                    columnNumber += 1;
                else rowNumber += 1;
            }

            System.out.println("columns: " + columnNumber + " rows: " + rowNumber);

            ArrayList<Character> res = new ArrayList<>();
            int counter = 0, line = 0;

            while (counter < fin.size()) {
                for (int j = line; j <= rowNumber + line; j++) {
                    if (j < fin.size()) {
                        if (j == rowNumber + line) {
                            res.add('\n');
                            line = j;
                            break;
                        } else res.add(fin.get(j));
                    } else {
                        line = fin.size();
                        break;
                    }
                }
                counter = line;
            }

            System.out.println(res);

            String finStr = new String();
            counter = 0;

            int flag = 0;
            while (counter < rowNumber) {
                for (int i = counter; i < res.size(); i += (columnNumber + 1)) {
                    finStr += res.get(i);

                }
                counter++;
                if(counter < rowNumber)
                    finStr += ' ';
            }

            System.out.println(finStr);
            return finStr;

        }
        else {
            String finStr = new String();
            int counter = 0, space_count = 0;
            for(int i = 0; i < s.length(); i++)
                if(s.charAt(i) == ' ') space_count += 1;


            while(counter <= space_count) {
                finStr += s.charAt(counter);
                for(int i = counter; i < s.length(); i++) {
                    if(s.charAt(i) == ' ') {
                        if(s.charAt(i + counter + 1) == ' ') break;
                        finStr += s.charAt(i + counter + 1);
                    }

                }
                counter++;
            }

            System.out.println(finStr);
            return finStr;
        }
    }
}
