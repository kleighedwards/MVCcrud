package web;

import java.util.List;

public interface WeaponDAO 
{
	public List<Weapon> getWeapons();
	public int getSelectedInt(String name);
	public Weapon getSelectedWeapon(String name);
	public Weapon getWeaponByNumber(int number);
	public void addWeapon(Weapon weapon);
	public void removeWeapon(Weapon weapon);
	public List<Weapon> getSwords();
	public List<Weapon> getAxes();
	public List<Weapon> getSpears();
	public List<Weapon> getWhips();
	public List<Weapon> getBows();
	public List<Weapon> getCatalysts();

}
