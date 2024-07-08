public class MyInteger {
    private int value;
    private static MyInteger [] cache = new MyInteger[256];
     public static final int LOW = -128;
     public static final int HIGH = 127;

     public MyInteger(int value){
         this.value = value;
     }

     static {
         for(int i = MyInteger.LOW; i <= MyInteger.HIGH; i++){
             cache[i + 128] = new MyInteger(i);
         }
     }
     public static MyInteger valueOf(int i){
         if(i >= LOW && i <= HIGH){
             return cache[i + 128];
        }else{
             return new MyInteger(i);
         }
     }
    public String toString(){
         return this.value + "";
    }
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(3);
        System.out.println(myInteger.toString());
    }

}
