package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * ArrayList gibi davranır ama duplicate kabul etmez.
 * String'ler A→Z, sayılar küçükten büyüğe sıralanır.
 */
public class WorkintechList<E extends Comparable<? super E>> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        if (this.contains(e)) return false;
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (this.contains(element)) return;
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (!this.contains(e)) {
                super.add(e);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean changed = false;
        int i = index;
        for (E e : c) {
            if (!this.contains(e)) {
                super.add(i++, e);
                changed = true;
            }
        }
        return changed;
    }

    // İstenen özel sort()
    public void sort() {
        Collections.sort(this);
    }

    // remove(Object) sonrası sıralama
    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if (removed) {
            Collections.sort(this);
        }
        return removed;
    }
}
