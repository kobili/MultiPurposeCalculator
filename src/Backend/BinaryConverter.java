package Backend;

public class BinaryConverter extends Converter {

    public BinaryConverter() {
        super(2);
    }

    @Override
    public int convertString(String numberString) {
        return Integer.parseInt(numberString, this.radix);
    }
}
