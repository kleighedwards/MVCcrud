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
	
	// Navigate to All Weapons
	@RequestMapping("Inventory.do")
	public ModelAndView listInventory()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");

		return mv;	
	}
	
	// Pass Information to Add Weapon
	@RequestMapping("goToAdd.do")
	public ModelAndView goToAdd()
	{
		ModelAndView mv = new ModelAndView();
        mv.setViewName("add.jsp");
        	mv.addObject("weapon", new Weapon());
        	// get list of infusions from dao, add to mv
        	// get list of weapon types from dao,add to mv
        	// List<Infusion> infList= weaponDao.getInfusions()
        	// mv.addObject("infusionList", infList);
        return mv;
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
	
	// Remove Weapon from Inventory (From All Weapons)
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
	
	// Remove Weapon from Inventory (From Filtered Lists)
	@RequestMapping("removeSword.do")
	public ModelAndView removeSword(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("swordList", weaponDAO.getSwords());
		mv.setViewName("swords.jsp");
		return mv;
	}
	@RequestMapping("removeAxe.do")
	public ModelAndView removeAxe(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("axeList", weaponDAO.getAxes());
		mv.setViewName("axes.jsp");
		return mv;
	}
	@RequestMapping("removeSpear.do")
	public ModelAndView removeSpear(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("spearList", weaponDAO.getSpears());
		mv.setViewName("spears.jsp");
		return mv;
	}
	@RequestMapping("removeWhip.do")
	public ModelAndView removeWhip(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("whipList", weaponDAO.getWhips());
		mv.setViewName("whips.jsp");
		return mv;
	}
	@RequestMapping("removeBow.do")
	public ModelAndView removeBow(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("bowList", weaponDAO.getBows());
		mv.setViewName("bows.jsp");
		return mv;
	}
	@RequestMapping("removeCatalyst.do")
	public ModelAndView removeCatalyst(@RequestParam("weapon") String selected) 
	{
		Weapon currentWeapon = weaponDAO.getSelectedWeapon(selected);
		weaponDAO.removeWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("catalystList", weaponDAO.getCatalysts());
		mv.setViewName("catalysts.jsp");
		return mv;
	}
	
	// Pass Information to Weapon Infusion
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
		weaponDAO.infuseWeapon(currentWeapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
	// Pass Information to Reinforce Weapon
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
		weaponDAO.reinforceWeapon(currentWeapon);
//		if (currentWeapon.getName().contains("Reinforced"))
//		{
//			currentWeapon.setAttackRating(currentWeapon.getAttackRating() + 100);
//		}
//		
//		if (!currentWeapon.getName().contains("Reinforced"))
//		{
//			currentWeapon.setName("Reinforced " + currentWeapon.getName());
//			currentWeapon.setAttackRating(currentWeapon.getAttackRating() + 100);
//		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
	// Pass Information to Filtered Weapon Class jsp's
	@RequestMapping("goToSwords.do")
	public ModelAndView goToSwords()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("swordList", weaponDAO.getSwords());
		mv.setViewName("swords.jsp");
		return mv;
	}
	@RequestMapping("goToAxes.do")
	public ModelAndView goToAxes()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("axeList", weaponDAO.getAxes());
		mv.setViewName("axes.jsp");
		return mv;
	}
	@RequestMapping("goToSpears.do")
	public ModelAndView goToSpears()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("spearList", weaponDAO.getSpears());
		mv.setViewName("spears.jsp");
		return mv;
	}
	@RequestMapping("goToWhips.do")
	public ModelAndView goToWhips()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("whipList", weaponDAO.getWhips());
		mv.setViewName("whips.jsp");
		return mv;
	}@RequestMapping("goToBows.do")
	public ModelAndView goToBows()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("bowList", weaponDAO.getBows());
		mv.setViewName("bows.jsp");
		return mv;
	}
	@RequestMapping("goToCatalysts.do")
	public ModelAndView goToCatalysts()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("catalystList", weaponDAO.getCatalysts());
		mv.setViewName("catalysts.jsp");
		return mv;
	}
	
}
