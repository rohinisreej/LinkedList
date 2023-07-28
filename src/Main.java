import java.util.Scanner;

class Node
{
    int value;
    Node next;
    public Node(int value)
    {
        this.value=value;
    }
}
class linkedList {
    static Node head;
    static Node tail;
    static int length;
    linkedList(int value)
    {
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;

    }
    public static void print()
    {
        Node temp=head;
        while (temp!=null)
        {
            System.out.println("values "+temp.value);
            temp=temp.next;
        }
    }
    public static void getHead()
    {
        System.out.println("Head Value: "+head.value);
    }
    public static void getTail()
    {
        System.out.println("Tail values: "+tail.value);
    }
    public static void getLength()
    {
        System.out.println("length "+length);
    }
    public static void append(int value)
    {
        Node newnode=new Node(value);
        if(length==0)
        {
            head=newnode;
            tail=newnode;
        }
        else {
            tail.next=newnode;
            tail=newnode;

        }
        length++;
    }
    public static Node removeFromLast()
    {
        if(length==0)
        {
            return null;

        }
        Node temp=head;
        Node prev=head;
        while(temp.next!=null)
        {
            prev=temp;
            temp=temp.next;
        }
        tail =prev;
        tail.next=null;
        length--;
        if(length==0)
        {
            head=null;
            tail=null;
        }
        return temp;
    }
    public static void prepand(int value)
    {
        Node newnode=new  Node(value);
        if(length==0)
        {
            head=newnode;
            tail=newnode;
        }
        else{
            newnode.next=head;
            head=newnode;
        }
        length++;
    }
    public static Node removeFromFirst()
    {
        if(length==0)
        {
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0)
        {
            tail=null;
        }
        return temp;
    }
    public static Node get(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }
    public static boolean set(int index,int value)
    {
        Node temp=get(index);
        if(temp!=null)
        {
            temp.value=value;
            return true;
        }
        return false;
    }
    public static boolean index(int index,int value)
    {
        if(index<0 || index>length)
        {
            return false;
        }
        if(index==0)
        {
            prepand(value);
            return true;
        }
        if(length==length)
        {
            append(value);
            return true;
        }
        Node newnode=new Node(value);
        Node temp=get(index-1);
        newnode.next=temp.next;
        temp.next=newnode;
        length++;
        return true;
    }
    public static Node remove(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }
        if(index==0)
        {
            return removeFromFirst();
        }
        if(index==length-1)
        {
            return removeFromLast();
        }
        Node prev=get(index-1);
        Node temp=prev.next;
        prev.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }
    public static void reverse()
    {
        Node temp=head;
        head=tail;
        tail=temp;
        Node before =null;
        Node after =temp.next;
        for(int i=0;i<length;i++)
        {
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
    }


}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value(enter -1 to finish): ");
        int num = scanner.nextInt();
        linkedList ll=new linkedList(num);
        while (true)
        {
            num = scanner.nextInt();
            if(num==-1)
            {
                break;
            }
            ll.append(num);

        }
        int index;
        int value;
        System.out.println("1-Prepend\n" +
                "2-Remove from last\n" +
                "3-Remove from first\n" +
                "4-Get Node\n" +
                "5-Update Node\n" +
                "6-Insert at an index\n" +
                "7-Remove at an index\n" +
                "8-print\n" +
                "9-Length\n" +
                "0-Exit");
        int input = scanner.nextInt();
        while(input!=0){
            switch(input) {
                case 1:
                    System.out.println("Enter a value Prepend:");
                    value = scanner.nextInt();
                    ll.prepand(value);
                    System.out.println("Prepend is done");
                    break;
                case 2:
                    System.out.println(ll.removeFromLast().value);
                    System.out.println("Remove From Last is done is done");
                    break;
                case 3:
                    System.out.println(ll.removeFromFirst().value);
                    System.out.println("Remove From First is done is done");
                    break;
                case 4:
                    System.out.println("Enter an index : ");
                    index = scanner.nextInt();
                    System.out.println(ll.get(index).value);
                    System.out.println("Get is done");
                    break;
                case 5:
                    System.out.println("Enter an index:");
                    index = scanner.nextInt();
                    System.out.println("Enter value :");
                    value = scanner.nextInt();
                    ll.set(index,value);
                    System.out.println("Set is done");
                    break;
                case 6:
                    System.out.println("Enter an index and element to insert an index");
                    index = scanner.nextInt();
                    System.out.println("Enter value :");
                    value = scanner.nextInt();
                    ll.index(index,value);
                    System.out.println("Index the element  is done");
                    break;
                case 7:
                    System.out.println("Enter an index to remove at an index");
                    index = scanner.nextInt();
                    ll.remove(index);
                    System.out.println("remove at index is done");
                    break;
                case 8:
                    System.out.println("node in doubleLinked :");
                    ll.print();
                    break;
                case 9:
                    System.out.println("The length of the double linked list:"+ll.length);
                    break;

                default:
                    System.out.println("Invalid input.");
            }
            System.out.println("1-Prepend\n" +
                    "2-Remove from last\n" +
                    "3-Remove from first\n" +
                    "4-Get Node\n" +
                    "5-Update Node\n" +
                    "6-Insert at an index\n" +
                    "7-Remove at an index\n" +
                    "8-print\n" +
                    "9-Length\n" +
                    "0-Exit");
            input = scanner.nextInt();
        }






    }
}