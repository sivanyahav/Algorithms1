package Parking_Problem;

public class Parking_problem_twoRobouts {
	public static int cycleSize2 (CycleList a) {
		int count =0;
		
		a.head.setTag("V");
		Node r1=a.head.next;
		Node r2=a.head.prev;
		count++;
		
		while(!r1.equals(r2)) {
			r1=r1.next;
			r2=r2.prev;
			count++;
		}
		
		return count;
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
		
		int ans=cycleSize2(c);
		System.out.println("should be 7----> "+ans);
	}
}
