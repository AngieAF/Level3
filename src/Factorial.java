
public class Factorial {

    public static int squirrel(int N) {
        double total = 1;
        for(int i = 1; i <= N; i++)
            total = i * total;

        String str = String.valueOf(total);

        int diamond = Integer.parseInt(String.valueOf(str.charAt(0)));

        return diamond;

    }
}
