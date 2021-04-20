import java.util.*;

public class Level1
{
    public static int PrintingCosts(String Line) {
        Map<String, Integer> printerTable
                = new HashMap<String, Integer>();

        printerTable.put(" ", 0);
        printerTable.put("&", 24);
        printerTable.put(",", 7);
        printerTable.put("2", 22);
        printerTable.put("8", 23);
        printerTable.put(">", 10);
        printerTable.put("D", 26);
        printerTable.put("J", 18);
        printerTable.put("P", 23);
        printerTable.put("V", 19);
        printerTable.put("\\", 10);
        printerTable.put("b", 25);
        printerTable.put("h", 21);
        printerTable.put("n", 18);
        printerTable.put("t", 17);
        printerTable.put("z", 19);
        printerTable.put("!", 9);
        printerTable.put("'", 3);
        printerTable.put("-", 7);
        printerTable.put("3", 23);
        printerTable.put("9", 26);
        printerTable.put("?", 15);
        printerTable.put("E", 26);
        printerTable.put("K", 21);
        printerTable.put("Q", 31);
        printerTable.put("W", 26);
        printerTable.put("]", 18);
        printerTable.put("c", 17);
        printerTable.put("i", 15);
        printerTable.put("o", 20);
        printerTable.put("u", 17);
        printerTable.put("{", 18);
        printerTable.put("\"", 6);
        printerTable.put("(", 12);
        printerTable.put(".", 4);
        printerTable.put("4", 21);
        printerTable.put(":", 8);
        printerTable.put("@", 32);
        printerTable.put("F", 20);
        printerTable.put("L", 16);
        printerTable.put("R", 28);
        printerTable.put("X", 18);
        printerTable.put("^", 7);
        printerTable.put("d", 25);
        printerTable.put("j", 20);
        printerTable.put("p", 25);
        printerTable.put("v", 13);
        printerTable.put("|", 12);
        printerTable.put("#", 24);
        printerTable.put(")", 12);
        printerTable.put("/", 10);
        printerTable.put("5", 27);
        printerTable.put(";", 11);
        printerTable.put("A", 24);
        printerTable.put("G", 25);
        printerTable.put("M", 28);
        printerTable.put("S", 25);
        printerTable.put("Y", 14);
        printerTable.put("_", 8);
        printerTable.put("e", 23);
        printerTable.put("k", 21);
        printerTable.put("q", 25);
        printerTable.put("w", 19);
        printerTable.put("}", 18);
        printerTable.put("$", 29);
        printerTable.put("*", 17);
        printerTable.put("0", 22);
        printerTable.put("6", 26);
        printerTable.put("<", 10);
        printerTable.put("B", 29);
        printerTable.put("H", 25);
        printerTable.put("N", 25);
        printerTable.put("T", 16);
        printerTable.put("Z", 22);
        printerTable.put("`", 22);
        printerTable.put("f", 18);
        printerTable.put("l", 16);
        printerTable.put("r", 13);
        printerTable.put("x", 13);
        printerTable.put("~", 9);
        printerTable.put("%", 22);
        printerTable.put("+", 13);
        printerTable.put("1", 19);
        printerTable.put("7", 16);
        printerTable.put("=", 14);
        printerTable.put("C", 20);
        printerTable.put("I", 18);
        printerTable.put("O", 26);
        printerTable.put("U", 23);
        printerTable.put("[", 18);
        printerTable.put("a", 23);
        printerTable.put("g", 30);
        printerTable.put("m", 22);
        printerTable.put("s", 21);
        printerTable.put("y", 24);

        int ink = 0;

        for(int i = 0; i < Line.length(); i++) {
            if(printerTable.containsKey(Character.toString(Line.charAt(i)))) {
                ink += printerTable.get(Character.toString(Line.charAt(i)));
            }
            else ink += 23;
        }
        System.out.println(ink);
        return ink;
    }
}
