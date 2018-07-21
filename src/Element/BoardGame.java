package Element;

public class BoardGame implements Genre {
    private String name;
    private int numberOfPlayers;
    public String getName()
    {
        return name;
    }
    public BoardGame(String name, int numberOfPlayers){
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }
}
