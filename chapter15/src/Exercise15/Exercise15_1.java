package Exercise15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Exercise15_1 extends Application {
    @Override
    public void start(Stage primaryStage){
        BorderPane borderPane = new BorderPane();

        Button button = new Button("Refresh");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(button);
        borderPane.setBottom(hBox);

        CardsPane cardsPane = new CardsPane();
        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().add(cardsPane);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().add(hBox2);

        borderPane.setCenter(vBox);
        button.setOnAction(e -> {
            cardsPane.clean();
            cardsPane.refresh();});


        Scene scene = new Scene(borderPane,600,300);
        primaryStage.setTitle("Exercise15_1");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void refresh(){
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setVgap(20);
        flowPane.setHgap(20);
        Random random = new Random(54);
        for(int i = 0; i < 4; i++){
            ImageView imageView = new ImageView("card/" + (random.nextInt(54) + 1) + ".png");
            flowPane.getChildren().add(imageView);
        }
    }
}
class CardsPane extends HBox {
    public CardsPane() {
        HBox pane = new HBox(20);

        pane.setAlignment(Pos.CENTER);
        int[] nums = getDiffNums(4);

        for(int n = 0; n< 4;n++) {
            ImageView imageView = new ImageView("card/" + (nums[n]) + ".png");
            getChildren().add(imageView);
        }
    }

    public void refresh() {
        int[] nums = getDiffNums(4);

        for(int n = 0; n< 4;n++) {
        ImageView imageView = new ImageView("card/" + (nums[n]) + ".png");
        getChildren().add(imageView);
         }
    }
    public void clean(){
        getChildren().clear();
    }
    public int[] getDiffNums(int n){

        int[] nums = new int[n];
        int i = 0;
        while( i < n){
            Random random = new Random();
            int r = random.nextInt(53) + 1;
            boolean isDiff = true;
            for(int j = 0; j < i; j++){
                if(nums[j] == r){
                    isDiff = false;
                    break;
                }
            }
            if(isDiff){
                nums[i] = r;
                i++;
            }
        }
        return nums;
    }
}
