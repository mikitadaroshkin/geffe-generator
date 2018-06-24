import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/result.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String outputSequence = br.readLine();

        Polynomial polynomial1 = new Polynomial(30, 6, 4, 1);
        Polynomial polynomial2 = new Polynomial(31, 3);
        Polynomial polynomial3 = new Polynomial(32, 7, 5, 3, 2, 1);

        LFSR lfsr1 = new LFSR(polynomial1);
        LFSR lfsr2 = new LFSR(polynomial2);
        LFSR lfsr3 = new LFSR(polynomial3);

        lfsr1.setInitialState(651497879);
        lfsr2.setInitialState(1259760270);
        lfsr3.setInitialState(2229332000L);

        GeffeGenerator geffe = new GeffeGenerator(lfsr1, lfsr2, lfsr3);

        geffe.step(outputSequence.length());

        System.out.println("LFSR1 result sequence:\n" + lfsr1.getOutputSequence());
        System.out.println("LFSR2 result sequence:\n" + lfsr2.getOutputSequence());
        System.out.println("LFSR3 result sequence:\n" + lfsr3.getOutputSequence());
        System.out.println("Geffe gamma sequences (calculated and expected)\n" + geffe.getGamma() + "\n" + outputSequence);
    }
}
