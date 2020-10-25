package Backend;

public class DecimalConverter extends Converter {

    public DecimalConverter() {
        super(10);
    }

    @Override
    public int convertString(String numberString) {
        return Integer.parseInt(numberString, 10);
    }

    @Override
    // returns a conversion of number string from decimal to binary
    public String getResult1(String numberString) {
        return "0b" + Integer.toBinaryString(convertString(numberString));
    }

    @Override
    // returns a conversion of numberString from decimal to hex
    public String getResult2(String numberString) {
        return "0x" + Integer.toHexString(convertString(numberString));
    }
}
