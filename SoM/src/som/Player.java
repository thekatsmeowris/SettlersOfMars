/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import devCards.Knight;
import devCards.ProgressCard;
import devCards.VictoryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import progressCards.Monopoly;
import progressCards.RoadBuilding;
import progressCards.YearOfPlenty;
import som.assets.*;

/**
 *
 * @author makogenq
 */
public class Player {
    final int VICTORY_POINT_MAX=10;
    Integer diceRoll;
    private TradePack tradePack= new TradePack(this);
    Pane pnPlayerInfo=new Pane();
    Arc victoryPointGauge = new Arc();
    
    int[] resources;
    ArrayList<DevelopmentCard> hand;
    private int freeSettlements = 2;
    private int freeRoads = 2;
  
    ResourceManager resourceManager= new ResourceManager(); 
    private int victoryPoints;
    
    Color playerColor;
    String nickname;

    public int getVictoryPoints() {
        return victoryPoints;
    }
    //String n, d, imgName;
    PlayerAssets assets;
    DevelopmentDeck deck;
    DevelopmentCard card;//Creates an object instance of the card from the development deck
   
    
    Player(){

        assets = new PlayerAssets();
        resources= new int[]{0,0,0,0,0};
        hand=new ArrayList<>(25);
        victoryPoints=0;
        //hand=new ArrayList[24];
        //for(int i=0; i<24; i++){
           // hand[i]=new ArrayList<DevelopmentCard>();
        //}
        
        
        Knight k= new Knight();
        VictoryPoint vp=new VictoryPoint();
        YearOfPlenty yop=new YearOfPlenty();
        Monopoly mp=new Monopoly();
        RoadBuilding rb=new RoadBuilding();
       
    }
    
    


	


    Player(String name, Color playerColor) {
        assets = new PlayerAssets();
            nickname=name;
            this.playerColor=playerColor;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }
    
    


	public void buy(){
		// resources.bankDrawResource("SOY", 10);
		// resources.printResourceList();

        }
    public void setTradePack(TradePack tradePack) {
        this.tradePack = tradePack;
    }

    public String getNickname() {
        return nickname;
    }


	@Override
	public String toString() {
		return "Player{" + "VICTORY_POINT_MAX=" + VICTORY_POINT_MAX + ", pnPlayerInfo=" + pnPlayerInfo
				+ ", victoryPointGauge=" + victoryPointGauge + ", resources=" + resources + ", resourceManager="
				+ resourceManager + ", victoryPoints=" + victoryPoints + ", playerColor=" + playerColor + ", nickname="
				+ nickname + ", assets=" + assets + '}';
	}


		





    Player(String name, int[] resources, Color playerColor) {
        this.nickname=name;
        this.resources=resources;
        victoryPoints=4;
        assets = new PlayerAssets();
        this.playerColor=playerColor;
    }
   
    public void addCard(DevelopmentCard d){
		hand=new ArrayList<>();
		hand.add(d);
	}
    public void ifDevCardVictoryPoint(ArrayList<DevelopmentCard> hand1){
        /*for (Iterator<DevelopmentCard> it = hand.iterator(); it.hasNext();) {
        DevelopmentCard d1 = it.next();
        VictoryPoint vp=new VictoryPoint();
        if(d1==VictoryPoint vp)
        victoryPoints+=1;
        }*/
       
        hand.forEach((DevelopmentCard d1) -> {//Go through whole deck 
            //if("Victory Point".equals(d1.getName()))
            if(d1 instanceof VictoryPoint) {//check if the card is an instance of VictoryPoint
                victoryPoints+=1;//add to the VictoryPoints of the player
                hand.remove(d1);//remove the card that was a VictoryPoint
                System.out.println("There is a VP in deck");
                
            }
            else{
                System.out.println("There is no VP in deck");
            }
                
            
           
        });
    }
    public void useKnight(DevelopmentCard d){
        
    }
    public void useMonopoly(DevelopmentCard d){
        
    }
    public void useYearOfPlenty(DevelopmentCard d){
        
    }
    public void useRoadBuilding(DevelopmentCard d){
        
    }
    public void setVictoryPoints(int value){
        victoryPoints=value;
        victoryPointGauge.setLength(((double)value/(double)VICTORY_POINT_MAX)*360);     //3.6 is 360 divided by the 100 for the 100 we would have multiplied the value/vpMax to get a percentage.
        System.out.println(pnPlayerInfo.getWidth());
        if (victoryPoints > 6) {
			MediaClass.playMusic2();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(GameRoomSelectController.class.getName()).log(Level.SEVERE, null, ex);
			}
			// SoM.mMusic1.stop();
		}
    }
    
	public int getFreeSettlements() {
		return freeSettlements;
	}
        Color getPlayerColor() {
		return playerColor;
	}
public int[] removeResources(int[] resources) {
		for (int i = 0; i < this.resources.length; i++) {
			this.resources[i] -= resources[i];
		}
		return resources;
	}
	public void setFreeSettlements(int freeSettlements) {
		this.freeSettlements = freeSettlements;
	}

	public int getFreeRoads() {
		return freeRoads;
	}

	public void setFreeRoads(int freeRoads) {
		this.freeRoads = freeRoads;
	}
        public int[] getResources() {
		return resources;
	}

	public void setResources(int[] resources) {
		this.resources = resources;
	}

	public void addResource(int resourceType, int qty) {
		this.resources[resourceType] += qty;
	}

	public void addResources(int[] resources) {
		for (int i = 0; i < this.resources.length; i++) {
			this.resources[i] += resources[i];
		}
	}

	public void setResource(int index, int value) {
		this.resources[index] = value;
	}
        public TradePack getTradePack() {
		return tradePack;
	}
            public int countResources() {
        int counter = 0;

        for (int i = 0; i < resources.length - 1; i++) {
            counter += resources[i];
        }
        return counter;
    }
    	
}


