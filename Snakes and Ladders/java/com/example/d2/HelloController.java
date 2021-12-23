package com.example.d2;

import com.dlsc.formsfx.model.util.TranslationService;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
//    @FXML
//    private Button bt1;

    @FXML
    private Label locval;

    @FXML
    private Label diceValue;

    @FXML
    private Label diceValue2;

    @FXML
    private Button beginRoll;

    @FXML
    private Label posDet;

//    @FXML
//    private Button bt2;

    @FXML
    private ImageView diceImage;

    @FXML
    private ImageView bt1;

    @FXML
    private ImageView bt2;


    @Override
    public void initialize(URL argo, ResourceBundle arg1){
        blue = new token(bt1);
        me = new player();
        d1 = new diceRoll();
        red = new token(bt2);
        d2 = new diceRoll();

        gameStatus = false;
    }

//    double[] boardCoordinateX = {8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0 };
//    double[] boardCoordinateY = {231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0 };



    token blue;
    player me;
    token red;
//    boardNavigation n1;
    diceRoll d1;
    diceRoll d2;
    boolean gameStatus;

    public void initialize(){
//        blue = new token(bt1);
//        me = new player();
//        d1 = new diceRoll();
//        n1 = new boardNavigation();
    }

    public void findloc(MouseEvent event) {
//        locval.setText("Move to X: " + String.valueOf(event.getSceneX()) + " Y: " + String.valueOf(event.getSceneY()));
        me.ask2move(event, locval);
    }

    public boolean begin(MouseEvent event) throws InterruptedException {
        boolean status1 = blue.makeAmove(locval, d1);
        if(status1){
            posDet.setText("Game Over: Player 1 has Won...");
        }
        return status1;
    }

    public boolean begin2(MouseEvent event) throws InterruptedException {
        boolean status2 = red.makeAmove(locval, d2);
        if(status2){
            posDet.setText("Game Over: Player 2 has Won");
        }
        return status2;
    }


    public void move(ActionEvent event) {

//        blue.makeAmove(locval, d1);
    }

    public void move2(ActionEvent event){

    }

    class diceRoll{

        public int doRoll(){
            Random rand = new Random();
            int num = rand.nextInt(1, 7);
            diceValue.setText(String.valueOf(num));
            for (int i = 0; i < 15; i++) {
                File file = new File("dice/num" + num + "jpg");
                diceImage.setImage(new Image(file.toURI().toString()));
            }
            
            return num;
        }

    }

    class boardNavigation{

        ImageView bt;
        TranslateTransition t1 = new TranslateTransition();
        double orgx = 14.0;
        double orgy = 280.0;
        boardNavigation(ImageView bt){
            this.bt = bt;
            t1.setNode(bt);
        }
        public double[] boardCoordinateX = {8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 34.0, 58.0, 84.0, 109.0, 134.0, 154.0, 184.0, 209.0, 235.0, 235.0, 210.0, 184.0, 154.0, 134.0, 109.0, 84.0, 58.0, 34.0, 8.0, 8.0, 8.0, 8.0 };
        public double[] boardCoordinateY = {231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 231.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 207.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 182.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 157.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 132.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 108.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 83.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 58.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 33.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0 };
        public double[] returnCoordinate = new double[2];
        int i = 0;

        double [] startJourney(double pointerX, double pointerY, int rollValue) throws InterruptedException {

            if(i + rollValue > 100){
                returnCoordinate[0] = boardCoordinateX[i];
                returnCoordinate[1] = boardCoordinateY[i];
                return returnCoordinate;
            }

            if(i >= 100 && pointerX != 8.0 && pointerY != 8.0){
                i = i - rollValue;
                returnCoordinate[0] = boardCoordinateX[i];
                returnCoordinate[1] = boardCoordinateY[i];
                return returnCoordinate;
            }

            pointerX = boardCoordinateX[i + rollValue];
            pointerY = boardCoordinateY[i + rollValue];
            i = i + rollValue;

            if(i >= 100 && pointerX != 8.0 && pointerY != 8.0){
                i = i - rollValue;
                returnCoordinate[0] = boardCoordinateX[i];
                returnCoordinate[1] = boardCoordinateY[i];
                return returnCoordinate;
            }

            if(i < 100){
                if(pointerX == 109.0 && pointerY == 207.0){
                    returnCoordinate[0] = 134.0;
                    returnCoordinate[1] = 231.0;
                    i = 5;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 6");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 134.0 && pointerY == 132.0){
                    returnCoordinate[0] = 109.0;
                    returnCoordinate[1] = 182.0;
                    i = 24;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 25");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 209.0 && pointerY == 132.0){
                    returnCoordinate[0] = 235.0;
                    returnCoordinate[1] = 207.0;
                    i = 10;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 11");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 34.0 && pointerY == 83.0){
                    returnCoordinate[0] = 34.0;
                    returnCoordinate[1] = 207.0;
                    i = 18;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 19");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 84.0 && pointerY == 83.0){
                    returnCoordinate[0] = 8.0;
                    returnCoordinate[1] = 108.0;
                    i = 59;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 60");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 154.0 && pointerY == 58.0){
                    returnCoordinate[0] = 184.0;
                    returnCoordinate[1] = 108.0;
                    i = 52;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 53");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 210.0 && pointerY == 8.0){
                    returnCoordinate[0] = 184.0;
                    returnCoordinate[1] = 33.0;
                    i = 88;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 89");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 134.0 && pointerY == 8.0){
                    returnCoordinate[0] = 134.0;
                    returnCoordinate[1] = 58.0;
                    i = 74;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 75");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 34.0 && pointerY == 8.0 ){
                    returnCoordinate[0] = 8.0;
                    returnCoordinate[1] = 58.0;
                    i = 79;
                    posDet.setText("OOPS!! SNAKE ENCOUNTERED, MOVED TO SQUARE 80");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 34.0 && pointerY == 231.0){
                    returnCoordinate[0] = 58.0;
                    returnCoordinate[1] = 157;
                    i = 37;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 38");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 154.0 && pointerY == 231.0){
                    returnCoordinate[0] = 154.0;
                    returnCoordinate[1] = 207.0;
                    i = 13;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 14");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 184.0 && pointerY == 231.0){
                    returnCoordinate[0] = 235.0;
                    returnCoordinate[1] = 157.0;
                    i = 30;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 39");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 134.0 && pointerY == 207.0){
                    returnCoordinate[0] = 134.0;
                    returnCoordinate[1] = 182.0;
                    i = 25;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 26");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 8.0 && pointerY == 182.0){
                    returnCoordinate[0] = 34.0;
                    returnCoordinate[1] = 132.0;
                    i = 41;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 42");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 184.0 && pointerY == 182.0){
                    returnCoordinate[0] = 84.0;
                    returnCoordinate[1] = 33.0;
                    i = 83;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 84");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 109.0 && pointerY == 157.0){
                    returnCoordinate[0] = 84.0;
                    returnCoordinate[1] = 132.0;
                    i = 43;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 44");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 235.0 && pointerY == 107.0){
                    returnCoordinate[0] = 154.0;
                    returnCoordinate[1] = 83.0;
                    i = 66;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 67");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 235.0 && pointerY == 58.0){
                    returnCoordinate[0] = 235.0;
                    returnCoordinate[1] = 8.0;
                    i = 90;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 91");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 58.0 && pointerY == 58.0){
                    returnCoordinate[0] = 58.0;
                    returnCoordinate[1] = 8.0;
                    i = 97;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 98");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
                else if(pointerX == 154.0 && pointerY == 33.0){
                    returnCoordinate[0] = 154.0;
                    returnCoordinate[1] = 8.0;
                    i = 93;
                    posDet.setText("YAYY!! LADDER ENCOUNTERED, MOVED TO SQUARE 94");
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(pointerX - orgx);
                    t1.setToY(pointerY - orgy);
                    t1.play();
                    t1.setDelay(Duration.millis(1000));
                    return returnCoordinate;
                }
            }



            returnCoordinate[0] = pointerX;
            returnCoordinate[1] = pointerY;

            return new double[]{boardCoordinateX[i + rollValue], boardCoordinateY[i + rollValue]};
        }



    }

    class token{
        public double orgx;
        public double orgy;
        public double currx;
        public double curry;
        public double pointerX;
        public double pointerY;
        public ImageView bt;
        boardNavigation b = new boardNavigation(bt);
        TranslateTransition t1 = new TranslateTransition();
        public double dc = 0;
        boolean unlock;
        boolean open;
        boolean gameOver;
        token(ImageView bt){
            Bounds bis = bt.localToScene(bt.getBoundsInLocal());
            System.out.println(bis);
            this.bt = bt;
//            this.b = b;
            orgx = bis.getMinX();
            orgy = bis.getMinY();
            currx = orgx;
            curry = orgy;
            pointerX = orgx;
            pointerY = orgy;
            unlock = false;
//            diceRoll d1 = new diceRoll();
            open = true;
//            boardNavigation b1 = new boardNavigation();
            t1.setNode(bt);
            gameOver = false;
        }





        boolean makeAmove(Label locval, diceRoll d1) throws InterruptedException {

            int diceValue = d1.doRoll();
//            bt.setTranslateX(boardCoordinateX[1]-orgx);
//            bt.setTranslateY(boardCoordinateY[1]-orgy);


            if(open){
                if(diceValue == 6){
                    unlock = true;
                    System.out.println(orgx + " " + orgy);
//                    bt.setTranslateX(b.boardCoordinateX[0]-orgx);
//                    bt.setTranslateY(b.boardCoordinateY[0]-orgy);
                    t1.setDuration(Duration.millis(1000));
                    t1.setToX(b.boardCoordinateX[0]-orgx);
                    t1.setToY(b.boardCoordinateY[0]-orgy);
                    t1.play();
                    pointerX = b.boardCoordinateX[0]-orgx;
                    pointerY = b.boardCoordinateY[0]-orgy;
                    open = false;
                }
            }
            else if(unlock){
                b.startJourney(pointerX, pointerY, diceValue);
//                bt.setTranslateX(b.returnCoordinate[0] - orgx);
//                bt.setTranslateY(b.returnCoordinate[1] - orgy);
//                t1.setDelay(Duration.millis(500));
                t1.setDuration(Duration.millis(1000));
                t1.setToX(b.returnCoordinate[0] - orgx);
                t1.setToY(b.returnCoordinate[1] - orgy);
                t1.play();
                if(b.boardCoordinateX[0] == 8.0 && b.boardCoordinateY[1] == 8.0){
                    gameOver = true;
                }

            }


//            bt.setTranslateX(p.desx-orgx);
//            bt.setTranslateY(p.desy-orgy);
//
//            dc = dc + Math.sqrt((currx - p.desx) * (currx - p.desx) + (curry - p.desy) * (curry - p.desy));
//            currx = orgx;
//            curry = orgy;
//            locval.setText(("Distance Moved: " + String.valueOf(dc)));
            return gameOver;
        }
    }

    class player{
        public double desx;
        public double desy;
        public void ask2move(MouseEvent event, Label locval){
            locval.setText("Move to X: " + String.valueOf(event.getSceneX()) + " Y: " + String.valueOf(event.getSceneY()));
            desx = event.getSceneX();
            desy = event.getSceneY();
        }

    }
}