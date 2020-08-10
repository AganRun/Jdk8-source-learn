package test.byteMy;

import org.junit.Test;

public class ByteDemo {

    @Test
    public void testByte() {
        Byte byte1 = Byte.valueOf("12");
        Byte byte2 = Byte.valueOf("12");
        System.out.println(byte1 == byte2);
        Byte byte3 = new Byte("12");
        System.out.println(byte1 == byte3);
    }
}
