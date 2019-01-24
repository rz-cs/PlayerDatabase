/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerDatabase;

/**
 *
 * @author zheng
 */
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class PlayerDatabaseDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Player p1 = new Player("Sam",20,1);
        Player p2 = new Player(p1);
        p1.setName("john");
        System.out.println(p1.getName() == p2.getName());
        
        PlayerDatabase Sim = new PlayerDatabase();
        
        Sim.AddPlayer("Players.txt", 5);
        System.out.println(Sim.getnum());
        Sim.DisplayPlayers();
        Sim.SearchPlayersByName("Walter");
              
        int option = -1;
        //Boolean DataBase = false;
        
        PlayerDatabase players = new PlayerDatabase();
        
        
        System.out.println("MENU:");
        //System.out.println("1. Create a empty PlayerDataBase");
        //System.out.println("2. Create a PlayerDataBase of size n");
        System.out.println("1. Get num of Players from database");
        System.out.println("2. AddPlayer");
        System.out.println("3. AddPlayers thru a text file with each row of the format: name score shirt");
        System.out.println("4. Display all players in desending order");
        System.out.println("5. SearchPlayers by name");
        System.out.println("6. SearchPlayers by score");
        System.out.println("7. SearchPlayers by shirt");
        System.out.println("8  RemovePlayerByName");
        System.out.println("9. Close Database");
        
        Scanner keyboard = new Scanner(System.in);
        
        
        do 
        {
        System.out.println("Enter a number from the menu to do that action");
        
        try
        {
        option = keyboard.nextInt();
        keyboard.nextLine();
        }
        catch(NumberFormatException x)
        {
            System.out.println("Sorry this is not an option");
        }
        
        if(option>9 && option<1)
        {
            System.out.println("Sorry this is not an option");
        }
        switch(option)
        {
            case 1: System.out.println("Number of players: " + players.getnum());
                    break;
            case 2: players.AddPlayer();
                    break;
            case 3: try
                    {
                    System.out.println("Enter the name of the text file like name.txt: ");
                    String a = keyboard.nextLine();
                    System.out.println("Enter the number of player in the file ");
                    int b = keyboard.nextInt();
                    keyboard.nextLine();
                    players.AddPlayer(a,b);
                    }
                    catch(Exception x)
                    {
                        System.out.println("Invalid Input!");
                    }
                    
                    break;
            case 4: players.DisplayPlayers();
                    break;
            case 5: System.out.println("Enter the name of player ");
                    String c = keyboard.nextLine();
                    players.SearchPlayersByName(c);
                    break;
            case 6: System.out.println("Enter the score of player ");
                    int d = keyboard.nextInt();
                    System.out.println(Arrays.toString(players.SearchPlayersByScore(d)));
                    break;
            case 7: System.out.println("Enter the shirt of player ");
                    int e = keyboard.nextInt();
                    players.SearchPlayersByshirt(e);
                    break;  
            case 8: players.RemovePlayerByName();
                    break;
            case 9: System.out.println("Exited Database");
                    option = 0;
                    break;            
        }
        }
        while(option != -1);
        
    }
    
}
