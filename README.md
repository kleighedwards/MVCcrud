# Skill Distillery Week 7 & 8 Project - Kristen Edwards

## Understanding Spring MVC and Database Structures with C.R.U.D. applications


### Project Overview
-   Use Spring MVC to create a unique C.R.U.D. (Create, Read, Update, Delete) application. 
-   Update this program to function with a self-constructed database.
-   My application functions as a video game weapon inventory. 
-   The user is able to view the existing weapons in their inventory, create new weapons, or remove weapons they
    no longer want. 
-   They may also modify their weapons by either "Infusing" them (changing the damage type of the weapon) or by                "Reinforcing" them (increasing the weapons base damage). 
    -   Upon Reinforcing a weapon, the weapon's name will appear with a "Reinforced" lable preceeding the original             name. 
-   The user may also filter through their inventory by "Weapon Classes" (swords, spears, bows, and the like).
    
### Goals Moving Forward
Week 7:
I would very much like to go more in depth with this project. Ideally, I would 
like the user to be able to click on each weapon and be shown detailed 
information about the weapon in question (including pictures and details not shown in 
the original inventory list). At present, I am unsure how to go about this without having 
numerous JSP's dedicated to each weapon individually. Additionally, I am unsure as to 
how I would include user-generated weapons in this process.

Week 8:
I would also like to modify my current database structure. I would need to do a fair bit of
refactoring to accomodate the database design I was initially attempting to implement.
    
### Stumbling Blocks

Week 7:
Although my program functions well enough, there is a fair amount of repetition 
in my code. I would like to condense what I have into something more managable. 
I feel this will also allow me to explore the additional functionality
I mentioned in the previous section.

Week 8:
Given the structure of my program, an intricate database wasn't entirely necessary. Trying
to modify my code to accomodate this more involved database design forced me to refactor
a good portion of my code. I ultimately decided to abandon this model and simplify it to 
something that worked better with my program's structure.

### Access This Program On AWS

-    http://52.34.37.216:8080/MVCcrud/
