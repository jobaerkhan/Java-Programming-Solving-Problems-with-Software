
/**
 * Write a description of Part1 here.
 * 
 * @author (Jobaer) 
 * @version (21 Aug 2019)
 */
public class Part1 {
    public int findStopCodon (String dna, int startIndex, String stopCodon){
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
    
    public void testFindStopCodon(){
        String stopCodon = "TAA"; 
        String test1dna = "AGCTGATTAA";
        System.out.println(findStopCodon(test1dna, 0, stopCodon));
        String test2dna = "AGCTGATAA";
        System.out.println(findStopCodon(test2dna, 0, stopCodon));
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
    
    public void printAllGenes(String dna){
        String gene = "";
        int endIndex = 0;
        while(true){        
            gene = findGene(dna);
            if (gene.isEmpty()){            
                break;
            }
            else{
                System.out.println(gene);
                endIndex = dna.indexOf(gene) + gene.length();
                dna = dna.substring(endIndex);
            }
        }
    }
    
    public void testFindGene(){
        String testDna1 = "AGTGTATAAGCACTA";
        System.out.println(findGene(testDna1));
        String testDna2 = "AGAGATGCTAATTGTA";
        System.out.println(findGene(testDna2));
        String testDna3 = "AGAGATGCTAATTGTATAAGTT";
        System.out.println(findGene(testDna3));
        String testDna4 = "AGAGATGCTAATTGTATAACTGTGAGTCTAG";
        System.out.println(findGene(testDna4));
        String testDna5 = "AGAGATGCTAA";
        System.out.println(findGene(testDna5));
    }
    
     public static void main (String[] args) {
        Part1 gene = new Part1();
        gene.testFindGene();
    }
}