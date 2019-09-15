package log;

public class TaylorS {

    public static double logn(double x, int k){
        double curr = 0;
        double result = 0;
        double epsilon = Math.pow(10, -1 * k);
        int i = 0;

        while (epsilon < Math.abs(curr)){
            result += curr;
            curr = func(x, ++i);
        }

        return result;
    }

    private static double func(double x, int n){
        return Math.pow(x, n) / (-1 * n);
    }
}
