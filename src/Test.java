import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public ArrayList<Integer> toArray(int test) {
        int temp = test;
        ArrayList<Integer> array = new ArrayList<Integer>();
        do {
            array.add(temp % 10);
            temp /= 10;
        } while (temp > 0);

        Collections.reverse(array);
        return array;
    }

    public int solution(int a, int b) {
        ArrayList<Integer> first = toArray(a);
        ArrayList<Integer> second = toArray(b);
        int firstSize = first.size();
        int secondSize = second.size();

        if (firstSize + secondSize > 8)
            return -1;

        int max = firstSize > secondSize ? firstSize : secondSize;
        int result = 0;
        for (int i = 0; i < max; i++) {
            if (i < firstSize) {
                result = result * 10 + first.get(i);
            }
            if (i < secondSize) {
                result = result * 10 + second.get(i);
            }
        }
        return result;
    }
}
