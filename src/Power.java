public class Power {
    private int power(int n, int m) {
        if (m == 1) {
            return n;
        }
        return n * power(n, m - 1);
    }
}
