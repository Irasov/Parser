package com.epam.irasov.parser.entity;

public class Symbol implements  SentencePart {

    public static enum SymbolType{LETTER,PUNCTUATION,WHITESPACE}

    private SentencePartType type;
    private char symbol;
    private SymbolType symbolType;

    public Symbol(String symbol, SentencePartType type, SymbolType symbolType ) {
        this.symbol = symbol.charAt(0);
        this.type = type;
        this.symbolType = symbolType;
    }

    public SentencePartType getType() {
        return this.type;
    }

    public SymbolType getSymbolType(){return this.symbolType;}

    public String buildOriginalString() {
        return String.valueOf(this.symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        if (symbol != symbol1.symbol) return false;
        if (type != symbol1.type) return false;
        return symbolType == symbol1.symbolType;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (int) symbol;
        result = 31 * result + (symbolType != null ? symbolType.hashCode() : 0);
        return result;
    }
}
