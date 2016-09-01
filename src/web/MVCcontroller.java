package web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MVCcontroller 
{
	@Autowired
	private WeaponDAO weaponDAO;
	
	@RequestMapping("Inventory.do")
	public ModelAndView listInventory()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");

		return mv;	
	}
	
	@RequestMapping("goToAdd.do")
	public ModelAndView goToAdd()
	{
		Weapon w = new Weapon();
        return new ModelAndView("add.jsp", "weapon", w);
	}
	
	@RequestMapping("addInventory.do")
	public ModelAndView addWeapon(@Valid Weapon weapon, Errors errors) 
	{
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) 
		{
			mv.setViewName("add.jsp");
			return mv;
		}
		
		weaponDAO.addWeapon(weapon);
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
	@RequestMapping("removeInventory.do")
	public ModelAndView removeWeapon(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
	@RequestMapping("goToInfusion.do")
	public ModelAndView goToInfusion()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("infusion.jsp");
		return mv;
	}
	
	@RequestMapping("Infusion.do")
	public ModelAndView infuseWeapon(@RequestParam("menu") String selectedName,
									 @RequestParam("damageType") String infusion)
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selectedName);
		currentWeapon.setDamageType(infusion);
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
	@RequestMapping("goToReinforce.do")
	public ModelAndView goToReinforce()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("reinforce.jsp");
		return mv;
	}
	
	@RequestMapping("Reinforce.do")
	public ModelAndView reinforceWeapon(@RequestParam("menu") String selectedName)
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selectedName);
		if (currentWeapon.getName().contains("Reinforced"))
		{
			currentWeapon.setAttackRating(currentWeapon.getAttackRating() + 100);
		}
		
		if (!currentWeapon.getName().contains("Reinforced"))
		{
			currentWeapon.setName("Reinforced " + currentWeapon.getName());
			currentWeapon.setAttackRating(currentWeapon.getAttackRating() + 100);
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
}
