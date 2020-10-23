package Backend;

public class HexConverter extends Converter {

    public HexConverter() {
        super(16);
    }

    @Override
    public int convertString(String numberString) {
        return Integer.parseInt(numberString, this.radix);
    }
}
