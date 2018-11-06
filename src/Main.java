public class Main {
    public static void main(String[] argv){
        for(final String line : new String[]{"Hello", "There"}){
            System.out.println(new String(new byte[]{0x1B}) + "[42m Hello there");
        }
    }
}
