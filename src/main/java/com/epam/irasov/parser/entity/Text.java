package com.epam.irasov.parser.entity;

public class Text extends AbstractComposite<Paragraph>{
    public Text(){
        super();
    }

    @Override
    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph p : getElements()) {
            sb.append(p.buildOriginalString()).append("\n");
        }
        return sb.toString();
    }
}

