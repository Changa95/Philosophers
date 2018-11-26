import java.util.Random;

import processing.core.PApplet;


public class Philosopher implements Runnable
{
	private static int numberOfPhilosophers = 0;
	private int number;
	private static final int THINKING_TIME = 10, EATING_TIME  = 5, SLEEPING_TIME = 5;
	private PhilosopherState currentState;
	private Thread thread;
	private Fork leftFork, rightFork;
	private boolean stop = false;
	private PApplet papplet;
	
	public Philosopher(Fork leftFork, Fork rightFork, PApplet papplet) 
	{
		numberOfPhilosophers++;
		number = numberOfPhilosophers;
		
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.papplet = papplet;
		
		thread = new Thread(this);
		thread.start();
	}
	
	private boolean takeFork(Fork fork)
	{
		if(fork.isFree())
		{
			fork.setTaken();
			return true;
		}			
		else 
			return false;
	}
	
	private void releaseFork(Fork fork)
	{
		fork.setFree();
	}
	
	public void draw(float x, float y, float size)
	{
		papplet.ellipse(x, y, size, size);
	}
	
	private void wait(int timeInMillis)
	{
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private PhilosopherState getRandomState()
	{
		Random randomGenerator = new Random();
		return PhilosopherState.values()[randomGenerator.nextInt(PhilosopherState.values().length)];
	}
	

	@Override
	public void run()
	{
		currentState = getRandomState();
		while(!stop)
		{
			if(currentState == PhilosopherState.EATING)
			{
				while(!takeFork(leftFork))
					wait(1);
				
				while(!takeFork(rightFork))
					wait(1);
				
				System.out.println("Philosopher " + number + " starts to eat!");
				wait(EATING_TIME * 1000);				
				System.out.println("Philosopher " + number + " stops eating!");
				releaseFork(leftFork);
				releaseFork(rightFork);
				currentState = getRandomState();
			}
			
			if(currentState == PhilosopherState.SLEEPING)
			{
				System.out.println("Philosopher " + number + " starts to sleep!");
				wait(SLEEPING_TIME * 1000);
				System.out.println("Philosopher " + number + " stops sleeping!");
				currentState = getRandomState();
			}
		
			if(currentState == PhilosopherState.THINKING)
			{
				System.out.println("Philosopher " + number + " starts to think!");
				wait(THINKING_TIME * 1000);
				System.out.println("Philosopher " + number + " stops thinking!");
				currentState = getRandomState();
			}
		}
	}
}
