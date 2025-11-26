package state;

import org.jline.utils.InfoCmp.Capability;

import main.TextEditor;

public abstract class State {
    protected TextEditor textEditor;

    public State(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public abstract void handleInput(int input);

    public abstract String getName();

    public void render() {
        /**
         * Hide cursor
         */
        this.textEditor.getTerminal().writer().print("\033[?25l");

        /**
         * Clear screen
         */
        this.textEditor.getTerminal().puts(Capability.clear_screen);

        /**
         * Print top row
         */
        // this.textEditor.getTerminal().writer().print("\033[%1;1H");
        // this.textEditor.getTerminal().writer().print("This line is at the TOP");

        /**
         * Print text
         */
        for (int i = 0; i < textEditor.getTextBuffer().getLineCount(); i++) {
            // this.textEditor.getTerminal().writer().printf("\033[%d;1H", i + 1);
            // this.textEditor.getTerminal().writer().print(textEditor.getTextBuffer().getLine(i));

            String lineNumStr = String.format("%-" + this.textEditor.getStartingColumn() + "d ", i + 1);
            this.textEditor.getTerminal().writer().printf("\033[%d;1H", i + 1);
            this.textEditor.getTerminal().writer().print(lineNumStr);
            this.textEditor.getTerminal().writer().print(this.textEditor.getTextBuffer().getLine(i));
        }

        /**
         * Print bottom row
         */
        this.textEditor.getTerminal().writer().printf("\033[%d;1H", this.textEditor.getTerminal().getHeight());
        this.textEditor.getTerminal().writer().printf("-- %s -- %s", this.getName(),
                this.textEditor.getCursor().toString());

        /**
         * Draw cursor
         */
        this.textEditor.getTerminal().writer().printf("\033[%d;%dH", this.textEditor.getCursor().getRow(),
                this.textEditor.getCursor().getColumn());

        /**
         * Show cursor
         */
        this.textEditor.getTerminal().writer().print("\033[?25h");

        /**
         * Flush all at once
         */
        this.textEditor.getTerminal().flush();
    }
}
