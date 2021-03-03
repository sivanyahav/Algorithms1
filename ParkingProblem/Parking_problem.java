package Parking_Problem;


public class Parking_problem {

	//בעיית גודל חניה מעגלית

	public static int cycleSize (CycleList list) {

		if(list.head == null)
			return 0;

		list.head.setTag("V");
		Node temp= list.head;
		int count=0;
		int size=0;
		temp=temp.next;
		count++;

		while(!temp.getTag().equals("V")){
			temp=temp.next;
			count++;
		}

		size=count;

		temp.setTag("delete");

		while(count!=0) {
			temp=temp.prev;
			count--;
		}

		if(list.head.getTag().equals("delete"))
			return size;

		return size;
	}

	public static void main(String[] args) {
		CycleList c= new CycleList();
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		c.add(new Node());
		int ans=cycleSize(c);
		System.out.println("should be 7----> "+ans);


		CycleList list = new CycleList();
		
		for(int i = 0 ; i < 5 ; i++)
			list.add(new Node());
		
		list.getNode(7).setTag("v");
		list.getNode(10).setTag("v");
		list.print();
		System.out.println(cycleSize(list));
	}
}
