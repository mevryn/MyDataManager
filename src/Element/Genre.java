package Element;

public enum Genre {
    CARDGAME,
    BOARDGAME,
    UNKNOWN;
    public String returnString (Genre genre){
        if (genre.equals(Genre.CARDGAME)){
            return "Card game";
        }else if (genre.equals(Genre.BOARDGAME)){
            return "Board game";
        } else{
            return "Type unknown";
        }
    }
    public Genre returnType (String type){
        if (type.equals("Card")||type.equals("card")){
            return Genre.CARDGAME;
        }else if (type.equals("Board") || type.equals("board"))
        {
            return Genre.BOARDGAME;
        }else {
            return Genre.UNKNOWN;
        }
    }
}
