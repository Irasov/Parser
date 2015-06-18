package com.epam.irasov.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class AbstractComposite<E extends Component> implements Composite<E> {

    private List<E> elements;

    public AbstractComposite() {
        elements = new ArrayList<E>();
    }

    public void add(E e) {
        elements.add(e);
    }

    public E get(int index) {
        return elements.get(index);
    }

    public List<E> getPart() {
        return elements;
    }

    public String buildOriginalString() {
        StringBuilder sb = new StringBuilder();
        for (E e : getPart()) {
            sb.append(e.buildOriginalString());
        }
        return sb.toString();
    }
}
