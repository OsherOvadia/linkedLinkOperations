import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
class MergeableHeap {
    
    public static LinkedList list = new LinkedList();
    public static LinkedList list2 = new LinkedList();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        int counter=0 ;
        System.out.println("Please enter the file path:");
        String path = sc.nextLine();
        try {
            File inputFile = new File(path);
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(counter==0)
                    string1.append(data);
                if(counter==1)
                    string2.append(data);
                counter++;
              }
              myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred. FILE NOT EXIST");
                System.exit(0);
                }
        System.out.println("How would you like the implementation to be carried out?\n(Enter 1): sorted linked list\n(Enter 2): unsorted Linked list");
        int choose = sc.nextInt();
        if(choose==1)
        {
            stringToListSorted(string1.toString(),list);
            stringToListSorted(string2.toString(),list2);
        }
        else if(choose == 2 ){
            stringToListUnsorted(string1.toString(),list);
            stringToListUnsorted(string2.toString(),list2);
        }
        else
            System.out.println("Not an option");
        getFunc(choose);       
    }
    public static void stringToListUnsorted(String s, LinkedList l)
    {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length()-1;i++)
        {
            while(s.charAt(i)!=' '&&i<s.length()-1 )
                {
                    str.append(s.charAt(i));
                    i++;
                }
            Node node1 = new Node(Integer.valueOf(str.toString()));
            Unsorted.insert(node1, l);
            str.setLength(0);
        }
        str.append(s.charAt(s.length()-1));
        Node node1 = new Node(Integer.valueOf(str.toString()));
        Unsorted.insert(node1, l);
        str.setLength(0);
        l.print();       
    }
    public static void stringToListSorted(String s, LinkedList l)
    {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length()-1;i++)
        {
            while(s.charAt(i)!=' '&&i<s.length()-1 )
                {
                    str.append(s.charAt(i));
                    i++;
                }
            Node node1 = new Node(Integer.valueOf(str.toString()));
            Sorted.insert(node1, l);
            str.setLength(0);
        }
        str.append(s.charAt(s.length()-1));
        Node node1 = new Node(Integer.valueOf(str.toString()));
        Sorted.insert(node1, l);
        str.setLength(0);
        l.print();       
    }
    public static void getFunc(int choose){
        int listChoose =0;
        System.out.println("what function would you like to call?\n(Enter 1):Make Heap. \n(Enter 2):Insert.\n(Enter 3):Minimum \n(Enter 4):ExtractMin\n(Enter 5):Union");
        int funcion = sc.nextInt();
        if(choose==1){
        switch (funcion) {
            case 1:
                Unsorted.makeHeap();
                break;
            case 2:
                System.out.println("what is the number that you want to insert?");
                int numToAdd = sc.nextInt();
                Node node = new Node(numToAdd);
                System.out.println("which list you want to add the item?");
                listChoose = sc.nextInt();
                System.out.println("list choose is:" + listChoose);
                if(listChoose ==1){
                    Sorted.insert(node, list);
                }
                else if(listChoose ==2){
                    Sorted.insert(node, list2);
                }
                else{
                    System.out.println("Invalide number");
                    getFunc(choose);
                    }
                list.print();
                list2.print();
                break;
            case 3:
                System.out.println("which list you want to get the minimum item?");
                listChoose = sc.nextInt();
                if(listChoose ==1)
                    System.out.println("The minimum in the first list:" +Sorted.minimum(list)); 
                else if(listChoose ==2)
                    System.out.println("The minimum in the second list:" + Sorted.minimum(list2));   
                
                else{
                    System.out.println("Invalide number");
                    getFunc(choose);
                }
                break;
            case 4:
                System.out.println("which list you want to extract the minimum item?");
                listChoose = sc.nextInt();
                if(listChoose ==1)
                    Sorted.extractMin(list);
                else if(listChoose ==2)
                    Sorted.extractMin(list2);
                else{
                    System.out.println("Invalide number");
                    getFunc(choose);
            }
                break;
            case 5:
                System.out.println("The united list in sorted way is:");
                Sorted.union(list, list2);
                break;
            default:
            {
                System.out.println("Wrong number");
                getFunc(choose);
            }
        }
    }
        else if(choose==2){
            switch (funcion) {
                case 1:
                    Sorted.makeHeap();
                    break;
                    case 2:
                    System.out.println("what is the number that you want to insert?");
                    int numToAdd = sc.nextInt();
                    Node node = new Node(numToAdd);
                    System.out.println("which list you want to add the item?");
                    listChoose = sc.nextInt();
                    if(listChoose ==1)
                        Unsorted.insert(node, list);
                    else if(listChoose ==2)
                        Unsorted.insert(node, list2);
                    else{
                        System.out.println("Invalide number");
                        getFunc(choose);
                    }
                    list.print();
                    list2.print();
                    break;
                case 3:
                    System.out.println("which list you want to get the minimum item?");
                    listChoose = sc.nextInt();
                    if(listChoose ==1)
                        Unsorted.minimum(list);
                    else if(listChoose ==2)
                        Unsorted.minimum(list2);
                    else{
                        System.out.println("Invalide number");
                        getFunc(choose);
                    }
                    break;
                case 4:
                    System.out.println("which list you want to extract the minimum item?");
                    listChoose = sc.nextInt();
                    if(listChoose ==1)
                        Unsorted.extractMin(list);
                    else if(listChoose ==2)
                        Unsorted.extractMin(list2);
                    else{
                        System.out.println("Invalide number");
                        getFunc(choose);
                }
                    break;
                case 5:
                    System.out.println("The united list is:");
                    Unsorted.union(list, list2);
                    break;
                default:
                    {
                        System.out.println("Wrong number");
                        getFunc(choose);
                    }
            }
                
        }
    
    }
}
    
    
     

