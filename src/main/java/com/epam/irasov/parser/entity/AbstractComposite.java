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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractComposite)) return false;

        AbstractComposite<?> that = (AbstractComposite<?>) o;
        return !(elements != null ? !elements.equals(that.elements) : that.elements != null);
    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }
}
