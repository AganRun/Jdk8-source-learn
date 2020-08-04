package test.string;

/**
 * final char[] value;
 */
public class Demo {

    public static void main(String[] args) {
        String str = "123";
        String str2 = new String(str);
        System.out.println(str2.isEmpty());
    }
}
