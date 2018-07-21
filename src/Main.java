import Command.CommandProvider;
import Data.DataProvider;
import Data.Manager;
import Element.BoardGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<BoardGame> boardGames= new ArrayList<BoardGame>();
        Scanner input = new Scanner(System.in);
        String name;
        int numberOfPlayers;
        while(boardGames.size()<3) {
             name =  input.nextLine();
             numberOfPlayers = input.nextInt();
            boardGames.add(new BoardGame(name, numberOfPlayers));
        }
        for(BoardGame element:boardGames)
            System.out.println(element.getName());
    }
}
