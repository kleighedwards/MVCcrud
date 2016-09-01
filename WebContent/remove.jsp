<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Remove Weapon From Inventory</title>
</head>
<body>
	
	<div class="weaponSelect">
		<form action="removeInventory.do" method="POST">
			<select name="menu">
				<c:forEach var="weapon" items="${weaponList}">
				<option value="${weapon.name}">${weapon.name}</option>
				</c:forEach>
			</select>
			<input type="submit" name="button" value="Remove Weapon"/><br>
		</form>
	</div>
	
</body>
</html>