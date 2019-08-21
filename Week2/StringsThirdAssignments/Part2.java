
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
     public double cgRatio(String dna){
        
        int count = 0;
        
        for( int i=0 ; i < dna.length() ; i++ ){
            
            if(dna.substring(i, i+1).equals("C") || dna.substring(i, i+1).equals("G")) count++;
                        
        }

        double result = (double)count/dna.length();
        
        return result;
    }
    
    public int countCTG(String dna){
    
        int count = 0;
        
        for( int i=0 ; i < dna.length()-2 ; i++ ){
            
            System.out.println("Processing...");
            System.out.println(i);

            if(dna.substring(i, i+3).equals("CTG")) count++;
            
        }
        
        return count;
    }

}
