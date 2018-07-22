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
            System.out.println("Insert command : \n 'add' to add new Game, \n 'exit' to Quit, \n 'write' to show options of writing");
            String command = input.nextLine().toLowerCase();
            int numberOfPlayers;
            if(command.equals("add")) {
                Command add = new Add(this);
                add.execute();
            }else if (command.equals("exit")) {
                System.out.println("Bye bye");
                status = Status.STOP;
            }else if(command.equals("write")) {
                this.writeInto();
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
                System.out.println("Instert game type, 'BOARDGAME' for Board games and 'CARDGAME' for Card games");
                input.nextLine();
                String genreOfGame = input.nextLine().toUpperCase();
                this.boardGames.add(new BoardGame(name, numberOfPlayers,Genre.getByValue(genreOfGame)));
            } catch (InputMismatchException e) {
                System.out.println("Wrong argument, try again");
            } catch (IllegalArgumentException f){
                System.out.println("Wrong type of game");
            }
    }
    public  void wrongCommandHandle(){
        System.out.println("Wrong Command");
    }

    public void writeInto(){
        System.out.println("Where do you want to write your list of Games? \n 'console' for console");
        while (true){
            Scanner input = new Scanner(System.in);
            String command = input.nextLine().toLowerCase();
            switch(command){
                case "console":
                    this.printGamesToConsole();
                    return;
                case "html":
                    break;
                    default:
                        System.out.println("Provided wrong command");


            }
        }
    }
    public void writeIntoJSON(){

    }
    public void printGamesToConsole() {
        StringBuilder output = new StringBuilder();
        output.append("List of Games:\n");
        try {

            for (BoardGame element : this.boardGames) {
                output.append(element.getName()).append(':');
                output.append(element.getGenre().getName()).append(':').append(element.getNumberOfPlayers());
                output.append('\n');
            }
            System.out.println(output.toString());
        }catch (NullPointerException e){
            System.out.println("In some reason some value is null");
        }

    }
}

