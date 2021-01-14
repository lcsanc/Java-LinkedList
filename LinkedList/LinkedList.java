//creation of a linked list

public class LinkedList
{
   Node head; //this is the head of the list. 
   // at this point its value is null
   
   public static class Node
   {
      int data;
      Node next;
      // also next is null. 
      
      // this is just a constructor to creating new nodes
      Node(int d)
      {
         data = d;
         next = null; 
      }  
   } 
   //how to traverse
   public void printList()
   {
      Node n = head;
      while(n!=null)
      {
         System.out.print(n.data + " ");
         n = n.next; 
      }
   }
   
   //insert a node to the front
   public void push(int new_data)
   {
      Node new_node = new Node(new_data);
      //System.out.println(new_node.data); //5 allocating the new node
      //System.out.println(head.data);     //1 head is still the same
      // 1 - 2 - 3    and new node 5
      new_node.next = head;
      //System.out.println(new_node.data); //connecting new_node to head
      //System.out.println(head.data);    //1 head is still the same
      // 5 - 1 -2 -3 
      head = new_node; 
      //System.out.println(new_node.data); //5
      //System.out.println(head.data);     //5 
      // head is now 5 , is just a reference
   }
   
   public void insertAfter(Node prev_node, int new_data)
   {
      if(prev_node == null)
      {
         System.out.println("can't be null");
         return;
      }
      Node new_node = new Node(new_data);
      
      new_node.next = prev_node.next; 
      
      prev_node.next = new_node;       
   }
   
   public void append (int new_data)
   {
      Node new_node = new Node(new_data); 
      
      //make sure that list is not empty
      if(head==null)
      {
         head = new Node(new_data);
         return;
      }
      
      //the new node is the last one so connect it to null
      new_node.next = null; 
      
      //now traverse to the end
      Node last = head;
      while(last.next!=null)
      {
         last = last.next; 
      }
      last.next = new_node; 
      return;
   }
      
   public static void main (String []args)
   {
      LinkedList llist = new LinkedList(); 
      llist.head = new Node(1); 
      Node second = new Node(2); 
      Node third = new Node(3);
      //at this point, three nodes created with null points. 
      
      llist.head.next = second; 
      //first node and second node were linked. 
      
      second.next = third; 
      //second and third were linked. 
      
      llist.printList();
      System.out.println();
      
      llist.push(5); 
      
      llist.printList();
      System.out.println();  
      
      llist.insertAfter(second, 8);
      llist.printList();
      System.out.println();
      
      llist.append(7);
      llist.printList();
      System.out.println();
   }
}