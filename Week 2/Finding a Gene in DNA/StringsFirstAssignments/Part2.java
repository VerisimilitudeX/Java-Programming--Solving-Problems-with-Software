import java.util.*;

public class Part2 {
    public void testSimpleGene() {
        ArrayList<String> Isoleucine = new ArrayList<>(Arrays.asList("ATT", "ATC", "ATA"));
        ArrayList<String> Leucine = new ArrayList<>(Arrays.asList("CTT", "CTC", "CTA", "CTG", "TTA", "TTG"));
        ArrayList<String> Valine = new ArrayList<>(Arrays.asList("GTT", "GTC", "GTA", "GTG"));
        ArrayList<String> Phenylalanine = new ArrayList<>(Arrays.asList("TTT", "TTC"));
        ArrayList<String> Methionine = new ArrayList<>(Arrays.asList("ATG"));
        ArrayList<String> Cysteine = new ArrayList<>(Arrays.asList("TGT", "TGC"));
        ArrayList<String> Alanine = new ArrayList<>(Arrays.asList("GCT", "GCC", "GCA", "GCG"));
        ArrayList<String> Glycine = new ArrayList<>(Arrays.asList("GGT", "GGC", "GGA", "GGG"));
        ArrayList<String> Proline = new ArrayList<>(Arrays.asList("CCT", "CCC", "CCA", "CCG"));
        ArrayList<String> Threonine = new ArrayList<>(Arrays.asList("ACT", "ACC", "ACA", "ACG"));
        ArrayList<String> Serine = new ArrayList<>(Arrays.asList("TCT", "TCC", "TCA", "TCG", "AGT", "AGC"));
        ArrayList<String> Tyrosine = new ArrayList<>(Arrays.asList("TAT", "TAC"));
        ArrayList<String> Tryptophan = new ArrayList<>(Arrays.asList("TGG"));
        ArrayList<String> Glutamine = new ArrayList<>(Arrays.asList("CAA", "CAG"));
        ArrayList<String> Asparagine = new ArrayList<>(Arrays.asList("AAT", "AAC"));
        ArrayList<String> Histidine = new ArrayList<>(Arrays.asList("CAT", "CAC"));
        ArrayList<String> GlutamicAcid = new ArrayList<>(Arrays.asList("GAA", "GAG"));
        ArrayList<String> AsparticAcid = new ArrayList<>(Arrays.asList("GAT", "GAC"));
        ArrayList<String> Lysine = new ArrayList<>(Arrays.asList("AAA", "AAG"));
        ArrayList<String> Arginine = new ArrayList<>(Arrays.asList("CGT", "CGC", "CGA", "CGG", "AGA", "AGG"));

        ArrayList<String> Stop = new ArrayList<>(Arrays.asList("TAA", "TAG", "TGA"));

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the DNA sequence: ");
        String dna = userInput.nextLine().toLowerCase();
        if (dna == null || dna.length() == 0 || dna.indexOf("b") >= 0 || dna.indexOf("d") >= 0 || dna.indexOf("e") >= 0 || dna.indexOf("f") >= 0 || dna.indexOf("h") >= 0 || dna.indexOf("i") >= 0 || dna.indexOf("j") >= 0 || dna.indexOf("k") >= 0 || dna.indexOf("l") >= 0 || dna.indexOf("m") >= 0 || dna.indexOf("n") >= 0 || dna.indexOf("o") >= 0 || dna.indexOf("p") >= 0 || dna.indexOf("q") >= 0 || dna.indexOf("r") >= 0 || dna.indexOf("s") >= 0 || dna.indexOf("v") >= 0 || dna.indexOf("w") >= 0 || dna.indexOf("x") >= 0 || dna.indexOf("y") >= 0 || dna.indexOf("z") >= 0 || dna.indexOf(1) >= 0 || dna.indexOf(2) >= 0 || dna.indexOf(3) >= 0 || dna.indexOf(4) >= 0 || dna.indexOf(5) >= 0 || dna.indexOf(6) >= 0 || dna.indexOf(7) >= 0 || dna.indexOf(8) >= 0 || dna.indexOf(9) >= 0 || dna.indexOf(0) >= 0 || dna.indexOf(" ") >= 0 || dna.indexOf(",") >= 0 || dna.indexOf(".") >= 0 || dna.indexOf(";") >= 0 || dna.indexOf("'") >= 0 || dna.indexOf("\"") >= 0 || dna.indexOf("!") >= 0 || dna.indexOf("?") >= 0 || dna.indexOf("/") >= 0 || dna.indexOf("\\") >= 0 || dna.indexOf("(") >= 0 || dna.indexOf(")") >= 0 || dna.indexOf("[") >= 0 || dna.indexOf("]") >= 0 || dna.indexOf("{") >= 0 || dna.indexOf("}") >= 0 || dna.indexOf("<") >= 0 || dna.indexOf(">") >= 0 || dna.indexOf("=") >= 0 || dna.indexOf("+") >= 0 || dna.indexOf("-") >= 0 || dna.indexOf("*") >= 0 || dna.indexOf("&") >= 0 || dna.indexOf("^") >= 0 || dna.indexOf("%") >= 0 || dna.indexOf("$") >= 0 || dna.indexOf("#") >= 0 || dna.indexOf("@") >= 0 || dna.indexOf("!") >= 0 || dna.indexOf("~") >= 0 || dna.indexOf("`") >= 0 || dna.indexOf("|") >= 0 || dna.indexOf(".") >= 0 || dna.indexOf(";") >= 0 || dna.indexOf(":") >= 0 || dna.indexOf("'") >= 0 || dna.indexOf("\"") >= 0 || dna.indexOf("<") >= 0 || dna.indexOf(">") >= 0 || dna.indexOf("=") >= 0 || dna.indexOf("+") >= 0 || dna.indexOf("-") >= 0 || dna.indexOf("*") >= 0 || dna.indexOf("&") >= 0 || dna.indexOf("^") >= 0 || dna.indexOf("%") >= 0 || dna.indexOf("$") >= 0 || dna.indexOf("#") >= 0 || dna.indexOf("@") >= 0 || dna.indexOf("!") >= 0) {
            System.out.println("Error: Invalid characters are present in DNA sequence.");
            userInput.close();
            return;
        }
        System.out.println("Enter the amino acid: ");
        String aminoAcid = userInput.nextLine().toLowerCase();
        userInput.close();
        new findGeneWithAminoAcid(dna, aminoAcid, Isoleucine, Leucine, Valine, Phenylalanine, Methionine, Cysteine, Alanine, Glycine, Proline, Threonine, Serine, Tyrosine, Tryptophan, Glutamine, Asparagine, Histidine, GlutamicAcid, AsparticAcid, Lysine, Arginine, Stop);
    }
public static void main(String[] args) {
        Part2 p = new Part2();
        p.testSimpleGene();
    }
}

/*
 * Data sources:
 * https://pubmed.ncbi.nlm.nih.gov/12804578/
 * https://en.wikipedia.org/wiki/DNA_and_RNA_codon_tables
 * http://algoart.com/aatable.htm
 */