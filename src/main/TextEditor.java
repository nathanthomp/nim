package main;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import cursor.Cursor;
import state.NormalState;
import state.State;

public class TextEditor {
    private final Terminal terminal;
    private final TextBuffer textBuffer;
    private final Cursor cursor;

    private State state;

    public TextEditor() throws IOException {
        /**
         * Dependency injection for Terminal
         */
        this.terminal = TerminalBuilder.builder().build();
        this.textBuffer = new TextBuffer();
        this.cursor = new Cursor(this);
        this.state = new NormalState(this);
    }

    public Terminal getTerminal() {
        return this.terminal;
    }

    public TextBuffer getTextBuffer() {
        return this.textBuffer;
    }

    public Cursor getCursor() {
        return this.cursor;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void run() throws IOException, InterruptedException {
        try {
            /**
             * Dependency injection for NonBlockingReader
             */
            NonBlockingReader reader = this.terminal.reader();
            this.state.render();
            while (true) {
                if (reader.ready()) {
                    /**
                     * Input input = Input.getInput(reader.read());
                     */
                    int ch = reader.read();
                    /**
                     * this.state.handleInput(input);
                     */
                    this.state.handleInput(ch);
                    this.state.render();
                    /**
                     * Refactor to exit properly with CommandState
                     */
                    if (ch == 'q') {
                        break;
                    }
                }
                Thread.sleep(20);
            }
        } finally {
            this.terminal.flush();
            this.terminal.close();
        }
        /**
         * Catch InterruptException
         */
    }

    public int getStartingColumn() {
        return Integer.toString(this.textBuffer.getLineCount()).length() + 1;
    }

    public int getEndingColumn() {
        return this.terminal.getWidth();
    }

    public int getStartingRow() {
        return 0;
    }

    public int getEndingRow() {
        return this.terminal.getHeight() - 1;
    }
}
