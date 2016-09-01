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
				String[] tokens = line.split("::");
				int number = Integer.parseInt(tokens[0]);
				String name = tokens[1];
				String attackRating = tokens[2];
				String damageType = tokens[3];
				String weaponClass = tokens[4];
				String strengthReq = tokens[5];
				String dexReq = tokens[6];
				String magicReq = tokens[6];
				weapons.add(new Weapon(name, attackRating, damageType, weaponClass, 
							strengthReq, dexReq, magicReq));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		for (Weapon weapon : weapons) {
			System.out.println(weapon);
		}
	}
	
	@Override
	public List<Weapon> getWeapons() 
	{
		return weapons;
	}

	@Override
	public int getSelectedWeapon(String name) 
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
	public void removeWeapon(int number)
	{
		weapons.remove(number);
	}
}
