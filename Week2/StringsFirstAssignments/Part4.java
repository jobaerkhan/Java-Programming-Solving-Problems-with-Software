
/**
 * @author (Jobaer) 
 * @version (20 Aug 2019)
 */
import edu.duke.*;

public class Part4 {
    public void printUrls(String url) {
        URLResource myurl = new URLResource(url);
        for(String item : myurl.words()) {
            String itemLower = item.toLowerCase();
       	   int pos = itemLower.indexOf("youtube.com");
       	   if (pos != -1) {
           	int beg = item.lastIndexOf("\"",pos);
int end = item.indexOf("\"", pos+1);
System.out.println(item.substring(beg+1,end));
               }
        }
    }
    
    public void testUrl() {
        printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }
    
    public static void main() {
        Part4 url = new Part4();
        url.testUrl();
    }
}