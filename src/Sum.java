public class Sum {
    private int sum(int num) {
        if (num / 10 == 0) {
            return num;
        }
        return (num % 10) + sum(num / 10);
    }
}
