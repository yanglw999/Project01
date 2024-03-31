public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] matrix = get2DArray(10,10);
        print2DArray(matrix);
        System.out.println("the total is : " + sum2DArray(matrix));
        subtotalColumn2DArray(matrix);
    }
    public static int[][] get2DArray(int n, int m){
        int[][]matrix = new int[n][m];
        for( int row = 0; row < matrix.length; ){
            for(int column = 0; column < matrix[row].length; ){
                int fill = (int)(Math.random()*100 + 1);
                boolean distinct = true;

                for(int i =0; i <= row; i++){
                    for(int j = 0; j < matrix[row].length; j++){
                        if(matrix[i][j] == fill){
                            distinct = false;
                            break;
                        }
                    }
                }
                if(distinct){
                    matrix[row][column] = fill;
                    column++;
                }
            }
            row++;
        }
        return matrix;
    }
    public static void print2DArray(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){
                System.out.printf("%-5d", matrix[row][column] );
            }
            System.out.println();
        }
    }
    public static int sum2DArray(int[][]matrix){
        int sum = 0;
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length; column++){
                sum = sum + matrix[row][column];
            }
        }
        return sum;
    }
    public static void subtotalColumn2DArray(int [][]matrix){
        System.out.println("the subtotal of each column: ");;
        for(int column = 0; column < matrix[0].length; column++){
            int subtotal = 0;
            for( int row = 0; row < matrix.length; row++){
                subtotal = subtotal + matrix[row][column];
            }
            System.out.printf("%-5d",subtotal);
        }
    }
}
