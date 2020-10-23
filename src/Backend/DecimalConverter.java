package Backend;

public class DecimalConverter extends Converter {

    public DecimalConverter() {
        super(10);
    }

    @Override
    public int convertString(String numberString) {
        return Integer.parseInt(numberString, 10);
    }
}
