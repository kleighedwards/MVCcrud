<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Add to Inventory</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
</head>
<body id="addWeapon">
	
	<ul>
		<li><a href="Inventory.do">List All Weapons</a></li>
	</ul>
	
	<div class="infusionDiv">
	
	<h2>Add Weapon to Inventory</h2>
	
	<form:form action="addInventory.do" modelAttribute="weapon">
		Name Your Weapon<br>
		<form:input path="name" placeholder="Weapon Name"/><br>
		Set Base Damage<br>
		<form:input path="attackRating" placeholder="Base Damage"/>
		<form:errors path="attackRating" placeholder="Base Damage"/><br>
		<br>
	
	Damage Type:<br>
	<input type="checkbox" name="damageType" value="Physical"/>
	Physical<br>
	<input type="checkbox" name="damageType" value="Bleed"/>
	Bleed<br>
  	<input type="checkbox" name="damageType" value="Fire" />
	Fire<br>
  	<input type="checkbox" name="damageType" value="Chaos" />
  	Chaos<br>
  	<input type="checkbox" name="damageType" value="Lightning" />
  	Lightning<br>
  	<input type="checkbox" name="damageType" value="Magic" />
  	Magic<br>
  	<input type="checkbox" name="damageType" value="Dark" />
  	Dark<br>
  	<br>
  	Weapon Class:<br>
  	<input type="radio" name="weaponClass" value="Dagger"/>
  	Dagger<br>
  	<input type="radio" name="weaponClass" value="Straight Sword"/>
  	Straight Sword<br>
  	<input type="radio" name="weaponClass" value="Greatsword"/>
  	Greatsword<br>
  	<input type="radio" name="weaponClass" value="Ultra Greatsword"/>
  	Ultra Greatsword<br>
  	<input type="radio" name="weaponClass" value="Curved Sword"/>
  	Curved Sword<br>
  	<input type="radio" name="weaponClass" value="Katana"/>
  	Katana<br>
  	<input type="radio" name="weaponClass" value="Piercing Sword"/>
  	Piercing Sword (Rapier)<br>
  	<input type="radio" name="weaponClass" value="Spear"/>
  	Spear<br>
  	<input type="radio" name="weaponClass" value="Halberd"/>
  	Halberd<br>
  	<input type="radio" name="weaponClass" value="Axe"/>
  	Axe<br>
  	<input type="radio" name="weaponClass" value="Great Axe"/>
  	Great Axe<br>
  	<input type="radio" name="weaponClass" value="Great Hammer"/>
  	Great Hammer<br>
  	<input type="radio" name="weaponClass" value="Bow"/>
  	Bow<br>
  	<input type="radio" name="weaponClass" value="Catalyst"/>
  	Catalyst<br>
  	<br>
  	<input class="removeButton" type="submit" value="Add to Inventory"/>
	</form:form>

	</div>

</body>
</html>