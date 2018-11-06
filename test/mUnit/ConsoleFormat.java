package mUnit;

import java.util.LinkedList;
import java.util.List;

public class ConsoleFormat {
    private final static String ESC = new String(new byte[]{0x1B});

    private static String formatEscapeSequence(int code){
        return String.format("%s[%dm ", ESC, code); //ESC[31m
    }

    public interface Code {
        int getCode();
    }

    public static String combine(Code ...codes){
        List<String> colors = new LinkedList<>();

        for(Code code : codes){
            Integer colorCode = code.getCode();
            colors.add(colorCode.toString());
        }

        return ESC + "[" + String.join(";", colors) + "m";
    }

    public enum TextFormat implements Code {
        BOLD(1),
        UNDERLINE(30);

        private String escapeSequence;
        private int code;

        TextFormat(int code){
            this.code = code;
            escapeSequence = formatEscapeSequence(code);
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return escapeSequence;
        }
    }


    public enum TextColor implements Code {
        RED(31),
        BLACK(30),
        GREEN(32),
        WHITE(37);

        private String escapeSequence;
        private int code;

        TextColor(int colorCode){
            code = colorCode;
            escapeSequence = formatEscapeSequence(colorCode);
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return escapeSequence;
        }
    }

    public enum BackgroundColor implements Code {
        RED(41),
        BLACK(40),
        GREEN(42);

        private String escapeSequence;
        private int code;

        BackgroundColor(int colorCode){
            code = colorCode;
            escapeSequence = formatEscapeSequence(colorCode);
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return escapeSequence;
        }
    }

}
