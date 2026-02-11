package input;

public class Input {
    public static Input getInput(int ch) {
        return new Input(ch);
    }

    private int value;

    private Input(int ch) {
        this.value = ch;
    }

    public int getValue() {
        return this.value;
    }

    /**
     * Key and KeyType
     * 
     * Enter, Backspace, Escape, Tab, Up, Down, Left, Right,
     */
}
