package main;

public class Main {
    public static void main(String[] args) {
        try {
            /**
             * TODO: Get text to edit
             */
            TextEditor textEditor = new TextEditor();
            textEditor.run();
        } catch (Exception e) {
            System.out.println("Could not run TextEditor.");
            e.printStackTrace();
        }
    }
}