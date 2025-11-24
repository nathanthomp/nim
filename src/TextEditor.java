public class TextEditor {
    private final int ROWS = 20, COLUMNS = 60;
    private final char[][] buffer = new char[ROWS][COLUMNS];

    private State state;
    private int cursorRow = 0;
    private int cursorColumn = 0;

    public TextEditor() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                buffer[i][j] = ' ';
            }
        }
        this.state = new NormalState(this);
    }

    public char[][] getBuffer() {
        return this.buffer;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCursorRow() {
        return this.cursorRow;
    }

    public int getCursorColumn() {
        return this.cursorColumn;
    }

    public void handleInput(int input) {
        this.state.handleInput(input);
    }

    public void render() {
        this.state.render();
    }

    public void moveCursor(int dRow, int dCol) {
        cursorRow = Math.min(Math.max(0, cursorRow + dRow), ROWS - 1);
        cursorColumn = Math.min(Math.max(0, cursorColumn + dCol), COLUMNS - 1);
    }

    public void insertChar(char c) {
        buffer[cursorRow][cursorColumn] = c;
        moveCursor(0, 1);
    }
    
    public static interface State {
        void handleInput(int input);

        public void render();
    } 
}
