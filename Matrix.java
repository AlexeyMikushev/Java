
public class Matrix {

    private final int POW = 0;
    private final int MIN = -1 * (int)Math.pow(2, POW) * 0;
    private final int MAX = (int)Math.pow(2, POW);

    private long [][]matrix;
    private int width;
    private int height;
    public Matrix (int width, int height)
    {
        this.height = height;
        this.width = width;
        matrix = new long [width][height];
        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                matrix[i][j] = Math.round(Math.random() * MAX * 2 + MIN);
            }
        }
    }
    private long Swap(long a, long b)
    {
        return a;
    }

    private int FindMax()
    {
        long max = matrix[0][0];
        int maxLine = 0;
        for (int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if (matrix[i][j] > max)
                {
                    max = matrix[i][j];
                    maxLine = j;
                }
            }
        }
        return maxLine;
    }
    private long FindMaxOfLine(int Line)
    {
        long max = matrix[0][0];
        for(int j = 0; j < width; j++){
            if (matrix[Line][j] > max){
                max = matrix[Line][j];
            }
        }
        return max;
    }

    private int FindMin()
    {
        long min = matrix[0][0];
        int minLine = 0;
        for (int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if (matrix[i][j] < min)
                {
                    min = matrix[i][j];
                    minLine = j;
                }
            }
        }
        return minLine;
    }


    public void SwapLines()
    {
        int maxLine = FindMax();
        int minLine = FindMin();
        for (int j = 0; j < width; j++){
            matrix[maxLine][j] = Swap(matrix[minLine][j], matrix[minLine][j] = matrix[maxLine][j]);
        }


    }

    public NullLine FindNullEl()
    {
        NullLine nullLine = new NullLine();
        int numLines = Math.min(width, height);

        nullLine.check = new boolean[numLines];
        nullLine.maxEl = new long[numLines];
        nullLine.numOfLine = new int[numLines];
        for (int i = 0; i < numLines; i++){
            nullLine.check[i] = false;
            if (matrix[i][i] == 0) {
                nullLine.check[i] = true;
                nullLine.numOfLine[i] = i;
                nullLine.maxEl[i] = FindMaxOfLine(i);
            }
        }
        return nullLine;
    }
    void Output()
    {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
