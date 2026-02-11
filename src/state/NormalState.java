package state;

import cursor.CursorDirection;
import main.TextEditor;

public class NormalState extends State {
    public NormalState(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void handleInput(int input) {
        if (input == 'i') {
            super.textEditor.setState(new InsertState(super.textEditor));
        } else if (input == ':') {
            super.textEditor.setState(new CommandState(super.textEditor));
        } else if (input == 'k') {
            this.textEditor.getCursor().move(CursorDirection.UP);
        } else if (input == 'j') {
            this.textEditor.getCursor().move(CursorDirection.DOWN);
        } else if (input == 'h') {
            this.textEditor.getCursor().move(CursorDirection.LEFT);
        } else if (input == 'l') {
            this.textEditor.getCursor().move(CursorDirection.RIGHT);
        }
    }

    @Override
    public String getName() {
        return "NORMAL";
    }
}
