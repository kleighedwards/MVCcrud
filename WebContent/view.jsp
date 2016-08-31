<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Andre's Smithy</title>
</head>
<body>
	<h2>Your Inventory</h2>
	
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Base Damage</td>
				<td>Damage Type</td>
				<td>Weapon Class</td>
				<td>Strength Requirement</td>
				<td>Dexterity Requirement</td>
				<td>Magic Requirement</td>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="weapon" items="${weaponList}">
			
			<tr>
				<td>${weapon.name}</td>
				<td>${weapon.attackRating}</td>
				<td>${weapon.damageType}</td>
				<td>${weapon.weaponClass}</td>
				<td>${weapon.strengthReq}</td>
				<td>${weapon.dexReq}</td>
				<td>${weapon.magicReq}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a href="add.html">Add Weapon To Inventory</a>
	</div>
	
</body>
</html>