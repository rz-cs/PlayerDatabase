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
public class Player 
{
    String Name; int Score, Shirt;
    
    public Player()
    {
        Name = "";
        Score = 0;
        Shirt = 0;
    }
    
    public Player(String newName, int newScore, int newShirt)
    {
        Name = newName;
        Score = newScore;
        Shirt = newShirt;
    }
    
    public Player(Player p)
    {
        Name = p.Name;
        Score = p.Score;
        Shirt = p.Shirt;
    }
    
    //accessors
    public String getName()
    {
        return Name;
    }
    
    public int getScore()
    {
        return Score;
    }
    
    public int getShirt()
    {
        return Shirt;
    }
    
    //mutators
    public void setPlayer(String newName, int newScore, int newShirt)
    {
        Name = newName;
        Score = newScore;
        Shirt = newShirt;
    }
    
    public void setScore(int Score)
    {
        this.Score = Score;
    }
    
    public void setName(String Name)
    {
        this.Name = Name;
    }
    
    //tostring
    public String toString()
    {
        return "Name: " + Name + " Score: " + Score + " Shirt: " + Shirt;
    }
}
