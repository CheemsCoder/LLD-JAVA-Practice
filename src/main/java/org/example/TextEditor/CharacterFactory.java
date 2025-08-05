package org.example.TextEditor;


import java.util.*;

public class CharacterFactory {
    private Map<String, Character> characterCache;
    public CharacterFactory() {
        characterCache = new HashMap<>();
    }
    public Character getCharacter(char ch,
            String fontName, int fontSize,
            boolean isBold, boolean isItalic) {
        String style = generateStyleKey(ch, fontName, fontSize, isBold, isItalic);
        Character character = characterCache.get(style);
        if (character == null) {
            character = new Character(ch, fontName, fontSize, isBold, isItalic);
            characterCache.put(style, character);
        }
        return character;
    }

    private String generateStyleKey(char ch, String fontName, int fontSize,
            boolean isBold, boolean isItalic) {
        return ch + "-" + fontName + "-" + fontSize + (isBold ? "-b" : "") + (isItalic ? "-i" : "");
    }
}
