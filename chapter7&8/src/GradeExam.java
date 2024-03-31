public class GradeExam {
    public static void main(String[] args) {
        char[][] alphabet = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'}};
        char [] key = {'D','B','D','C','C','D','A','E','A','D'};
        for(int row = 0; row < alphabet.length; row++){
            int count = 0;
            for(int column = 0; column < alphabet[row].length; column++){
                if(alphabet[row][column] == key[column]){
                    count++;
                }
            }
            System.out.println(" the right answer number of student " + (row + 1) + ": " + count );
        }
    }

}
