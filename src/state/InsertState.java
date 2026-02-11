package state;

import main.TextEditor;

public class InsertState extends State {
    public InsertState(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void handleInput(int input) {
        if (input == 27) {
            super.textEditor.setState(new NormalState(super.textEditor));
        } else if (input == 127) {
            // this.textEditor.getTextBuffer().deleteChar(this.textEditor.getCursor().getRow(),
            // this.textEditor.getCursor().getColumn() - 1);
            // this.textEditor.setColumn(this.textEditor.getCursor().getColumn() - 1);
        } else if (input >= 32 && input <= 126) {
            // this.textEditor.getTextBuffer().insertChar(this.textEditor.getCursor().getRow(),
            // this.textEditor.getCursor().getColumn(),
            // (char) input);
            // this.textEditor.setColumn(this.textEditor.getCursor().getColumn() + 1);
        }
    }

    @Override
    public String getName() {
        return "INSERT";
    }
}
