package com.epam.irasov.parser.entity;

public class Symbol implements  SentencePart {

    public static enum SymbolType{LETTER,PUNCTUATION,WHITESPACE}

    private SentencePartType type;
    private String symbol;
    private SymbolType symbolType;

    public Symbol(String symbol, SentencePartType type, SymbolType symbolType ) {
        this.symbol = symbol;
        this.type = type;
        this.symbolType = symbolType;
    }

    public SentencePartType getType() {
        return this.type;
    }

    public SymbolType getSymbolType(){return this.symbolType;}

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
