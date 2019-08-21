
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import edu.duke.FileResource;

import edu.duke.StorageResource;
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
    
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        dna = dna.toUpperCase();
        
        while (true){
            String gene = findGene(dna);
            if (gene.isEmpty()){
                break;
            }
            else{
                geneList.add(gene);
                dna = dna.substring(startIndex + gene.length());
            }
        }
        
        return geneList;
    }
    
    public float cgRatio(String dna){
        dna = dna.toUpperCase();
        float cgRatio = 0;
        int cgCnt = 0;
        
        for (int i = 0 ; i < dna.length() ; i++){
            if (dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                cgCnt = cgCnt + 1;
            }
        }
        
        cgRatio = (float) cgCnt / dna.length();
        
        return cgRatio;
    }
    
    public int countCTG(String dna){
        dna = dna.toUpperCase();
        int ctgCnt = 0;
        int start = 0;
        
        while (true){
            int startIndex = dna.indexOf("CTG", start);
            if (startIndex == -1){
                break;
            }
            ctgCnt = ctgCnt + 1;
            start = startIndex + 2;
        }
        
        return ctgCnt;
    }
    
    public void processGenes(StorageResource sr){
        System.out.println("print the total number of genes: " + sr.size());
        
        StorageResource longerThanNine = new StorageResource();
        StorageResource higherThanThreeFive = new StorageResource();
        int maxLength = 0;
        StorageResource longerThanSixty = new StorageResource();
        
        for (String item : sr.data()){
            if (item.length() > 9){
                longerThanNine.add(item);
            }
            if (cgRatio(item) > 0.35){
                higherThanThreeFive.add(item);
            }
            if (item.length() > maxLength){
                maxLength = item.length();
            }
            if (item.length() > 60){
                longerThanSixty.add(item);
            }
        }
        
        System.out.println("print all the Strings in sr that are longer than 9 characters: ");
        for (String item : longerThanNine.data()){
            System.out.println(item);
        }
        System.out.println("print the number of Strings in sr that are longer than 9 characters: " + longerThanNine.size());
        
        System.out.println("print the Strings in sr whose C-G-ratio is higher than 0.35: ");
        for (String item : higherThanThreeFive.data()){
            System.out.println(item);
        }
        System.out.println("print the number of strings in sr whose C-G-ratio is higher than 0.35: " + higherThanThreeFive.size());
        
        System.out.println("print the length of the longest gene in sr: " + maxLength);
        
        System.out.println("print all the Strings in sr that are longer than 9 characters: ");
        for (String item : longerThanSixty.data()){
            System.out.println(item);
        }
        System.out.println("print the number of Strings in sr that are longer than 60 characters: " + longerThanSixty.size());
    }
    
    public void testGetAllGenes(){
        String dna1 = "atgxxxyyyzzzxxxtaawwwwwwwwwatgxxxyyytga";
        StorageResource geneList = getAllGenes(dna1);
        for (String item : geneList.data()){
            System.out.println(item); //answer should be atgxxxyyyzzzxxxtaa, atgxxxyyytga
        }
    }
    
    public void testCountCTG(){
        String dna1 = "ctgxxxyyyzzzctgxxxyyyzzzctxxxcxxxctg";
        System.out.println(countCTG(dna1)); //answer should be 3
    }
    
    public void testProcessGenes(){
        String dna1 = "atgxxxyyyzzztaaxxxatgxxxtaaxxxatgxxxyyyzzztaa";
        String dna2 = "atgxxxtaaxxxatgxxxtaaxxxatgtaa";
        String dna3 = "atgcgxcgxcgxcgxtaaxxxatgcgxcgxcgxtaa";
        String dna4 = "atgcgxtaaxxxatgxxxyyyzzztaa";
        String dna5 = "atgxxxyyyzzztaa";
        
        StorageResource geneList1 = getAllGenes(dna1);
        StorageResource geneList2 = getAllGenes(dna2);
        StorageResource geneList3 = getAllGenes(dna3);
        StorageResource geneList4 = getAllGenes(dna4);
        StorageResource geneList5 = getAllGenes(dna5);
        
        System.out.println("testing dna1...");
        processGenes(geneList1);
        System.out.println("testing dna2...");
        processGenes(geneList2);
        System.out.println("testing dna3...");
        processGenes(geneList3);
        System.out.println("testing dna4...");
        processGenes(geneList4);
        System.out.println("testing dna5...");
        processGenes(geneList5);
    }
    
    public void testRealDNA(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        
        StorageResource geneList = getAllGenes(dna);
        processGenes(geneList);
        
    }
    
    public static void main(String[] args) {
        Part1 pr = new Part1();
        pr.testRealDNA();
    }
        
}