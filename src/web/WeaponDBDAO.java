package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeaponDBDAO implements WeaponDAO {
	private static String url = "jdbc:mysql://localhost:3306/weaponinventory";

	private static final String user = "root";
	private static String pword = "root";

	public WeaponDBDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public List<Weapon> getWeapons() {
		List<Weapon> weapons = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {

				Weapon weapon = new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				// weapon.setInfusions(getDamageTypes(rs.getString(3)));
				weapons.add(weapon);

			}
			System.out.println(weapons);
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return weapons;
	}

	@Override
	public int getSelectedInt(String name) {
		// Never Used In Original Program
		return 0;
	}

	@Override
	public Weapon getSelectedWeapon(String name) {
		Weapon weapon = null;

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE w.name = ?";

			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				weapon = new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				// weapon.setInfusions(getDamageTypes(weapon.getName()));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return weapon;
	}

	@Override
	public Weapon getWeaponByNumber(int number) {
		// Never Used In Original Program
		return null;
	}

	@Override
	public void addWeapon(Weapon weapon) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "INSERT INTO weapon(name, attack_rating, damage_type, weapon_class_id, weapon_subclass_id) "
					+ " VALUES (?, ?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sqltxt, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, weapon.getName());
			stmt.setInt(2, weapon.getAttackRating());
			stmt.setString(3, weapon.getDamageType());
			// Set weapon_class_id

			// Set weapon_class_id for Swords and Daggers
			if (weapon.getWeaponClass().contains("Dagger") || weapon.getWeaponClass().contains("Sword")
					|| weapon.getWeaponClass().contains("sword") || weapon.getWeaponClass().contains("Katana")) {
				stmt.setInt(4, 1);
			}
			// Set weapon_class_id for Spears and Halberds
			if (weapon.getWeaponClass().contains("Spear") || weapon.getWeaponClass().contains("Halberd")) {
				stmt.setInt(4, 2);
			}
			// Set weapon_class_id for Axes and Hammers
			if (weapon.getWeaponClass().contains("Axe") || weapon.getWeaponClass().contains("Hammer")) {
				stmt.setInt(4, 3);
			}
			// Set weapon_class_id for Whips
			if (weapon.getWeaponClass().contains("Whip")) {
				stmt.setInt(4, 4);
			}
			// Set weapon_class_id for Bows
			if (weapon.getWeaponClass().contains("Bow")) {
				stmt.setInt(4, 5);
			}
			// Set weapon_class_id for Catalysts
			if (weapon.getWeaponClass().contains("Catalyst")) {
				stmt.setInt(4, 6);
			}
			// Set weapon_subclass_id
			// Set weapon_subclass_id for Dagger
			if (weapon.getWeaponClass().equals("Dagger")) {
				stmt.setInt(5, 1);
			}
			// Set weapon_subclass_id for Straight Sword
			if (weapon.getWeaponClass().equals("Straight Sword")) {
				stmt.setInt(5, 2);
			}
			// Set weapon_subclass_id for Greatsword
			if (weapon.getWeaponClass().equals("Greatsword")) {
				stmt.setInt(5, 3);
			}
			// Set weapon_subclass_id for Ultra Greatsword
			if (weapon.getWeaponClass().equals("Ultra Greatsword")) {
				stmt.setInt(5, 4);
			}
			// Set weapon_subclass_id for Curved Sword
			if (weapon.getWeaponClass().equals("Curved Sword")) {
				stmt.setInt(5, 5);
			}
			// Set weapon_subclass_id for Katana
			if (weapon.getWeaponClass().equals("Katana")) {
				stmt.setInt(5, 6);
			} // Set weapon_subclass_id for Rapiers
			if (weapon.getWeaponClass().equals("Piercing Sword")) {
				stmt.setInt(5, 7);
			}
			// Set weapon_subclass_id for Spear
			if (weapon.getWeaponClass().equals("Spear")) {
				stmt.setInt(5, 8);
			}
			// Set weapon_subclass_id for Halberd
			if (weapon.getWeaponClass().equals("Halberd")) {
				stmt.setInt(5, 9);
			}
			// Set weapon_subclass_id for Axe
			if (weapon.getWeaponClass().equals("Axe")) {
				stmt.setInt(5, 10);
			}
			// Set weapon_subclass_id for Great Axe
			if (weapon.getWeaponClass().equals("Great Axe")) {
				stmt.setInt(5, 11);
			}
			// Set weapon_subclass_id for Great Hammer
			if (weapon.getWeaponClass().equals("Great Hammer")) {
				stmt.setInt(5, 12);
			}
			// Set weapon_subclass_id for Whip
			if (weapon.getWeaponClass().equals("Whip")) {
				stmt.setInt(5, 13);
			}
			// Set weapon_subclass_id for Bow
			if (weapon.getWeaponClass().equals("Bow")) {
				stmt.setInt(5, 14);
			}
			// Set weapon_subclass_id for Catalyst
			if (weapon.getWeaponClass().equals("Catalyst")) {
				stmt.setInt(5, 15);
			}

			int uc = stmt.executeUpdate();

			if (uc == 1) {
				System.out.println("DEBUG: WeaponDAO.addWeapon(): Weapon added: " + weapon);
				ResultSet keys = stmt.getGeneratedKeys();
				int newWeaponId;
				if (keys.next()) {
					newWeaponId = keys.getInt(1);
					System.out.println("Weapon added, id: " + newWeaponId);
					// List<Infusion> infusions = weapon.getInfusions();
					// if (infusions.size() > 0) {
					// sqltxt = "INSERT INTO weapon_infusion (weapon_id,
					// infusion_id) VALUES (?, ?)";
					// stmt = conn.prepareStatement(sqltxt);
					// for (Infusion infusion : infusions) {
					// stmt.setInt(1, newWeaponId);
					// stmt.setInt(2, infusion.getId());
					// uc = stmt.executeUpdate();
					// if (uc == 1)
					// {
					// System.out.println("Added infusion " + infusion);
					// }
					// }
					// }
				}
			} else {
				System.err.println("DEBUG: WEAPONDBDAO.addWeapon(): No weapon added.");
			}

			conn.close();

		} catch (SQLException sqle) {
			System.out.println(sqle);
		}
	}

	@Override
	public void removeWeapon(Weapon weapon) {
		String weaponName = weapon.getName();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pword);
			conn.setAutoCommit(false);
			String sqltxt;
			sqltxt = "DELETE FROM weapon WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, weaponName);
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				conn.commit();
				System.out.println("Weapon deleted: " + weapon);
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			try {
				conn.rollback();
				System.out.println("Transaction rolled back.");
			} catch (SQLException e) {
				System.err.println("Error rolling back transaction: " + e);
			}
			sqle.printStackTrace(System.err);
		}
	}

	@Override
	public void infuseWeapon(Weapon weapon) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pword);
			String sqltxt;
			String weaponName = weapon.getName();
			sqltxt = "UPDATE weapon SET damage_type = ? WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, weapon.getDamageType());
			stmt.setString(2, weaponName);
			
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Weapon updated.");
				
			} else {
				System.err.println("Weapon not updated.");
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}

	public void reinforceWeapon(Weapon weapon)
	{
		try {
			Connection conn = DriverManager.getConnection(url, user, pword);
			String sqltxt;
			String weaponName = weapon.getName();
			int baseDamage = weapon.getAttackRating();
			int reinforcedDamage = baseDamage + 100;
			sqltxt = "UPDATE weapon SET name = ?, attack_rating = ? WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(3, weaponName);
			stmt.setInt(2, reinforcedDamage);
			
			if (!weaponName.contains("Reinforced"))
			{
				 weapon.setName("Reinforced " + weaponName);
				 String newWeaponName = weapon.getName();
				 
				 stmt.setString(1, newWeaponName);
			}
			
			if (weaponName.contains("Reinforced"))
			{
				stmt.setString(1, weaponName);
			}
			
			int uc = stmt.executeUpdate();
			if (uc == 1) {
				System.out.println("Weapon updated.");
				
			} else {
				System.err.println("Weapon not updated.");
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}
	
	// No Longer Implementing
	private List<Infusion> getDamageTypes(String damageType) {
		List<Infusion> infusions = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pword);
			String sqltxt;
			sqltxt = "SELECT infusion.infusion, weapon_infusion.infusion_id "
					+ "FROM weapon JOIN weapon_infusion ON weapon.id = weapon_infusion.weapon_id "
					+ "JOIN infusion ON weapon_infusion.infusion_id = infusion.id " + "WHERE weapon.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, damageType);
			ResultSet rs = stmt.executeQuery();
			infusions = new ArrayList<>();
			while (rs.next()) {
				infusions.add(new Infusion(rs.getString(1)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
		return infusions;
	}

	@Override
	public List<Weapon> getSwords() {
		List<Weapon> swords = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_class wc on w.weapon_class_id = wc.id "
					+ "JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE wsc.weapon_class_id = 1 "
					+ "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {
				swords.add(new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return swords;
	}

	@Override
	public List<Weapon> getAxes() {
		List<Weapon> axes = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_class wc on w.weapon_class_id = wc.id "
					+ "JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE wsc.weapon_class_id = 3 "
					+ "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {
				axes.add(new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return axes;
	}

	@Override
	public List<Weapon> getSpears() {
		List<Weapon> spears = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_class wc on w.weapon_class_id = wc.id "
					+ "JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE wsc.weapon_class_id = 2 "
					+ "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {
				spears.add(new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return spears;
	}

	@Override
	public List<Weapon> getWhips() {
		List<Weapon> whips = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_class wc on w.weapon_class_id = wc.id "
					+ "JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE wsc.weapon_class_id = 4 "
					+ "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {
				whips.add(new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return whips;
	}

	@Override
	public List<Weapon> getBows() {
		List<Weapon> bows = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_class wc on w.weapon_class_id = wc.id "
					+ "JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE wsc.weapon_class_id = 5 "
					+ "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {
				bows.add(new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return bows;
	}

	@Override
	public List<Weapon> getCatalysts() {
		List<Weapon> catalysts = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pword);

			String sqltxt;
			sqltxt = "SELECT w.name, w.attack_rating, w.damage_type, wsc.weapon_type "
					+ "FROM weapon w JOIN weapon_class wc on w.weapon_class_id = wc.id "
					+ "JOIN weapon_subclass wsc on w.weapon_subclass_id = wsc.id " + "WHERE wsc.weapon_class_id = 6 "
					+ "ORDER BY w.name";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sqltxt);

			while (rs.next()) {
				catalysts.add(new Weapon(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			conn.close();
		} catch (SQLException sqle) {
			System.out.println(sqle);
		}

		return catalysts;
	}
}
