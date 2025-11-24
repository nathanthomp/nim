public class InsertState implements TextEditor.State {
    private TextEditor textEditor;

    public InsertState(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void handleInput(int input) {
        if (input == 27) { // ESC key
            this.textEditor.setState(new NormalState(this.textEditor));
        } else if (input >= 32 && input < 127) { // Printable chars
            this.textEditor.insertChar((char) input);
        } else if (input == 10 || input == 13) { // Enter
            this.textEditor.moveCursor(1, -this.textEditor.getCursorColumn());
        }
        this.render();
    }

    @Override
    public void render() {
        System.out.print("\033[H\033[2J"); 
        char[][] buf = this.textEditor.getBuffer();
        buf[this.textEditor.getCursorRow()][this.textEditor.getCursorColumn()] = 'X';
        for (char[] row : buf) {
            System.out.println(new String(row));
        }
        System.out.printf("\n-- INSERT -- Cursor: (%d,%d)\n", this.textEditor.getCursorRow() + 1, this.textEditor.getCursorColumn() + 1);
        System.out.printf("\033[%d;%dH", this.textEditor.getCursorRow() + 1, this.textEditor.getCursorColumn() + 1);
        System.out.flush();
    }
}
