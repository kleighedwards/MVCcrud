package web;

public class Weapon 
{	
	private int number;
	private String name;
	private int attackRating;
	private String damageType;
	private String weaponClass;
	private int strengthReq;
	private int dexReq;
	private int magicReq;
	
	public Weapon(){}
	
	public Weapon(int number, String name, int attackRating, String damageType, 
				  String weaponClass, int strengthReq, int dexReq, int magicReq)
	{
		this.number = number;
		this.name = name;
		this.attackRating = attackRating;
		this.damageType = damageType;
		this.weaponClass = weaponClass;
		this.strengthReq = strengthReq;
		this.dexReq = dexReq;
		this.magicReq = magicReq;
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

	public int getStrengthReq() 
	{
		return strengthReq;
	}

	public void setStrengthReq(int strengthReq) 
	{
		this.strengthReq = strengthReq;
	}

	public int getDexReq() 
	{
		return dexReq;
	}

	public void setDexReq(int dexReq) 
	{
		this.dexReq = dexReq;
	}

	public int getMagicReq() 
	{
		return magicReq;
	}

	public void setMagicReq(int magicReq) 
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
