import Command.CommandProvider;
import Data.DataProvider;
import Data.Manager;

public class Main {
    public static void main(String[] args){
        Manager dataManager  =  new Manager(new CommandProvider(),new DataProvider());
    }
}
