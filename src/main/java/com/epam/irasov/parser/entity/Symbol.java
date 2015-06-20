package com.epam.irasov.parser.entity;

import java.util.List;

public class Symbol implements  SentencePart {

    private SentencePartType type;
    private String symbol;

    public Symbol(String symbol, SentencePartType type) {
        this.symbol = symbol;
        this.type = type;
    }

    public SentencePartType getType() {
        return this.type;
    }

    public String buildOriginalString() {
        return this.symbol;
    }

}
