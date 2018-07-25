import Data.Manager;
import org.json.simple.JSONObject;


public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.readFromFile();
        manager.getCommand();


    }
}
