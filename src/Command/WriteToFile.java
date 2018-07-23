package Command;

import Data.Manager;

public class WriteToFile implements Command {
    private Manager manager;
    public WriteToFile(Manager manager){
        this.manager=manager;
    }
    @Override
    public void execute(){
        manager.writeIntoFile();
    }
}
