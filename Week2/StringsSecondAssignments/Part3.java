
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 { public int findStopCodon (String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            if ((currIndex - startIndex)%3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);            
            }        
        }
        return dna.length();
    }
    
    public String findGene(String dna){
        String startCodon = "ATG";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return "";
        }
        
        int endIndexTAA = findStopCodon(dna, startIndex, "TAA");
        int endIndexTAG = findStopCodon(dna, startIndex, "TAG");
        int endIndexTGA = findStopCodon(dna, startIndex, "TGA");
        
        if ((endIndexTAA == dna.length()) && ((endIndexTAG == dna.length()) && (endIndexTGA == dna.length()))){
            return "";
        }
        else{
            int endIndex = Math.min(endIndexTAA, endIndexTAG);
            endIndex = Math.min(endIndex, endIndexTGA);
            
            return dna.substring(startIndex, endIndex + 3);
        }
    }
    
    public int countGenes(String dna){
        int cnt = 0;
        int endIndex = 0;
        while (true){
            String gene = findGene(dna);
            if (gene.isEmpty()){
                break;
            }
            else{
                cnt++;
                endIndex = dna.indexOf(gene) + gene.length();
                dna = dna.substring(endIndex);
            }
        }
        return cnt;
    }
    
    public void testCountGenes(){
        String testDna1 = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(testDna1));
        String testDna2 = "ATGxxxyyyzzzTAAxyATGTGA";
        System.out.println(countGenes(testDna2));
    }
    
      public static void main (String[] args) {
        Part3 gene = new Part3();
        gene.testCountGenes();
    }
}
