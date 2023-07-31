package String;
import java.util.StringTokenizer;

public class StringTokenizerImpl {
    
    public static void main(String[] args) {
        
        //---------------------Read from file---------------------//
        // try (FileInputStream fis = new FileInputStream("info.xml")) {
        //     byte [] b = new byte[100];
        //     fis.read(b);
        //     String s = new String(b);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        String data = "name=lakhan;address=delhi;phone=1234567890\n";

        StringTokenizer st = new StringTokenizer(data,"=;"); //in delim eac character is a separate delimeter = & ;
        // /n in data is by default a delimeter, space ' ' is also a delimeter
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
