package com.epam.irasov.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart {

    private List<Symbol> symbols;
    private SentencePartType type;

    public Word(SentencePartType type) {
        symbols = new ArrayList<Symbol>();
        this.type = type;
    }

    public SentencePartType getType() {
        return this.type;
    }

    public void addLetter(Symbol symbol) {
        this.symbols.add(symbol);
    }

    public Component get(int index) {
        return symbols.get(index);
    }

    public List<Symbol> getPart() {
        return symbols;
    }

    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol symbol : getPart()) {
            sb.append(symbol.buildOriginalString());
        }
        return sb.toString();
    }
}