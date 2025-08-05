package org.example.TextEditor;


import java.util.*;

public class Row {
    List<Character> characters;
    Integer rowNumber;
    public Row(Integer rowNumber) {
        this.rowNumber = rowNumber;
        characters = new ArrayList<>();
    }

    public void add(Integer pos, Character ch) {
        characters.add(pos, ch);
    }

    public Boolean delete(Integer pos) {
        if (pos >= characters.size() || pos < 0) return false;
        characters.remove((int) pos);
        return true;
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        for (Character ch : characters) {
            sb.append(ch.getCh());
        }
        return sb.toString();
    }

    public Character getCharacter(Integer pos) {
        if (pos < 0 || pos >= characters.size()) return null;
        return characters.get(pos);
    }
}
