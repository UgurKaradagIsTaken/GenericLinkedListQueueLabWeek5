package genericlinkedlistqueuelabweek5;

public class Node<T> {
    public T item;
    public Node<T> next;
    int priority;

    public Node(T item,int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }


}
