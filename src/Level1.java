import java.util.*;

public class Level1
{
    public static int MaximumDiscount(int N, int [] price) {
        int max = price[0];
        for(int j = 0; j <= N/2 + 2; j++) {
            for(int i = 0; i < N - 1 - j; i++) {
                if(price[i] >= price[i + 1]) {
                    max = price[i];
                    price[i] = price[i + 1];
                    price[i + 1] = max;
                }
            }
        }

        int temp = 0;
        for(int i = 0; i <= N/2; i++) {
            temp = price[i];
            price[i] = price[N - 1 - i];
            price[N - 1 - i] = temp;
        }

        int total = 0, sum = 0;
        for(int i = 0; i < N; i++) {
            sum += price[i];
            if((i + 1) % 3 != 0)
                total += price[i];
        }

        return (sum - total);
    }
}
