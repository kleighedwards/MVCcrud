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
				int attackRating = Integer.parseInt(tokens[2]);
				String damageType = tokens[3];
				String weaponClass = tokens[4];
				int strengthReq = Integer.parseInt(tokens[5]);
				int dexReq = Integer.parseInt(tokens[6]);
				int magicReq = Integer.parseInt(tokens[6]);
				weapons.add(new Weapon(number, name, attackRating, damageType, weaponClass, 
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
	public Weapon getSelectedWeapon(String name) 
	{
		return null;
	}

	@Override
	public Weapon getWeaponByNumber(int number) 
	{
		return weapons.get(number);
	}

}
