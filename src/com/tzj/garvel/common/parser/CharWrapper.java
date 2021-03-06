package com.tzj.garvel.common.parser;

public class CharWrapper {
    private char c;
    private int line;
    private int column;

    public CharWrapper(final char c, final int line, final int column) {
        this.c = c;
        this.line = line;
        this.column = column;
    }

    public char c() {
        return c;
    }

    public int line() {
        return line;
    }

    public int column() {
        return column;
    }

    @Override
    public String toString() {
        return "{ " + c + ", " + line + ", " + column + " }";
    }
}
