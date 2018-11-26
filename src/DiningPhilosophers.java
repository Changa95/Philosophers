import java.util.ArrayList;

public class DiningPhilosophers {

	public static void main(String[] args)
	{
		new DiningPhilosophers();
	}
	
	public DiningPhilosophers()
	{
		
		Fork f1 = new Fork();
		Fork f2 = new Fork();
		Fork f3 = new Fork();
		Fork f4 = new Fork();
		Fork f5 = new Fork();
		
		Philosopher p1 = new Philosopher(f1, f5);
		Philosopher p2 = new Philosopher(f1, f2);
		Philosopher p3 = new Philosopher(f2, f3);
		Philosopher p4 = new Philosopher(f3, f4);
		Philosopher p5 = new Philosopher(f4, f5);
		
		ArrayList<Philosopher> philosopherList= new ArrayList<>();
		philosopherList.add(p1);
		philosopherList.add(p2);
		philosopherList.add(p3);
		philosopherList.add(p4);
		philosopherList.add(p5);

		ArrayList<Fork> forkList= new ArrayList<>();
		forkList.add(f1);
		forkList.add(f2);
		forkList.add(f3);
		forkList.add(f4);
		forkList.add(f5);

		//new TableFrame(philosopherList, forkList);
	}

}
