/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;


/**
 *
 * @author makogenq
 */
public class Player {
    final int VICTORY_POINT_MAX=10;
    
    private TradePack tradePack= new TradePack(this);


    Pane pnPlayerInfo=new Pane();
    Arc victoryPointGauge = new Arc();
    
    
    int[] resources;
    ResourceManager resourceManager= new ResourceManager(); 
    private int victoryPoints;
    
    Color playerColor;
    String nickname;
    Assets assets;
    Player(){

        assets=new Assets();
        resources= new int[]{0,0,0,0,0}; 
        victoryPoints=0;
        
    }

    Player(String name, Color playerColor) {
        assets=new Assets();
            nickname=name;
            this.playerColor=playerColor;
    }

    Player(String name, int[] resources, Color playerColor) {
        this.nickname=name;
        this.resources=resources;
        victoryPoints=0;
        assets=new Assets();
        this.playerColor=playerColor;
    }
    public void setVictoryPoints(int value){
        victoryPoints=value;
        victoryPointGauge.setLength(((double)value/(double)VICTORY_POINT_MAX)*360);     //3.6 is 360 divided by the 100 for the 100 we would have multiplied the value/vpMax to get a percentage.
        System.out.println(pnPlayerInfo.getWidth());
    }
    
    	public void build(String assetName){
		if (assetName.equals("SETTLEMENT"));
		else if (assetName.equals("ROAD"));
		else if (assetName.equals("CITY"));
	}

	public void buy(){
		// resources.bankDrawResource("SOY", 10);
		// resources.printResourceList();
	}




    int getVictoryPoints() {
        return victoryPoints;
    }
    public TradePack getTradePack() {
        return tradePack;
    }

    public void setTradePack(TradePack tradePack) {
        this.tradePack = tradePack;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int[] getResources() {
        return resources;
    }
    
    public void setResource(int index, int value) {
        this.resources[index]=value;
    }
    
    public void setResources(int[] resources) {
        this.resources = resources;
    }
    
    public void addResource(int resourceType, int qty){
            this.resources[resourceType]+=qty;
    }
    
    public void addResources(int[] resources){
        for(int i=0; i<this.resources.length;i++){
            this.resources[i]+=resources[i];
        }
    }
 
    public int[] removeResources(int[] resources){
        for(int i=0; i<this.resources.length;i++){
            this.resources[i]-=resources[i];
        }
        return resources;
    }

    @Override
    public String toString() {
        return "Player{" + "VICTORY_POINT_MAX=" + VICTORY_POINT_MAX + ", pnPlayerInfo=" + pnPlayerInfo + ", victoryPointGauge=" + victoryPointGauge + ", resources=" + resources + ", resourceManager=" + resourceManager + ", victoryPoints=" + victoryPoints + ", playerColor=" + playerColor + ", nickname=" + nickname + ", assets=" + assets + '}';
    }


    
    public int countResources()
    {
        int counter = 0;
        
        for(int i = 0; i < resources.length -1; i++)
        {
            counter += resources[i];
        }
        return counter;
    }

    Color getPlayerColor() {
        return playerColor;
    }






 
}
