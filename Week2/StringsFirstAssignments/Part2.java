
/**
 * 
 * @author (Jobaer) 
 * @version (20 Aug 2019)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = "";
        if( Character.isUpperCase(dna.charAt(0)) ) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int start = dna.indexOf(startCodon);
        if(start == -1) {
            return "";
        }
        int stop = dna.indexOf(stopCodon, start);
        if(stop == -1) {
            return "";
        }
        
        if((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
    public void testSimpleGene() {
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String a = "AAATGCCCTAACTAGATTAAGAAACC";
        String ap = "CCAATGCAGCGATAC";
        String apa = "CTAATCCGGATCCGA";
        String app = "ccagcatgccagtcagctaacag";
        String appa = "ccagcatgccagtagctaacag";
        
        System.out.println("The string is: " + a + ". The Gene is: " + findSimpleGene(a,startCodon,stopCodon  ));
        System.out.println("The string is: " + ap + ". The Gene is: " + findSimpleGene(ap,startCodon,stopCodon));
        System.out.println("The string is: " + apa + ". The Gene is: " + findSimpleGene(apa,startCodon,stopCodon));
        System.out.println("The string is: " + app + ". The Gene is: " + findSimpleGene(app,startCodon,stopCodon));
        System.out.println("The string is: " + appa + ". The Geasdfasdfne is: " + findSimpleGene(appa,startCodon,stopCodon));
    }
    public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testSimpleGene();
    }
}
