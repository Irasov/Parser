package com.epam.irasov.parser.entity;

import java.util.List;

public interface Composite<E extends Component> extends Component {
    void add(E e);
    /*
    E remove(int index);
    E remove(E e);
    boolean contains(E e);
    boolean deepContains(E e);
    */
    E get(int index);
    List<E> getPart();
}
