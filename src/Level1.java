import java.util.*;

public class Level1
{
    public static int MaximumDiscount(int N, int [] price) {
        boolean sorted = false;
        int temp = 0;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < price.length - 1; i++) {
                if (price[i] >= price[i + 1]) {
                    temp = price[i];
                    price[i] = price[i + 1];
                    price[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        int t = 0;
        for(int i = N - 1; i >= N/2 ; i--) {
            t = price[price.length - 1 - i];
            price[price.length - 1 - i] = price[i];
            price[i] = t;
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
