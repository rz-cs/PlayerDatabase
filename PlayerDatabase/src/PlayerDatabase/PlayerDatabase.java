/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerDatabase;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author zheng
 */
public class PlayerDatabase 
{
    private 
        Player[] players;
        int numPlayers;
        
    public PlayerDatabase()
    {
        numPlayers = 0;
        players = new Player[10];
        //players[numPlayers-1] = new Player();
    }
    //public PlayerDatabase(int num)
    //{
        //numPlayers = 0; //need to update when add/remove players
        //players = new Player[10];
    //}
    public int getnum()
    {
        return numPlayers;
    }
    public void AddPlayer()
    {
        if(numPlayers == 10)
        {
            System.out.println("Sorry Database can only hold 10 players");
        }
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the new player name :");
        String a = keyboard.nextLine();
        System.out.println("Enter the new player score :");
        int c = keyboard.nextInt();
        System.out.println("Enter the new player shirt :");
        int b = keyboard.nextInt();
        
        numPlayers++;
        players[numPlayers] = new Player(a,b,c);
        System.out.println("Added Player " + players[numPlayers].toString());
    }
    
    public void AddPlayer(String PlayersFile, int num)
    {
        
        //String[] words = PlayersFile.split("\\s+");
        //for(int a = 0; a < words.length; a=a+3)
        //{
            //System.out.println(words[a]+words[a+1]+words[a+2]);
            //players[a] = new Player(words[a], Integer.parseInt(words[a+1]), Integer.parseInt(words[a+2]));
        //}        players = new Player[num];

        String[] f = new String[num*3];
        
        File file = new File("C:\\Users\\zheng\\OneDrive\\Desktop\\"+PlayersFile); 
        try
        {
            
            if(num<11)
            {
                numPlayers = num;
                int a = 0;
                players = new Player[numPlayers];
                Scanner sc = new Scanner(file);
                while (sc.hasNext())
                {
                    f[a] = sc.next();
                    a++;
                }
                a = 0;
                for(int b = 0; b < num; b++)
                {
                    players[b] = new Player(f[a],Integer.parseInt(f[a+1]),Integer.parseInt(f[a+2]));
                    a = a+3;
                }
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("file not found");
        }
        //for(int b = 0; b < num; b++)
        //{
            //System.out.println(players[b]);
        //}
        
    }
    
    //public void d()
    //{
        //String z = "";
        //for(int a = 0; a < numPlayers; a++)
        //{
            //System.out.println(players[a].toString());
        //}
        //return z;
    //}
    public void DisplayPlayers()
    {
        //System.out.println(numPlayers);
        //d();
        if(numPlayers > 1)
        {
            Player[] sortplayers = new Player[numPlayers];
            for(int d = 0; d < numPlayers; d++)
            {
                sortplayers[d] = new Player(players[d]);
            }
            for(int a = numPlayers ; a >= 1; a--)
            {
                for(int b = 0; b < a-1; b++)
                {
                    if(sortplayers[b].getScore() < sortplayers[b+1].getScore())
                    {
                        Player temp = new Player(sortplayers[b]);
                        sortplayers[b] = new Player(sortplayers[b+1]);
                        sortplayers[b+1] = new Player(temp);
                        //for(int c = 0; c < numPlayers; c++)
                        //{
                            //System.out.println(sortplayers[c]);   
                        //}
                    }
                }
            }
            for(int c = 0; c < numPlayers; c++)
            {
                System.out.println(sortplayers[c]);
            }
        }
        else
            System.out.println(players[1].toString());
    }
    
    public void SearchPlayersByName(String playerName)
    {
        boolean b = false;
        //Player[] names;
        //names = new Player[numPlayers];
        for(int a = 0; a < numPlayers; a++)
        {
            //System.out.println("k");
            if(players[a].getName().equals(playerName))
            {
                //System.out.println(players[a].toString());
                System.out.println("Displayig matching names:");
                System.out.println(players[a].toString());
                b = true;
                //System.out.println(a);
            }
           
        }
        if (b==false)
        {
            System.out.println("not found");
        }
        //return names;
    }
    
    public void SearchPlayersByshirt(int playerShirtNumber)
    {
        boolean b = false;
        for(int a = 0; a < numPlayers; a++)
        {
            if(players[a].Shirt == playerShirtNumber)
            {
                System.out.println("Displayig matching shirts:");
                System.out.println(players[a].toString());
                b = true;
            }
            
        }
        if (b == false)
            {
                System.out.println("not found");
            }
    }
    
    public Player[] SearchPlayersByScore(int playerScore)
    {
        boolean b = false;
        int c = 0;
        Player[] names; 
        for(int a = 0; a < numPlayers; a++)
        {
            if(players[a].Score == playerScore)
            {
                
                b = false;
                c++;
            }
            
        }
        names = new Player[c];
        c = 0;
        for(int a = 0; a < numPlayers; a++)
        {
            if(players[a].Score == playerScore)
            {
                names[c] = new Player(players[a]);
                c++;
            }
        }
        if (b==true)            
        {
            System.out.println("not found");
        }
        return names;
    }
    
    public void RemovePlayerByName()
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter the player name to be remove :");
        String c = keyboard.nextLine();
        
        Boolean b = false;
        for(int a = 0; a < numPlayers-1; a++)
        {
            if(players[a].Name.equals(c))
            {
                for(int d = a; d < numPlayers-2; d++)
                {
                    players[d] = new Player(players[d+1]);
                    
                }
                numPlayers--;
                b = true;
                
            }
            if(a == numPlayers-1 && players[a].Name.equals(c))
            {
                players[a] = new Player();
            }
        }
        if (b==false)
        {
            System.out.println("not found");
        }   
    }
}
