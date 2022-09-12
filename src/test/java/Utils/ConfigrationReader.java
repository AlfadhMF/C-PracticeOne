package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigrationReader {

    static Properties prop;

    public static Properties ReadProperties(String filePath){
        try{
            FileInputStream file = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}
