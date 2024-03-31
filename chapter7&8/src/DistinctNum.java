import java.util.Arrays;

public class DistinctNum {
    public static void main(String[] args) {
    int[] sets = distinctArray(2,5,9,50,41,74,53,65,89,21,35,64,85);
        System.out.println(Arrays.toString(sets));
    }
    public static int[] distinctArray(int ... numbers){
        int[] list = new int[10];
        int n = 0;
        while (n < 10){
            int num = (int)(Math.random() * 101);
            boolean distinct = true;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] == num){
                    distinct = false;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
                if(list[i] == num){
                    distinct = false;
                    break;
                }
            }

            if(distinct){
                list[n] = num;
              n++;

            }
        }
        return list;
    }
}
