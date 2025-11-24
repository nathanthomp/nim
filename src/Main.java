import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TextEditor editor = new TextEditor();
        
        editor.render();


        while (true) {
            int input = System.in.read();
            if (input == -1) break;
            editor.handleInput(input);
        }
    }
}