import java.util.HashMap;

class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}

class LRUcache {
    static HashMap<Integer,Node> map;
    static Node head;
    static Node tail;
    int capacity;
    LRUcache(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    Node deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }
    void InsertBefore(Node node){
        Node temp=head.next;
        head.next=node;
        node.prev=head;
        node.next=temp;
        temp.prev=node;
    }
    void put(int key,int value){
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            InsertBefore(map.get(key));
            map.get(key).val=value;
            return;
        }
        else{
            Node node=new Node(key,value);
            map.put(key,node);
            InsertBefore(node);
            if(map.size()>capacity){
                int deleteKey=tail.prev.key;
                deleteNode(tail.prev);
                map.remove(deleteKey);
            }
        }
    }
    int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            Node curNode=map.get(key);
            int value=curNode.val;
            deleteNode(curNode);
            InsertBefore(curNode);
            return value;
        }
    }
    public static void main(String[] args) {
        LRUcache lru =new LRUcache(3);
        lru.put(1,100);
        lru.put(2,200);
        lru.put(3,300);
        System.out.println(lru.get(1));
        lru.put(4,400);
        System.out.println(lru.get(2));
        lru.put(5,500);
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
        System.out.println(lru.get(5));
        lru.put(6,600);
        System.out.println(lru.get(5));
        
    }
}

