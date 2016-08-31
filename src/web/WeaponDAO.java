package web;

import java.util.List;

public interface WeaponDAO 
{
	public List<Weapon> getWeapons();
	public Weapon getSelectedWeapon(String name);
	public Weapon getWeaponByNumber(int number);
}
