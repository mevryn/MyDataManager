package Data;

import Command.Command;
import Command.Status;
import Element.BoardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Command.Add;
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

            int numberOfPlayers;
            if(command.equals("add") || command.equals("Add")) {
                Command add = new Add(this);
                add.execute();
            }else if (command.equals("exit") || command.equals("Exit")) {
                status = Status.STOP;
            }else if(command.equals("show") || command.equals("Show")) {
                this.printGames();
            }
            else {
                this.wrongCommandHandle(); //If provided command is not correct
            }
        }
        return;
    }
    public void addElement(){
        String name;
        Scanner input = new Scanner(System.in);
        int numberOfPlayers;
        System.out.println("Insert name of board game");
        name = input.nextLine();
        System.out.println("Insert maximum players that can play the game at one time");
        numberOfPlayers = input.nextInt();
        this.boardGames.add(new BoardGame(name,numberOfPlayers));
        input.nextLine();
    }
    public  void wrongCommandHandle(){
        System.out.println("Wrong Command");
    }
    public void printGames() {
        StringBuilder output = new StringBuilder();
        output.append("List of Games:\n");
        for (BoardGame element : this.boardGames)
        {
           output.append(element.getName());
           output.append(':');
           output.append(element.getNumberOfPlayers());
           output.append('\n');
        }
        System.out.println(output.toString());
    }
}

