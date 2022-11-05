
package genericlinkedlistqueuelabweek5;

public class GenericLinkedQueue<T> {
    
    private int size;
    private Node<T> first;
    private Node<T> last;
   

    public GenericLinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }
    
    // O(1)
    //Bu metota çalış!!
    // allahını kitabını sikeyim
    public void enqueue(int entry, int priority) {
        Node<T> newnNode = new Node(entry,priority);
            if(first == null) {
            first = newnNode;
            last = newnNode;
        }
            Node<T> temp = first;
            if(temp.priority < newnNode.priority) {
                newnNode.next = temp;
                first = newnNode;
            }else {
            while(temp.next != null) {
                if(newnNode.priority < temp.next.priority) {
                    newnNode.next = temp.next;
                    temp.next = newnNode;
                    
                }
            }
            }
            size++;
        
    }
    public Node<T> highestPriorityQueue() {
        if(isEmpty()) {
            throw  new IllegalArgumentException("There is no element in queue");
        }
        Node<T> temp = first.next;
        int maxPriority = first.priority;
        while(temp != null) {
            if(temp.priority > maxPriority) {
                maxPriority = temp.priority;
            }
            temp = temp.next;
        }
        return temp;
    }
    
    // O(1)
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack underflow");
        }
        Node<T> tmp = first;
        first = first.next;
        tmp.next = null;
        size--;
        return tmp.item;                // return the saved item
    }
    
    @Override
    public String toString() {

        String output = "";

        Node<T> temp = first;

        while (temp != null) {
            output = output + temp.item + " -> ";
            temp = temp.next;
        }
        
        return output;

    }   
    
}
