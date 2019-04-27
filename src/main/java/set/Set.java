package set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;

public class Set<E> implements java.util.Set<E>, Iterable<E> {
    private HashMap<E, Boolean> internal;
    private Class type;

    Set(E[] initial) {
        if (initial.length == 0) throw new IllegalArgumentException();
        internal = new HashMap<>();
        for (E e : initial) {
            internal.put(e, true);
        }
        type = initial[0].getClass();
    }

    @Override
    public int size() {
        return internal.size();
    }

    @Override
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException();
        if (!type.isAssignableFrom(o.getClass())) throw new ClassCastException();
        return internal.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return internal.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return internal.keySet().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Object o) {
        if (!type.isAssignableFrom(o.getClass())) throw new ClassCastException();
        return internal.put((E) o, true) == null;
    }

    @Override
    public boolean remove(Object o) {
        if (!type.isAssignableFrom(o.getClass())) throw new ClassCastException();
        return internal.remove(o) != null;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        internal.clear();
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null) return false;
        int changed = 0;
        for (Object o : c) {
            if (this.remove(o)) changed++;
        }
        return changed > 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO: brute force
        HashMap<E, Boolean> m = new HashMap<>();
        c.forEach((v) -> m.put((E) v, internal.containsKey((E) v)));
        return !m.values().contains(false);
    }
}
