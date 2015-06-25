package com.epam.irasov.parser.entity;

public class Paragraph extends AbstractComposite<Sentence>{
    public Paragraph(){
        super();
    }

    @Override
    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : getElements()) {
            sb.append(s.buildOriginalString()).append(" ");
        }
        return sb.toString();
    }
}
