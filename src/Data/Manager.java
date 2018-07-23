package Data;

import Command.Command;
import Command.Status;
import Element.BoardGame;

import java.io.*;
import java.util.*;

import Command.Add;
import Element.Genre;
import Command.WriteToFile;
import Command.Delete;

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
            System.out.println("Insert command : \n'add' to add new Game,\n'write' to show options of writing\n'delete' to delete element from list\n'exit' to Quit, ");
            String command = input.nextLine().toLowerCase();
            int numberOfPlayers;
            switch (command){
                case "add":
                    Command add = new Add(this);
                    add.execute();
                    break;
                case "delete":
                    consoleDelete();
                    break;
                case "exit":
                    System.out.println("Bye bye");
                    status = Status.STOP;
                    break;
                case "write":
                    this.writeInto();
                    break;
                default:
                    this.wrongCommandHandle();      //If provided command is not correct
                    break;
            }
        }
        return;
    }

    public void consoleDelete(){
        Delete delete = new Delete(this);
        Scanner input = new Scanner(System.in);
        System.out.println("Type name of game you want to delete");
        printGamesToConsole();
        String nameOfGame = input.nextLine();
        delete.execute(findBoardGameByName(nameOfGame));
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
                System.out.println("Instert game type, 'Board game' for Board games and 'Card game' for Card games");
                input.nextLine();
                String genreOfGame = input.nextLine();
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
    public BoardGame findBoardGameByName(String name) {
        for (BoardGame boardGame : boardGames) {
            if (boardGame.getName().equals(name)) {
                return boardGame;
            }
        }
        return null;
    }
    public void delete(BoardGame boardGameToDelete){
        Iterator<BoardGame> iter = boardGames.iterator();
        while(iter.hasNext()){
            BoardGame boardGame = iter.next();
            if(boardGame.getName().equals(boardGameToDelete.getName())){
                iter.remove();
            }
        }

    }
    public void writeInto(){
        System.out.println("Where do you want to write your list of Games? \n 'console' for console \n 'file' into file");
        while (true){
            Scanner input = new Scanner(System.in);
            String command = input.nextLine().toLowerCase();
            switch(command){
                case "console":
                    this.printGamesToConsole();
                    return;
                case "file":
                    Command writeIntoFile = new WriteToFile(this);
                    writeIntoFile.execute();
                    this.writeIntoFile();
                    return;
                    default:
                        System.out.println("Provided wrong command");
            }
        }
    }

    public void writeIntoFile() {
        try {

            File yourFile = new File("C:/JavaFiles/MyBoardGameDataBase.txt");
            yourFile.createNewFile(); // if file already exists will do nothing
            FileOutputStream fileOut = new FileOutputStream(yourFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            try {
                out.writeObject(boardGames);
                out.close();
                fileOut.close();
                System.out.println("List of games are saved in C:/MyBoardGameDataBase.txt");
            }catch (NotSerializableException e){
                System.out.println("Objects of class are not serializable for some reason");
            }

        }
        catch(IOException e){
            e.printStackTrace();;
        }
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
    public void readFromFile(){
        try{
            FileInputStream fileIn = new FileInputStream("C:/JavaFiles/MyBoardGameDataBase.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            boardGames =(ArrayList<BoardGame>) in.readObject();
        }catch (IOException i)
        {
            i.printStackTrace();
        }catch (ClassNotFoundException c){
            System.out.println(c);
        }
    }
}

