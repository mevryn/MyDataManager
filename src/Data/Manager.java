package Data;

import Command.Command;
import Command.Status;
import Element.BoardGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Command.Add;
import Element.Genre;

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
                System.out.println("Bye bye");
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
    public void addElement() {
        String name;
        Scanner input = new Scanner(System.in);
        int numberOfPlayers;
        System.out.println("Insert name of board game");
            try {
                name = input.nextLine();
                System.out.println("Insert maximum players that can play the game at one time");
                numberOfPlayers = input.nextInt();
                System.out.println("Instert game type, 'board' for Board games and 'card' for Card games");
                input.nextLine();
                String genreOfGame = input.nextLine();
                this.boardGames.add(new BoardGame(name, numberOfPlayers, Genre.UNKNOWN.returnType(genreOfGame)));
            } catch (InputMismatchException e) {
                System.out.println("Wrong argument, try again");
            }
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
           output.append(element.getGenre().returnString(element.getGenre()));
           output.append(':');
           output.append(element.getNumberOfPlayers());
           output.append('\n');
        }
        System.out.println(output.toString());
    }
}

