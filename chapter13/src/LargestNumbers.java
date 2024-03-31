import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class LargestNumbers {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(45);//45 自动转换为 Integer对象并增加到列表中
        list.add(new BigInteger("52896359863598356"));//BigInteger(“  ”); must have quote marks
        list.add(new BigDecimal(2.23569874236987456321326595)); //BigDecimal() OR BigDecimal(“ ”)
        list.add(5.36);//  5.36 自动转换为 Double 对象并增加到列表中
        System.out.println(" the largest num is : " + largestNumber(list));

    }
    public static Number largestNumber(ArrayList<Number> numbers){
        if(numbers.isEmpty() || numbers == null){
            return null;
        }
        Number max = numbers.get(0);
        // max = numbers.get(0).doubleValue();

       // int index = 0;
        for(int i = 1; i < numbers.size(); i++){
            if (max.doubleValue() < numbers.get(i).doubleValue()){
                max = numbers.get(i);
              //  index = i;

            }
        }
        return max;
    }
}
