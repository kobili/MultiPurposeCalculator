package Backend;

public abstract class Converter {
    protected int radix;

    public Converter(int radix) {
        this.radix = radix;
    }

    public abstract int convertString(String numberString);

}
