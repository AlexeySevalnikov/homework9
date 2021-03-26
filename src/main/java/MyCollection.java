import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {
    private int size;
    private Object[] elementData = new Object[10];

    @Override
    public boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length + c.size());
        }
        for (E n : c) {
            elementData[size++] = n;
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(final Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (o.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        return Arrays.copyOf(elementData, size, result.getClass());
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean remove(final Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    int countCopyEl = size - i - 1;
                    if (countCopyEl > 0) {
                        System.arraycopy(elementData, i + 1, elementData, i, countCopyEl);
                    }
                    elementData[--size] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    int countCopyEl = size - i - 1;
                    if (countCopyEl > 0) {
                        System.arraycopy(elementData, i + 1, elementData, i, countCopyEl);
                    }
                    elementData[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        int count = c.size();
        int countElem = 0;
        for (Object n : c) {
            for (int i = 0; i < elementData.length; i++) {
                if (n.equals(elementData[i])) {
                    countElem++;
                }
            }
        }
        return count == countElem;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        boolean del = false;
        for (Object n : c) {
            for (int i = 0; i < size; i++) {
                if (n == null) {
                    remove(null);
                } else if (n.equals(elementData[i])) {
                    remove(elementData[i]);
                    del = true;
                }
            }
        }
        return del;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        MyCollection<Object> helpColl = new MyCollection<>();
        helpColl.addAll(Arrays.asList(elementData));
        helpColl.removeAll(c);
        return removeAll(helpColl);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    private class MyIterator<T> implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if (cursor == 0) {
                throw new IllegalStateException();
            }
            MyCollection.this.remove(elementData[cursor]);
            cursor = 0;
        }
    }
}