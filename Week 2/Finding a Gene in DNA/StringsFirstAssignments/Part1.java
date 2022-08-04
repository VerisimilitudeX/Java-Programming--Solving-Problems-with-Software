import java.util.*;

// Part 1: Finding a Gene - Using the Simplified Algorithm
class Part1 {

    /*
     * This method does the following:
     * Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
     * Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string. 
     * If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
     */
    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "Error: start codon (ATG) not found";
        }
        int stopIndex = dna.indexOf("TAA");
        if (stopIndex == -1) {
            return "Error: stop codon (TAA) not found";
        }
        if (((stopIndex - startIndex + 1) % 3) == 0) {
            return ("Gene is " + dna.substring(startIndex, stopIndex + 3));
        }
        else {
            return "Error: gene length is not a multiple of 3";
        }
    }

    /*
    * Write the void method testSimpleGene that has no parameters. You should create five DNA strings. The strings should have specific test cases, such as: DNA with no “ATG”, DNA with no “TAA”, DNA with no “ATG” or “TAA”, DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene), and DNA with ATG, TAA and the substring between them is not a multiple of 3. For each DNA string you should: 
    * Print the DNA string. 
    * See if there is a gene by calling findSimpleGene with this string as the parameter. If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.
    */
    public void testSimpleGene() {
        List<String> dnaList = new ArrayList<>();
        dnaList.add("ATGGCTATATATAATATATAGC");
        dnaList.add("ATGCATTAATTAATTAATAATGC");
        dnaList.add("GCGCATGCATGCATGCTAAGC");
        dnaList.add("GATGCCTAATGGCTAGCTATAAGCTGC");
        dnaList.add("GCATGCGCGCGCGCGCTAAGCGGC");
        dnaList.add("GCGCCGGCCATGGATCTAAGGCCGGCGC");
        dnaList.add("GCTACATGGTACGTACGTAATAGC");
        dnaList.add("GATGCTATATAATAGTTATATAGC");
        dnaList.add("GGCTATGATATATGATATAGC");
        for (String dna : dnaList) {
            System.out.println("DNA strand is: " + dna);
            System.out.println(findSimpleGene(dna) + "\n");
        }
    }
public static void main(String[] args) {
        Part1 p = new Part1();
        p.testSimpleGene();
    }
}