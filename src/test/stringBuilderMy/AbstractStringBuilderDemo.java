package test.stringBuilderMy;


public class AbstractStringBuilderDemo {

    public static void main(String[] args) {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < 15; i++) {
            builder.append(1);
        }
        builder.append("16");
    }
}
