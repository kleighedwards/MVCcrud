//No Longer Implementing This Class
package web;

public class Infusion 
{
	private int id;
	private String infusion;
	
	// No Args Constructor
	public Infusion()
	{
		
	}
	// One Args
	public Infusion(String infusion)
	{
		this.infusion = infusion;
	}
	// Two Args
	public Infusion(int id, String infusion)
	{
		this.id = id;
		this.infusion = infusion;
	}
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getInfusion() 
	{
		return infusion;
	}
	
	public void setInfusion(String infusion) 
	{
		this.infusion = infusion;
	}

	@Override
	public String toString() 
	{
		return infusion;
	}
}
