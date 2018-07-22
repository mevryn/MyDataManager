package Element;

public class BoardGame {
    private String name;
    private int numberOfPlayers;
    private Genre genre;
    public String getName()
    {
        return name;
    }
    public Genre getGenre() {return genre;}
    public int getNumberOfPlayers(){return numberOfPlayers;}
    public BoardGame(String name, int numberOfPlayers, Genre genre){
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.genre = genre;
    }
}
