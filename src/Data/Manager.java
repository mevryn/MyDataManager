package Data;

import Command.CommandProvider;
import Command.Status;
import Data.DataProvider;
import Element.BoardGame;

import java.util.Scanner;
import Command.Status;
public class Manager {
    private CommandProvider commandProvider;
    private DataProvider dataProvider;
    private Status status;
    public Manager(CommandProvider commandProvider,DataProvider dataProvider ){
        this.commandProvider = commandProvider;
        this.dataProvider = dataProvider;
    }
    public void getCommand()
    {
        Scanner input = new Scanner(System.in);
        while(status==Status.ACTIVE){
            System.out.println("Type 'add' to add new Boardgame");
            if (input.nextLine() =="add"){
                String name = input.nextLine();
                int numberOfPlayers = input.nextInt();
                BoardGame game = new BoardGame(name,numberOfPlayers);
                dataProvider.addToList(game);
            }
        }
    }
}
