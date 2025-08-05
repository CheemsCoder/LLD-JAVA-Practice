package org.example.TextEditor;

public class Main {
    public static void main(String[] args) {
        Editor obj= new Editor();
        obj.init();
        obj.addCharacter(0, 0, 'g', "Cambria", 17, true, true);
        obj.addCharacter(1, 0, 'y', "Century Gothic", 14, true, true);
        obj.addCharacter(1, 1, 'h', "Courier New", 22, false, false);
        obj.addCharacter(1, 2, 'y', "Georgia", 14, false, false);

        System.out.println(obj.getStyle(0,0)); // returns 'g-Cambria-17-b-i'
        System.out.println(obj.readLine(0)); // returns 'g'
        obj.addCharacter(0, 0, 'q', "Arial", 21, false, true);
        System.out.println(obj.readLine(0)); // returns 'qg'

        System.out.println(obj.readLine(1)); // returns 'yhy'
        if(obj.deleteCharacter(1, 1)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println(obj.readLine(1)); // returns 'yy'
        if(obj.deleteCharacter(1, 4)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
