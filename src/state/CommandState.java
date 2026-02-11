package state;

import main.TextEditor;

public class CommandState extends State {
    public CommandState(TextEditor textEditor) {
        super(textEditor);
    }

    @Override
    public void handleInput(int input) {
        /**
         * Commands to implement:
         * w - write/save file
         * q - quit
         */

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
    /**
     * Handle command state logic here
     */
}
