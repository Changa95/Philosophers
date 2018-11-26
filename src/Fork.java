
public class Fork
{
	private static int numberOfForks = 0;
	private int number;
	private boolean isFree;
	
	public Fork()
	{
		numberOfForks++;
		number = numberOfForks;
		isFree = true;
	}
	
	public boolean isFree()
	{
		return isFree;
	}
	
	public void setTaken()
	{
		isFree = false;
	}
	
	public void setFree()
	{
		isFree = true;
	}
}
