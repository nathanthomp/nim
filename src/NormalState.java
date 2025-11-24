public class NormalState implements TextEditor.State {
    private TextEditor textEditor;

    public NormalState(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void handleInput(int input) {
        switch (input) {
            case 'i':
                this.textEditor.setState(new InsertState(this.textEditor));
                break;
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
        System.out.printf("\n-- NORMAL -- Cursor: (%d,%d)\n", this.textEditor.getCursorRow() + 1, this.textEditor.getCursorColumn() + 1);
        System.out.printf("\033[%d;%dH", this.textEditor.getCursorRow() + 1, this.textEditor.getCursorColumn() + 1);
        System.out.flush();
    }
}
