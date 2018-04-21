package com.tzj.garvel.core.parser.api.ast.toml;

import java.util.List;

public class AuthorsAst extends ProjectMetadataAst {
    private List<Identifier> authors;

    public AuthorsAst(final List<Identifier> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "AuthorsAst{" +
                "authors=" + authors +
                '}';
    }

    public List<Identifier> getAuthors() {
        return authors;
    }
}
