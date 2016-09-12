package web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class WeaponFileDAO implements WeaponDAO
{

	private static final String FILE_NAME="/WEB-INF/weapons.csv";
	private List<Weapon> weapons = new ArrayList<>();
	
	@Autowired 
	private WebApplicationContext wac;

	@PostConstruct
	public void init() 
	{
		try (
				InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));
			) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				int number = Integer.parseInt(tokens[0]);
				String name = tokens[1];
				int attackRating = Integer.parseInt(tokens[2]);
				String damageType = tokens[3];
				String weaponClass = tokens[4];
				weapons.add(new Weapon(name, attackRating, damageType, weaponClass));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Override
	public List<Weapon> getWeapons() 
	{
		return weapons;
	}

	@Override
	public int getSelectedInt(String name) 
	{
		Weapon w = null;
		int num = 0;
		
		for(Weapon weapon : weapons)
		{
			if (weapon.getName().equals(name))
			{
				w = weapon;
				num = w.getNumber();
				break;
			}
		}
			
			return num;
	}
	
	@Override
	public Weapon getSelectedWeapon(String name) 
	{
		Weapon w = null;
		
		for(Weapon weapon : weapons)
		{
			if (weapon.getName().equals(name))
			{
				w = weapon;
				break;
			}
		}
			
			return w;
	}
	
	@Override
	public Weapon getWeaponByNumber(int number) 
	{
		return weapons.get(number);
	}
	
	@Override
	public void addWeapon(Weapon weapon)
	{
		weapons.add(weapon);
	}
	
	@Override
	public void removeWeapon(Weapon weapon)
	{
		weapons.remove(weapon);
	}
	
	public List<Weapon> getSwords()
	{
		List<Weapon> swords = new ArrayList<>();
		for(Weapon weapon : weapons)
		{
			if (weapon.getWeaponClass().contains("Dagger"))
			{
				swords.add(weapon);
			}
			if (weapon.getWeaponClass().contains("Sword"))
			{
				swords.add(weapon);
			}
			if (weapon.getWeaponClass().contains("sword"))
			{
				swords.add(weapon);
			}
			if (weapon.getWeaponClass().contains("Katana"))
			{
				swords.add(weapon);
			}
			
		}
		return swords;	
	}
	
	public List<Weapon> getAxes()
	{
		List<Weapon> axes = new ArrayList<>();
		for(Weapon weapon : weapons)
		{
			if (weapon.getWeaponClass().contains("Axe"))
			{
				axes.add(weapon);
			}
			if (weapon.getWeaponClass().contains("Hammer"))
			{
				axes.add(weapon);
			}
		}
		return axes;	
	}
	
	public List<Weapon> getSpears()
	{
		List<Weapon> spears = new ArrayList<>();
		for(Weapon weapon : weapons)
		{
			if (weapon.getWeaponClass().contains("Spear"))
			{
				spears.add(weapon);
			}
			if (weapon.getWeaponClass().contains("Halberd"))
			{
				spears.add(weapon);
			}
			
		}
		return spears;	
	}
	
	public List<Weapon> getWhips()
	{
		List<Weapon> whips = new ArrayList<>();
		for(Weapon weapon : weapons)
		{
			if (weapon.getWeaponClass().contains("Whip"))
			{
				whips.add(weapon);
			}
		}
		return whips;	
	}
	
	public List<Weapon> getBows()
	{
		List<Weapon> bows = new ArrayList<>();
		for(Weapon weapon : weapons)
		{
			if (weapon.getWeaponClass().contains("Bow"))
			{
				bows.add(weapon);
			}
		}
		return bows;	
	}
	
	public List<Weapon> getCatalysts()
	{
		List<Weapon> catalysts = new ArrayList<>();
		for(Weapon weapon : weapons)
		{
			if (weapon.getWeaponClass().contains("Catalyst"))
			{
				catalysts.add(weapon);
			}
			
		}
		return catalysts;	
	}

	@Override
	public void infuseWeapon(Weapon weapon) {
		// New Method Not Used In Original Program
		
	}

	@Override
	public void reinforceWeapon(Weapon weapon) {
		// New Method Not Used In Original Program
		
	}
}
