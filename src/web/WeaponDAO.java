package web;

import java.util.List;

public interface WeaponDAO 
{
	public List<Weapon> getWeapons();
	public int getSelectedWeapon(String name);
	public Weapon getWeaponByNumber(int number);
	public void addWeapon(Weapon weapon);
	public void removeWeapon(int number);
}
