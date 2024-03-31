import java.util.Scanner;

public class FindNearestPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the number of points: ");
        System.out.println();
        int n = input.nextInt();
        double [][] points = new double[n][2];
        System.out.println("enter 8 pairs of points: ");
        for(int row = 0; row < points.length; row++){
            points[row][0] = input.nextDouble();
            points[row][1] = input.nextDouble();
        }
        double minDistance = distance(points[0][0],points[0][1],points[1][0],points[1][1]);
        double x0 = points[0][0];
        double y0 = points[0][1];
        double x1 = points[1][0];
        double y1 = points[1][1];
        double distance = 0;
        for(int row = 0; row < points.length; row++){
            for(int i = row + 1; i < points.length; i++){
                distance = distance(points[row][0],points[row][1],points[i][0],points[i][1]);
                if(minDistance > distance){
                    minDistance = distance;
                    x0 = points[row][0];
                    y0 = points[row][1];
                    x1 = points[i][0];
                    y1 = points[i][1];
                }
            }
        }
        System.out.printf("the shortest distance is %.2f", minDistance );
        System.out.println(" between " + "(" +
                x0 + ", " + y0 + ") and (" + x1 + ", " + y1 + ")");
    }
    public static double distance(double x0, double y0, double x1, double y1){
        double distance = Math.sqrt(Math.pow((x1 - x0),2) + (y1 - y0)*(y1 - y0));
        return distance;
    }
}
