/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

import javafx.stage.Stage;

/**
 *
 * @author makogenq
 */
public class SoM extends Application {
    
    //private static URL musicURL1, musicURL2;
    //static AudioClip aMusic1, aMusic2;
     String music1Path = "src/som/music/WASTELAND2melody.wav";
    Media mMusic1 = new Media(new File(music1Path).toURI().toString());
     String music2Path = "src/som/music/EDGEofAWARE1wbrass.wav";
    Media mMusic2 = new Media(new File(music2Path).toURI().toString());
    static MediaPlayer mediaPlayer1;
    static MediaPlayer mediaPlayer2;
    MediaView  mediaView;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mediaPlayer1 = new MediaPlayer(mMusic1); //mediaPlayer
        mediaPlayer2 = new MediaPlayer(mMusic2); //mediaPlayer
        mediaView = new MediaView(mediaPlayer1);
        mediaView.setMediaPlayer(mediaPlayer1);
        
        loadAudioAssets();      
        
        Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
        ResourceBank resourceBank= new ResourceBank();
        resourceBank.printResourceList();
        Scene scene = new Scene(root);
        
        stage.setX(300);
        stage.setY(0);
        
        stage.setTitle("Title Screen");
        stage.setScene(scene);
        stage.show();

        playMusic1();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
        
      
        
    }
    
     //<editor-fold defaultstate="collapsed" desc="comment">
    private void loadAudioAssets(){
        
        
        
        /*musicURL1 = getClass().getResource("/WASTELAND1.wav");
        aMusic1 = new AudioClip(musicURL1.toString());
        musicURL2 = getClass().getResource("/WASTELAND2.wav");
        aMusic2 = new AudioClip(musicURL2.toString());*/
    }
    
    public static void playMusic1() {
        //aMusic1.setCycleCount(AudioClip.INDEFINITE);
        //aMusic1.play();
        
       mediaPlayer1.setCycleCount(AudioClip.INDEFINITE);
        mediaPlayer1.play();
        //if(mediaPlayer2.getStatus().equals(Status.PLAYING))
           // mediaPlayer2.stop();
    }
    
    public static void playMusic2() {
        //aMusic2.setCycleCount(AudioClip.INDEFINITE);
        //aMusic2.play();
        
        //mediaPlayer1.setCycleCount(AudioClip.INDEFINITE);
        //mediaPlayer1.play();
        
        mediaPlayer2.play();
        if(mediaPlayer1.getStatus().equals(Status.PLAYING))
            mediaPlayer1.stop();
    }
//</editor-fold>
    
    
    public void TestDeck() {
		Knight k = new Knight();
		VictoryPoint vp = new VictoryPoint();
		YearOfPlenty yop = new YearOfPlenty();
		Monopoly mp = new Monopoly();
		RoadBuilding rb = new RoadBuilding();
		DevelopmentDeck d = new DevelopmentDeck();

		
		d.addCard(k);
		d.addCard(vp);
		// d.addCard(yop);
		// d.addCard(mp);
		d.addCard(rb);
		while (d.hasCard()){
			DevelopmentCard card = d.drawCard();
			System.out.println(card);	
			if (card instanceof RoadBuilding)
				card.playCard();
                }
        }
    
}
