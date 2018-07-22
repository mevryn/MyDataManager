package Element;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Genre {
    CARDGAME("Card game"),
    BOARDGAME("Board game"),
    UNKNOWN("Bad declaration");
    private String name;
    private static final HashMap<String,Genre> reverseLookUp = new HashMap<String,Genre>();

    static{
        for(Genre genre: values()){
            reverseLookUp.put(genre.getName(),genre);
        }
    }

    Genre(String name){
        this.name=name;
    }
    public String getName(){return name;}

    public static Genre getByValue(String name){
        return reverseLookUp.get(name);
    }
}
