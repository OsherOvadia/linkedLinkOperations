public class Node {
    private int value;
    private Node next;
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
    // Getter למצביע next
    public Node getNext() {
        return next;
    }
    // Setter למצביע next
    public void setNext(Node next) {
        this.next = next;
    }
    // Getter לערך הצומת
    public int getValue() {
        return value;
    }
}
// מחלקת LinkedList מייצגת רשימה מקושרת
