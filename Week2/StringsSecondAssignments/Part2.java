
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
     public int howMany(String stringa, String stringb){
        int cnt = 0;
        int startIndex = 0;
        while(true){
            int currIndex = stringb.indexOf(stringa, startIndex);
            if (currIndex == -1){
                break;
            }
            startIndex = currIndex + stringa.length();
            cnt++;
        }
        return cnt;
    }
    
    public void testHowMany(){
        String test1a = "GAA";
        String test1b = "ATGAACGAATTGAATC";
        System.out.println(howMany(test1a, test1b));
        String test2a = "AA";
        String test2b = "ATAAAA";
        System.out.println(howMany(test2a, test2b));
    }

     public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testHowMany();
    }
}
