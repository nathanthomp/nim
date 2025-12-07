package cursor;

import main.TextEditor;

public class Cursor {
    private final TextEditor textEditor;

    private int row;
    private int column;

    public Cursor(TextEditor textEditor) {
        this.textEditor = textEditor;
        this.row = this.textEditor.getStartingRow();
        this.column = this.textEditor.getStartingColumn();
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void move(CursorDirection direction) {
        switch (direction) {
            case UP:
                if (this.row > this.textEditor.getStartingRow()) {
                    this.row--;
                }
                break;
            case DOWN:
                if (this.row < this.textEditor.getTextBuffer().getLineCount()) {
                    this.row++;
                }
                break;
            case LEFT:
                if (this.column > this.textEditor.getStartingColumn()) {
                    this.column--;
                }
                break;
            case RIGHT:
                if (this.column < this.textEditor.getTextBuffer().getLineWidth(this.row)
                        + this.textEditor.getStartingColumn()) {
                    this.column++;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Cursor: (" + this.row + "," + this.column + ")";
    }
}
