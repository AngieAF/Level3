public class CleanCodeCorrectVar {

    int dif = 0,  swap_ind = 0;
    dif = input.charAt(ind + 1) - input.charAt(ind);
            for(int j = ind; j < input.length() - 1; j++) {
        if((input.charAt(j + 1) - dec_element) <= dif && (input.charAt(j + 1) - dec_element) > 0) {
            dif = input.charAt(j + 1) - dec_element;
            swap_ind = j + 1;
        }
    } -> moved the declaration/initialization of dif and swap_id next to the first usage;

    String temp_str = "";
            for(int i = 0; i < input.length(); i++) {
        if(i == ind) {
            temp_str += input.charAt(swap_ind);
        } else if(i == swap_ind) {
            temp_str += input.charAt(ind);
        } else temp_str += input.charAt(i);
    } -> moved the declaration/initialization of temp_str next to the first usage;

    String res = "";
            for(int j = 0; j <= ind; j++)
    res += temp_str.charAt(j); -> moved the declaration/initialization of temp_str next to the first usage;

    year = -1; -> assigned impossible value to the variable after the end of use;

    num = -1; -> assigned impossible value to the variable after the end of use;

    boolean flag = true; -> moved the declaration/initialization next to the first usage;

    int length = 0;
    byte[] buffer = new byte[1024];
    while((length = fileInputStream.read(buffer)) > 0) {
        zipOutputStream.write(buffer, 0, length);
    }
    --> initialized variable length;

    hello = -1; --> assigned impossible value to the variable after the end of use;

    assert prices >= 0;
    Legit number of prices


    min = -1; max = -1; --> assigned impossible value to the variable after the end of use;

    int symb = -1;
    initialized variable;

    System.out.println("Input number of cubes");
    int N = keyboard.nextInt();
    assert N >= 0; --> assert non-negative number;

    System.out.println("Input number of sides");
    int M = keyboard.nextInt();
    assert M >= 0; --> assert non-negative number;

    assert prices >= -1;
    Legit number of prices;

}
