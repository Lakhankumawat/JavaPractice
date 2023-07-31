import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesImpl {
    
    public static void main(String[] args) {
          Properties p = new Properties();
        p.setProperty("name", "Sonoo Jaiswal");
        p.setProperty("email", "sonoojaiswal@javatpoint.com");

        try {
            p.storeToXML(new FileOutputStream("info.xml"), "Javatpoint Properties Example");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Properties p2 = new Properties();

        try {
            p2.loadFromXML(new FileInputStream("info.xml"));
            System.out.println(p2.getProperty("name"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
