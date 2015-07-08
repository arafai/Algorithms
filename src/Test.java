import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static int intersectingDiscs(int[] A){
        int l = A.length;

        long[] A1 = new long[l];
        long[] A2 = new long[l];

        for(int i = 0; i < l; i++){
            A1[i] = (long)A[i] + i;
            A2[i] = -((long)A[i]-i);
        }

        Arrays.sort(A1);
        Arrays.sort(A2);

        long cnt = 0;

        for(int i = A.length - 1; i >= 0; i--){
            int pos = Arrays.binarySearch(A2, A1[i]);
            if(pos >= 0){
                while(pos < A.length && A2[pos] == A1[i]){
                    pos++;
                }
                cnt += pos;
            } else{ // element not there
                int insertionPoint = -(pos+1);
                cnt += insertionPoint;
            }

        }

        long sub = (long)l*((long)l+1)/2;
        cnt = cnt - sub;

        if(cnt > 1e7) return -1;

        return (int)cnt;
    }

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
    } //Array(1,5,2,1,4,0)

    public Integer[] sort(Integer[] x, Integer[]y) {
        Integer[] idxs = new Integer[x.length];
        for(int i = 0; i < x.length; i++) idxs[i] = i;
        Arrays.sort(idxs, (o1,o2) -> Integer.compare(y[o1], y[o2]));
        return idxs;
    }


}
