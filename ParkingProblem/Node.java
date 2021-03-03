package Parking_Problem;


public class Node {

	Integer data;
	Node next;
	Node prev;
	static int id_counter=0; 
	private String tag;


	public Node() {
		data=id_counter++;
		next=null;
		prev=null;
		tag="";
	}

	public void setTag(String tag ) {
		this.tag= tag;
	}

	public String getTag() {
		return tag;
	}
	
	@Override
	 public String toString() {
        return "{id=" + data +
                ", next= " + this.next.data +
                ", prev= " + this.prev.data +
                ", signed= " + tag + "}->\n";
    }
	

	
}
