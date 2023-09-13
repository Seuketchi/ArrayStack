public class ArrayStack implements Stack {
    /**
     * Attributes
     *
     * @param array the 1D container of all elements
     * @param size the number of elements in the stack.
     **/
    private int currentSize = 0;
    private int[] array;

    public ArrayStack(int currentSize) {
        array = new int[currentSize];
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param e the element to be pushed onto the stack
     */
    public void push(int e) {
        ensureCapacity();
        array[currentSize] = e;
        currentSize++;
    }

    public void ensureCapacity() {
        int targetSize = currentSize + 1;
        if (targetSize > array.length) {
             int newSize = array.length + (array.length >> 1);
            if (newSize <= targetSize) newSize++;
            int[] newArray = new int[newSize];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     */
    public int pop() {
        if (size() == 0) {
            return -1;
        }
        currentSize--;
        return array[size()];

    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     */
    public int top() {
        return array[size() - 1];
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return currentSize;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() <= 0;
    }

    /**
     * Returns the string when you print the stack elements.
     *
     * @return the string starting from the bottom element to the top element.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < size(); i++) {
            sb.append(array[i]);
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

}
