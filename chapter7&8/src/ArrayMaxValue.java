public class ArrayMaxValue {
    public static void main(String[] args) {
        double[] num = arrayExclusive(30);

        System.out.println(" display an array: ");
        arrayPrint(num);
        System.out.println("the biggest value of the array: " + maxValue(num));
        System.out.println("sort the array from small to big: ");
        arraySortSmallToBig(num);
        System.out.println("display the array after sort: ");
        arrayPrint(num);

    }
    public static double[] arrayExclusive(int n){
        double[]array = new double[n];
       // array[0] = (int) (Math.random() * 101);
        int i = 0;
        while( i < array.length){
            boolean diff = true;
            int num = (int) (Math.random() * 101);
            for(int j = 0 ; j < i; j++) {
                if(array[j] == num ) {
                    diff = false;
                    break;
                }
            }
            if(diff){
                array[i] = num;
                i++;
            }
        }
        return array;

    }
    public static void arrayPrint(double[]array){
        for(int i = 0; i < array.length; i++){
            if((i+1) % 10 != 0){
                System.out.printf("%-6.1f",array[i]);
            }else{
                System.out.printf("%-6.1f\n",array[i]);
            }
        }
    }
    public static double maxValue(double[]array){
        double max = array[0];
        for(int i = 1 ; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
    public static void arraySortSmallToBig(double[]array){
        double temp ;
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }

    }
}
