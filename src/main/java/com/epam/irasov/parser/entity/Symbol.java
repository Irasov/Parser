package com.epam.irasov.parser.entity;

import java.util.List;

public class Symbol implements Component, SentencePart {

    private SentencePartType type;
    private String symbol;

    public Symbol(String symbol, SentencePartType type){
        this.symbol = symbol;
        this.type = type;
    }

    public void add(Component component) {

    }

    public SentencePartType getType() {
        return this.type;
    }

    public Component get(int index) {
        return null;
    }

    public List<Component> getPart() {
        return null;
    }

    public String buildOriginalString() {
        return this.symbol;
    }

}
