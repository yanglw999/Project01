import java.util.Random;

public class TestEnum {
    public static void main(String[] args) {
        for(Season s : Season.values()){ // values() return a array[]
            System.out.print(s +" ");
            System.out.println(s.ordinal() +", ");
        }

        System.out.println();

        Season []season = Season.values();
        Season s = season[new Random().nextInt(4)];
        dressWearing(s);

    }
    public static void dressWearing(Season s){
        switch (s){
            case SPRING:
                System.out.println("shirt"); break;
            case SUMMER:
                System.out.println("skirt"); break;
            case FALL:
                System.out.println("coat"); break;
            case WINTER:
                System.out.println("winter jacket"); break;
        }
    }
}
enum Season{
    SPRING, SUMMER, FALL, WINTER
}

