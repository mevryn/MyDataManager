package Command;

import Data.Manager;
import Element.BoardGame;

public class Delete {
    private Manager manager;
    private BoardGame boardGameToDelete;

    public Delete(Manager manager) {
        this.manager = manager;
    }

    public void execute(BoardGame boardGameToDelete) {
        try {
            manager.delete(boardGameToDelete);
        }catch(NullPointerException n){
            System.out.println("Null enquantered proggrammer faults.");
        }
    }
}
