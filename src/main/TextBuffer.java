package main;

import java.util.ArrayList;
import java.util.List;

public class TextBuffer {
    private final List<StringBuilder> lines;

    public TextBuffer() {
        lines = new ArrayList<>();
        lines.add(new StringBuilder("Hello, "));
        lines.add(new StringBuilder("World!"));
    }

    public int getLineCount() {
        return lines.size();
    }

    public String getLine(int index) {
        return lines.get(index).toString();
    }

    public int getLineWidth(int index) {
        return this.lines.get(index).length();
    }
}
