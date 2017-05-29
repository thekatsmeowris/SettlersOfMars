/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author david
 */
public class Cpu extends Player{
    
    private int victoryPoints;
    private TradePack tradePack= new TradePack(this);
    private int priority;

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public TradePack getTradePack() {
        return tradePack;
    }

    public void setTradePack(TradePack tradePack) {
        this.tradePack = tradePack;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
       
    Cpu(){
        super();
        assets=new Assets();
        resources= new int[]{0,0,0,0,0}; 
        victoryPoints=0;
        int prio=(int)(Math.random()*(7-0+1)+0);
        setPriority(prio);
        
    }

    Cpu(String name, Color playerColor) {
        super(name,playerColor);
        assets=new Assets();
            nickname=name;
            this.playerColor=playerColor;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int prio=(int)(Math.random()*(7-0+1)+0);
        setPriority(prio);
    }

    Cpu(String name, int[] resources, Color playerColor) {
        super(name,resources,playerColor);
        this.nickname=name;
        this.resources=resources;
        this.victoryPoints=4;
        assets=new Assets();
        this.playerColor=playerColor;        
        int prio=(int)(Math.random()*(7-0+1)+0);
        setPriority(prio);
    }
    public synchronized void play()
    {
         /*resource numbers:
            0 = steel = ore
            1 = glass = brick
            2 = hemp = sheep
            3 = soy = wheat
            4 = plastic = lumber
            */
        int steel=resources[0],glass=resources[1],hemp=resources[2],soy=resources[3],plastic=resources[4];

        if(priority==1)
        {           
            if((steel==4) && (glass==4) && (soy==4) && (plastic==4))
            {
                buildSettlement(board);
            }
            else
            {
                int action=(int)(Math.random()*(8-0+1)+0);
                if(action==1)
                {
                    //build road, if not enough resources incriment action +1 so the next if can be executed
                }
                if(action==2)
                {
                    //trade, if not enough resources incriment action +1 so the next if can be executed
                }
                if(action==3)
                {
                    //upgrade settlement to city, if not enough resources incriment action +1 so the next if can be executed
                }
                if(action==4)
                {
                    //dev card
                }
                if(action==5)
                {
                    //progress card
                }
                if(action==6)
                {
                    //
                }                
            }
        }
        else if(priority==2)
        {
        }
        else if(priority==3)
        {
        }
        else if(priority==4)
        {
        }
        else if(priority==5)
        {
        }
        else if(priority==6)
        {
        }
        else
        {
        }
    }
    
    public static void buildSettlement(HexBoard board)
    {
        ArrayList<HexVertex>listOfVertexAvailable= new ArrayList<>();
        //for each hex on the bord check each vertex to know if a player has a Settlement already build
        //if not we put the available vertex in a list of available vertex
        for(Hex  hex: board.hexList)
        {
            for(int i=0;i<6;i++)
            {
                if(hex.getVerticies().get(i).getAsset().getPlayer()!=null)
                {
                    listOfVertexAvailable.add(hex.getVerticies().get(i));
                }
            }
        }
        //generate a random number between 0 and the number of vertex available 
        //this index is where the AI will built the settlement
        int indexForBuildInVertex = (int)(Math.random()*(listOfVertexAvailable.size()-0+1)+0);
        
   }
}
