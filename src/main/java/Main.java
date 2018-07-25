import Data.FileDataProvider;
import Data.Manager;
import org.json.simple.JSONObject;


public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager(new FileDataProvider("~/Programowanie/MDM/MyFile"));
        manager.readFromFile();
        manager.getCommand();


    }
}
