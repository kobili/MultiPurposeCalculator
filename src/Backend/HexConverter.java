package Backend;

public class HexConverter extends Converter {

    public HexConverter() {
        super(16);
    }

    @Override
    public int convertString(String numberString) {
        return Integer.parseInt(numberString, this.radix);
    }

    @Override
    // returns a conversion of number string from hex to decimal
    public String getResult1(String numberString) {
        return Integer.toString(convertString(numberString));
    }

    @Override
    // returns a conversion of numberString from hex to binary
    public String getResult2(String numberString) {
        return "0b" + Integer.toBinaryString(convertString(numberString));
    }
}
