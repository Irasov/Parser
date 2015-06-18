package com.epam.irasov.parser.entity;

public interface SentencePart extends Composite{
    enum SentencePartType{WORD,LETTER, PUNCTUATION, SPACEORTAB};
    public SentencePartType getType();
}
