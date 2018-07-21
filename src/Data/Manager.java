package Data;

import Command.Status;
import Element.BoardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private Status status;
    List<BoardGame> boardGames= new ArrayList<BoardGame>();
    public Manager( ){
        status = Status.ACTIVE;
    }
    public void getCommand()
    {
        Scanner input = new Scanner(System.in);
        while(status==Status.ACTIVE){
            System.out.println("Insert command : \n add to add new Game, \n exit to Quit, \n show to show List of Games");
            String command = input.nextLine();
            String name;
            int numberOfPlayers;
            if(command.equals("add") || command.equals("Add")) {
                System.out.println("Insert name of board game");
                name = input.nextLine();
                System.out.println("Insert maximum players that can play the game at one time");
                numberOfPlayers = input.nextInt();
                boardGames.add(new BoardGame(name, numberOfPlayers));
                input.nextLine();
            }else if (command.equals("exit") || command.equals("Exit")) {
                status = Status.STOP;
            }else if(command.equals("show") || command.equals("Show")) {
                this.printGames();
            }
            else {
                System.out.println("Wrong Command");
            }
        }
        return;
    }
    public void printGames() {
        for (BoardGame element : this.boardGames)
            System.out.println(element.getName());
    }
}

