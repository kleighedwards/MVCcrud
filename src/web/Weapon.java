package web;


public class Weapon 
{	
	public static int id = 0;
	private int number;
	private String name;
	private int attackRating;
	private String damageType;
	private String weaponClass;
	
	public Weapon(){
		this.number = id;
		id++;
		//Update ID so Spring will see it when calling no-args constructor
	}
	
	public Weapon(String name, int attackRating, String damageType, 
				  String weaponClass)
	{
		this.name = name;
		this.attackRating = attackRating;
		this.damageType = damageType;
		this.weaponClass = weaponClass;
		this.number = id;
		id++;
	}
	
	public int getNumber() 
	{
		return number;
	}

	public void setNumber(int number) 
	{
		this.number = number;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAttackRating() 
	{
		return attackRating;
	}

	public void setAttackRating(int attackRating) 
	{
		this.attackRating = attackRating;
	}

	public String getDamageType() 
	{
		return damageType;
	}

	public void setDamageType(String damageType) 
	{
		this.damageType = damageType;
	}

	public String getWeaponClass() 
	{
		return weaponClass;
	}

	public void setWeaponClass(String weaponClass) 
	{
		this.weaponClass = weaponClass;
	}

	@Override
	public String toString() 
	{
		return "Weapon [name=" + name + ", attackRating=" + attackRating + ", damageType=" + damageType
				+ ", weaponClass=" + weaponClass + "]";
	}

}
