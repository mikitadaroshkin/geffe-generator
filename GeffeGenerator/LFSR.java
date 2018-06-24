import java.util.HashMap;
import java.util.Map;


public class LFSR {
    private long polynomial;
    private int polynomialDegree;
    private long initialState;
    private long currentState;
    private StringBuffer outputSequence;

    public LFSR(Polynomial initPolynomial, long initialState) {
        this.polynomialDegree = initPolynomial.getDegree();
        this.polynomial = initPolynomial.getValue() ^ ((long)1 << polynomialDegree);
        setInitialState(initialState);
    }

    public LFSR(Polynomial initPolynomial) {
        this(initPolynomial, 1);
    }

    public int shift() {
        int out = (int) (currentState & 1);
        int tempBit = (Long.bitCount((currentState & polynomial))) & 1;

        currentState >>= 1;
        currentState ^= ((long)tempBit << (polynomialDegree - 1));

        outputSequence.append(out);

        return out;
    }

    public void setInitialState(long initialState) {
        this.initialState = initialState;
        this.currentState = this.initialState;
        refreshOutputSequence();
    }

    private void refreshOutputSequence() {
        this.outputSequence = new StringBuffer();
    }

    public String getOutputSequence() {
        return outputSequence.toString();
    }
}
