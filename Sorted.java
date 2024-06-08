
import java.util.Scanner;



public class Sorted 
{
    static Scanner sc = new Scanner(System.in);
    public static LinkedList makeHeap()
    {
        LinkedList l = new LinkedList();
        System.out.println("heap created.");
        return l;
    }
    //time complexity O(n)
    public static void insert(Node item, LinkedList l) { 
        Node n = l.getHead(); // a pointer to the head
        if (n == null) {
            l.setHead(item);
            l.setTail(item);
            return;
        }
        if (item.getValue() < n.getValue()) {
            item.setNext(n);
            l.setHead(item);
            return;
        }
        while (n.getNext() != null && item.getValue() >= n.getNext().getValue()) {
            n = n.getNext();
        }
        item.setNext(n.getNext());
        n.setNext(item);
        if (item.getNext() == null) {
            l.setTail(item);
        }
    }
    public static int minimum (LinkedList l)
    {
        if(!l.isEmpty())
            return l.getHead().getValue();
        System.out.println("Error list is empty");
        return Integer.MAX_VALUE;
    }
    public static int extractMin(LinkedList l)
    {
        int lowest = Integer.MAX_VALUE;
        if(!l.isEmpty()){
            lowest = l.getHead().getValue();
            l.delete(lowest);
            l.print();
            System.out.println("the minimum was: " + lowest);
            return lowest;
        }
        System.out.println("Error list is empty");
        l.print();
        return Integer.MAX_VALUE;
    }
    
    public static void union(LinkedList l1, LinkedList l2) {
        Node p1 = l1.getHead(), p2 = l2.getHead();
        Node prev = null;
        
        while (p1 != null && p2 != null) {
            if (p1.getValue() <= p2.getValue()) {
                prev = p1;
                p1 = p1.getNext();
            } else {
                Node temp = p2.getNext();
                if (prev == null) {
                    p2.setNext(p1);
                    l1.setHead(p2);
                } else {
                    prev.setNext(p2);
                    p2.setNext(p1);
                }
                prev = p2;
                p2 = temp;
            }
        }  
        if (p1 == null) {
            if (prev == null) {
                l1.setHead(p2);
            } else {
                prev.setNext(p2);
            }
            l1.setTail(l2.getTail());
        } else {
            l1.setTail(l1.getTail());
        }
        l1.print();
    }
}