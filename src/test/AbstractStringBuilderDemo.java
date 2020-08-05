package test;


public class AbstractStringBuilderDemo {

    public static void main(String[] args) {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < 15; i++) {
            builder.append(i);
        }
        builder.append("16");
    }
}
