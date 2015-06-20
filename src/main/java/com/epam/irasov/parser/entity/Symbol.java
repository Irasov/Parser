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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        if (type != symbol1.type) return false;
        return !(symbol != null ? !symbol.equals(symbol1.symbol) : symbol1.symbol != null);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }
}
