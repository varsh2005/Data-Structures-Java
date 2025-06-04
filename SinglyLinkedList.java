public class LinkedList{
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList(){
        this.size = 0;
    }
    
    private class Node{
        private int value;
        private Node next;
        
        public Node(int value){
            this.value = value;
        }
        
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    
    //Insert at Beginning
    public void insertAtbeg(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        if(tail==null){
            tail = head;
        }
        size++;
    }
    
    //Insert at End
    public void insertAtEnd(int val){
        if(tail==null){
            insertAtbeg(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    
    //Insert at specific position
    public void insertAtSpecPos(int val,int index){
        if(index == 0){
            insertAtbeg(val);
            return;
        }
        if(index == size){
            insertAtEnd(val);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }
    
    //Delete at Beginning
    public int deleteAtBeg(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--; 
        return val;
    }
    
    //Get the node with value
    public Node find(int value){
        Node node = head;
        while(node!=null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    
    //Get the node with index
    public Node get(int index){
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }
    
    //Delete at End
    public int deleteAtEnd(){
        if (size<=1){
            return deleteAtBeg();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    
    //Delete at specific position
    public int deleteAtSpecPos(int index){
        if(index == 0){
            return deleteAtBeg();
        }
        if(index == size-1){
            return deleteAtEnd();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    
    //Display the LinkedList
    public void display(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insertAtbeg(3);
        list.insertAtbeg(2);
        list.insertAtbeg(8);
        list.insertAtbeg(7);
        list.insertAtEnd(11);
        list.insertAtSpecPos(5,3);
        System.out.println(list.deleteAtBeg());
        System.out.println(list.deleteAtEnd());
        System.out.println(list.deleteAtSpecPos(2));
        list.display();
    }
}
