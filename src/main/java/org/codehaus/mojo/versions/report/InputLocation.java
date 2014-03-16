package org.codehaus.mojo.versions.report;

import org.apache.maven.model.InputSource;

public class InputLocation {
    private int line;
    private int column;
    private InputSource inputSource;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public InputSource getInputSource() {
        return inputSource;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
