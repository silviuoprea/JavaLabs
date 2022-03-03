import java.util.Arrays;

public class Neighbours<SIZE>
{
    private int size = 0;
    private Object elements[];

    public Neighbours()
    {
        elements = new Object[1];
    }

    public void add(SIZE e)
    {
        if (size == elements.length)
        {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    private void ensureCapacity()
    {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public SIZE get(int i)
    {
        if (i >= size || i < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (SIZE) elements[i];
    }
}

