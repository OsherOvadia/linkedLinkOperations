class LinkedList {
    private Node head;
    private Node tail;
    public LinkedList() {
        this.head = null;
        this.tail=null;
    }
    public Node getHead()
    {
        return head;
    }
    public void setHead(Node n)
    {
        this.head = n;
    }
    public Node getTail()
    {
        return tail;
    }
    public void setTail(Node n)
    {
        this.tail = n;
    }   
    // מחיקת צומת לפי ערך
    public void delete(int value) {
        if (head == null) return;

        if (head.getValue() == value) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null && current.getNext().getValue() != value) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    // בדיקת אם הרשימה ריקה
    public boolean isEmpty() {
        return head == null;
    }
    // הדפסת ערכי הרשימה
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + "-->");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }
}
