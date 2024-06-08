import java.util.Scanner;
public class Unsorted
{
    public static int minObj = Integer.MAX_VALUE;
    static Scanner sc = new Scanner(System.in);
    
    public static LinkedList makeHeap()
    {
        LinkedList l = new LinkedList();
        System.out.println("heap created.");
        return l;
    }
    public static void insert(Node item, LinkedList l) 
    {
        if(l.size()==0)
            l.setTail(item);
        Node n = l.getHead(); // a pointer to the head
        l.setHead(item);
        item.setNext(n);   
    }
    public static int minimum(LinkedList l) 
    {
        int min = Integer.MAX_VALUE;
        Node n = l.getHead();
        while(n!=null)
        {
            min = Math.min(min,n.getValue());
            n=n.getNext();
        }
        System.out.println("the min item is: " + min);
        return min;

    }
    public static int extractMin(LinkedList l) 
    {
        int min = minimum(l);
        Node n = l.getHead();
        if(n.getValue()==min)
        {
            l.setHead(n.getNext());
            l.print();
            return min;
        }
        while(n.getNext()!=null&&n.getNext().getValue()!=min)
        { 
            n=n.getNext();
        }
        if(n.getNext().getNext()!=null)
            n.setNext(n.getNext().getNext());
        else
            n.setNext(null);
        l.print();
        return min;
    }
    public static void union(LinkedList l1, LinkedList l2) {
        l1.getTail().setNext(l2.getHead());
        l1.print();
    }
}
