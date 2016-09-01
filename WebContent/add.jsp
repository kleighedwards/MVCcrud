<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Add to Inventory</title>
</head>
<body>
	<h2>Add Weapon to Inventory</h2>
	
	<form:form action="addInventory.do" modelAttribute="weapon">
		<form:input path="name" placeholder="Weapon Name"/><br>
		<form:input path="attackRating" placeholder="Base Damage"/>
		<form:errors path="attackRating" placeholder="Base Damage"/><br>
		<form:input path="damageType" placeholder="Damage Type"/><br>
		<form:input path="weaponClass" placeholder="Weapon Class"/><br>
		<form:input path="strengthReq" placeholder="Strength Requirement"/><br>
		<form:input path="dexReq" placeholder="Dexterity Requirement"/><br>
		<form:input path="magicReq" placeholder="Magic Requirement"/><br>
		<br>
		<input type="submit" value="Add to Inventory"/>
	</form:form>

</body>
</html>