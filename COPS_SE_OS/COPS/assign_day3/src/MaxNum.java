import java.util.Arrays;

public class MaxNum {
    public static int getMax(int numbers[]) {
        Arrays.sort(numbers);
        return (numbers[numbers.length - 1]);
    }
    }


