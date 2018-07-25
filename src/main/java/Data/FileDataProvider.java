package Data;

import java.io.File;
import java.io.IOException;

public class FileDataProvider implements DataProvider {
    private File dataFile;
    public FileDataProvider(String pathToFile){
        dataFile = new File(pathToFile);

    }
    public FileDataProvider(File dataFile){
        this.dataFile=dataFile;
    }
    private boolean ifFileExists(File file){
        if(!file.exists()){
           return false;
        }else {
            return true;
        }
    }
}
