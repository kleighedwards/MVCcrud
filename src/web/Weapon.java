package web;


public class Weapon 
{	
	public static int id = 0;
	private int number;
	private String name;
	private int attackRating;
	private String damageType;
	private String weaponClass;
	private String strengthReq;
	private String dexReq;
	private String magicReq;
	
	public Weapon(){
		this.number = id;
		id++;
		//Update ID so Spring will see it when calling no-args constructor
	}
	
	public Weapon(String name, int attackRating, String damageType, 
				  String weaponClass, String strengthReq, String dexReq, String magicReq)
	{
		this.name = name;
		this.attackRating = attackRating;
		this.damageType = damageType;
		this.weaponClass = weaponClass;
		this.strengthReq = strengthReq;
		this.dexReq = dexReq;
		this.magicReq = magicReq;
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

	public String getStrengthReq() 
	{
		return strengthReq;
	}

	public void setStrengthReq(String strengthReq) 
	{
		this.strengthReq = strengthReq;
	}

	public String getDexReq() 
	{
		return dexReq;
	}

	public void setDexReq(String dexReq) 
	{
		this.dexReq = dexReq;
	}

	public String getMagicReq() 
	{
		return magicReq;
	}

	public void setMagicReq(String magicReq) 
	{
		this.magicReq = magicReq;
	}

	@Override
	public String toString() 
	{
		return "Weapon [name=" + name + ", attackRating=" + attackRating + ", damageType=" + damageType
				+ ", weaponClass=" + weaponClass + ", strengthReq=" + strengthReq + ", dexReq=" + dexReq + ", magicReq="
				+ magicReq + "]";
	}

}
