package com.example;

import java.util.ArrayList;
import java.util.List;

public final class PlayerRepository {
    
    static List<Player> playerList = new ArrayList<>();
    
    public static void InsertPlayer(Player p){
        playerList.add(p);
    }

    public static List<Player> PlayerList(){
        return playerList;
    }

    public static List<Player> RemovePlayer(int index){
        if(index < playerList.size() && index >0){
            playerList.remove(index-1);
            int id = 1;
            for(Player player : PlayerList()){
                player.SetId(id);
                id++;
            }
        }
        else{
            System.out.println("Not able to remove player, please check whether the index number "+ index + " is valid or Check if Player is available!!");
        }
        return playerList;
    }
    
}
