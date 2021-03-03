package Parking_Problem;

public class CycleList {
	  	
	 Node head;
	 Node tail;
	 private int size;
	 
	 public CycleList() {
		 head=null;
		 tail=null;
		 size=0;
	 }
	 
	 public void add(Node n) {
		 
		 
		 if(size==0){
			 head=n;
			 tail=n;
			 tail.next=head;
			 head.prev=tail;
		 }
		 else {
			 Node curr= tail;
			 curr.next =n;
			 n.prev=curr;
			 n.next=head;
			 tail=n;
			
		 }
		 size++;
	 }
	 
	 public int size() {
	        return this.size;
	    }
	 
	 public Node getNode(int data) {
	        Node current = head;
	        while (current != tail) {
	            if(current.data == data)
	                return current;
	            current = current.next;
	        }
	        if(tail.data == data)
	            return tail;
	        return null;
	    }
	 
	 public void print(){
	        Node current = head;
	        while(current != tail) {
	            System.out.print(current.data+"->");
	            current = current.next;
	        }
	        System.out.print(tail.data+"->");
	        System.out.println();
	    }
	 
	 public static void main(String[] args) {
		CycleList c= new CycleList();
		//7 nodes
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		
		System.out.println(c.size);
	}

}
