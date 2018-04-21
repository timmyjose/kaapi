package com.tzj.garvel.core.parser.api.ast.toml;

public class NameAst extends TOMLAst {
    private Identifier name;

    public NameAst(final Identifier name) {

        this.name = name;
    }

    public Identifier getName() {
        return name;
    }
}
