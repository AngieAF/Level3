public class white_walkers {
    public static void main(String[] args) {
        System.out.println(white_walkers("9===1===19===10===9"));
    }

    public static boolean white_walkers(String village) {
        int c = 0, counter = 0;
        char num = ' ';
        int num_pos = 0;
        for(int s = 0; s < village.length(); s++) {
            if(Character.isDigit(village.charAt(s))) {
                c++;
                if(c > 1) {
                    whiteWalkerDetector(num, village, s, num_pos, counter);
                }
                num = village.charAt(s);
                num_pos = s;
            }

        }
        if(c  <= 1) return false;
        return true;
    }


    public static boolean whiteWalkerDetector(int num, String village, int s, int num_pos, int counter) {
        final int TEMPERATURE_DROP = 10;
        final int WALKERS_COUNT = 3;
        int whiteWalker = Integer.parseInt(String.valueOf(num)) +
                Integer.parseInt(String.valueOf(village.charAt(s)));
        // if the temperature drops 10 degrees it means there is a white walker
        if(whiteWalker == TEMPERATURE_DROP) {
            for(int i = s - 1; i > num_pos; i--) {
                if(village.charAt(i) == '=')
                    counter++;
            }
            if(counter != WALKERS_COUNT) return false;
            counter = 0;
        }
        return true;
    }
}
