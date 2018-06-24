public class Polynomial {
    private long value;
    private int degree;

    Polynomial(int ... coefficients) {
        if (coefficients.length == 1) {
            this.value = coefficients[0];
        } else {
            this.value = 1;
            for (int i : coefficients) {
                this.value ^= ((long)1 << i);
            }
        }
        setDegreeOfValue();
    }

    public int getDegree(){
        return degree;
    }

    private void setDegreeOfValue() {
        this.degree = getDegreeOfLongValue(this.value);
    }

    public static int getDegreeOfLongValue(long val) {
        return 63 - Long.numberOfLeadingZeros(val);
    }

    public long getValue() {
        return value;
    }
}
