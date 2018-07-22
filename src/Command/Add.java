package Command;
import Data.Manager;
import Element.BoardGame;

public class Add extends Command {
    private Manager manager;

    public Add(Manager manager){
        this.manager=manager;
    }
    @Override
    public void execute(){
        manager.addElement();
    }
}
