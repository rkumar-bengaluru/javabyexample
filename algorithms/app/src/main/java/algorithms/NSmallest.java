package algorithms;

import java.util.Arrays;

public class NSmallest {

    public static int[] findSmallest(int[] d) {
        int largest = Integer.MIN_VALUE;
        int slargest = largest;
        for ( int i : d) {
            if (largest < i) {
                slargest = largest;
                largest = i;
            } else if(slargest < i) {
                slargest = i;
            }
            System.out.println("i = " + i + " , largest = " + largest + " , sl = " + slargest);
        }
        return new int[]{largest,slargest};
    }
    public static void main(String[] args) {
        int[] d = {5,4,2,3,1};
        System.out.println(Arrays.toString(findSmallest(d)));
    }
}
