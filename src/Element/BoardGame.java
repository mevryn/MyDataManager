package Element;

import java.io.Serializable;

public class BoardGame implements Serializable {
    private final String name;
    private final int numberOfPlayers;
    private final Genre genre;
    public final String getName()
    {
        return name;
    }
    public final Genre getGenre() {return genre;}
    public final int getNumberOfPlayers(){return numberOfPlayers;}
    public  BoardGame(String name, int numberOfPlayers, Genre genre){
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.genre = genre;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" : ");
        sb.append(this.getGenre().getName()).append(" : ").append(this.getNumberOfPlayers());
        return sb.toString();
    }
}
