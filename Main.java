import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    // to emply into a traditional calculator set up with keyPad and single text feild:
    // make buttons concatenate to a string, each button adds to it.
    //

    private static Double x,y,z;
    private static TextField answer,xValue, yValue;

    private static String tag;
    public static void main(String args []){
        launch(args);
    }

    @Override // a part of the extends application jazz.

    public void start(Stage primaryStage) {
        // make that window>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        primaryStage.setTitle("simpleCalculator");
        primaryStage.setResizable(false);


//taking care of the grid layout (need a layout) >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        GridPane myGrid = new GridPane();
        myGrid.setPadding(new Insets(10));
        myGrid.setHgap(4);
        myGrid.setVgap(8);
        myGrid.setAlignment(Pos.CENTER);
        myGrid.setPrefSize(250,160);
        myGrid.setGridLinesVisible(false);

// taking care of the constraints for colums >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPrefWidth(40);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(40);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(40);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(40);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPrefWidth(40);
        ColumnConstraints col5 = new ColumnConstraints();
        col5.setPrefWidth(40);
        myGrid.getColumnConstraints().addAll(col0,col1,col2,col3,col4,col5);


// instantiating and setting location of text fields! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        TextField xValue = new TextField();
        xValue.setPromptText("x");
        myGrid.add(xValue,0,0);

        TextField yValue = new TextField();
        yValue.setPromptText("y");
        myGrid.add(yValue,3,0);

        answer = new TextField();
        answer.setPromptText("answer");
        answer.setEditable(false);
        myGrid.add(answer,0,3);

        myGrid.setColumnSpan(xValue,3);
        myGrid.setColumnSpan(yValue,3);
        myGrid.setColumnSpan(answer,6);

        //BUTTONS!!!!>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        Button exp = new Button("^");
        exp.setPrefWidth(30);
        myGrid.add(exp,0,1);
        myGrid.setHalignment(exp, HPos.CENTER);
        exp.setOnAction(e -> tag = "^");

        Button root = new Button("r");
        root.setPrefWidth(30);
        myGrid.add(root,1,1);
        myGrid.setHalignment(root, HPos.CENTER);
        root.setOnAction(e->tag="root");

        Button mult = new Button ("x");
        mult.setPrefWidth(30);
        myGrid.add(mult,2,1);
        myGrid.setHalignment(mult, HPos.CENTER);
        mult.setOnAction(e->tag="mult");

        Button div = new Button ("/");
        div.setPrefWidth(30);
        myGrid.add(div,3,1);
        myGrid.setHalignment(div, HPos.CENTER);
        div.setOnAction(e->tag="div");

        Button add = new Button ("+");
        add.setPrefWidth(30);
        myGrid.add(add,4,1);
        myGrid.setHalignment(add, HPos.CENTER);
        add.setOnAction(e->tag="add");

        Button subt = new Button ("-");
        subt.setPrefWidth(30);
        myGrid.add(subt,5,1);
        myGrid.setHalignment(subt, HPos.CENTER);
        subt.setOnAction(e->tag="subt");

        Button eqls = new Button ("=");
        eqls.setPrefWidth(30);
        myGrid.add(eqls,0,2);
        myGrid.setHalignment(eqls, HPos.CENTER);
        eqls.setOnAction(e-> {

                x=Double.valueOf(xValue.getText());
                y=Double.valueOf(yValue.getText());
            switch(tag){
                case "^":
                    z=Math.pow(x,y);
                    break;
                case "root":
                    z=Math.pow(x,1/y);
                    break;
                case "mult":
                    z=x*y;
                    break;
                case"div":
                    z=x/y;
                    break;
                case "add":
                    z=x+y;
                    break;
                case "subt":
                    z=x-y;
                    break;
                default:
                    z=-1.0;
                    break;
            }
            answer.setText(z.toString());

        });


        Button clear = new Button ("C");
        clear.setPrefWidth(30);
        myGrid.add(clear,1,2);
        myGrid.setHalignment(clear, HPos.CENTER);
        clear.setOnAction(e-> {
            xValue.setText(null);
        yValue.setText(null);
        answer.setText(null);
        });


//The scene routine >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Scene myScene = new Scene(myGrid);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }



}
