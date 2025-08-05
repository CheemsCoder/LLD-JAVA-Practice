package org.example.TextEditor;

public class Character {
    private char ch;
    private String fontName;
    private int fontSize;
    private boolean isBold;
    private boolean isItalic;

    public Character(char ch, String fontName, int fontSize, boolean isBold, boolean isItalic) {
        this.ch = ch;
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    public char getCh() {
        return ch;
    }

    public String getStyle() {
        String style = "";
        style += ch;
        style += "-" + fontName;
        style += "-" + fontSize;
        if(isBold) {
            style += "-b";
        }
        if(isItalic) {
            style += "-i";
        }
        return style;
    }
}
