package org.example.TextEditor;

import java.util.*;

public class Editor {
    Map<Integer, Row> map;
    CharacterFactory characterFactory;

    public void addCharacter(int row, int column, char ch,
            String fontName, int fontSize,
            boolean isBold, boolean isItalic) {
        if(!map.containsKey(row)) {
            map.put(row, new Row(row));
        }
        Row rowData = map.get(row);
        Character c = characterFactory.getCharacter(ch, fontName, fontSize, isBold, isItalic);
        rowData.add(column, c);
    }

    public String getStyle(int row, int column) {
        if(map.containsKey(row)) {
            Row rowData = map.get(row);
            if(rowData.getCharacter(column) != null) {
                return rowData.getCharacter(column).getStyle();
            }
        }
        return "";
    }

    public String readLine(int row) {
        if(map.containsKey(row)) {
            Row rowData = map.get(row);
            return rowData.readLine();
        }
        return "";
    }

    public Boolean deleteCharacter(int row, int column) {
        if(map.containsKey(row)) {
            Row rowData = map.get(row);
            if(rowData.delete(column)) {
                return true;
            }
        }
        return false;
    }

    public void init() {
        map = new HashMap<>();
        characterFactory = new CharacterFactory();
    }

}
