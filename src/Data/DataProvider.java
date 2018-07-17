package Data;

import Element.BoardGame;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private List<BoardGame> boardGameList = new ArrayList<BoardGame>();
    private Manager manager;
    public void addToList(BoardGame game){
        boardGameList.add(game);
    }
    public String printList(){
        return "Test";
    }
    public DataProvider(Manager manager){
        this.manager = manager;
    }
}
