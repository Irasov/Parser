package com.epam.irasov.parser.entity;

public interface SentencePart extends Component{
    enum SentencePartType{WORD,LETTER, PUNCTUATION, SPACEORTAB};
    SentencePartType getType();
}
