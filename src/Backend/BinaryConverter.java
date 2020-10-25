package Backend;

public class BinaryConverter extends Converter {

    public BinaryConverter() {
        super(2);
    }

    @Override
    public int convertString(String numberString) {
        return Integer.parseInt(numberString, this.radix);
    }

    @Override
    // returns a conversion of number string from binary to decimal
    public String getResult1(String numberString) {
        return Integer.toString(convertString(numberString));
    }

    @Override
    // returns a conversion of numberString from binary to hex
    public String getResult2(String numberString) {
        return "0x" + Integer.toHexString(convertString(numberString));
    }
}

