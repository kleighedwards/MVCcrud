package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@SessionAttributes("weaponSession")
public class MVCcontroller 
{
	@Autowired
	private WeaponDAO weaponDAO;
	
//	@ModelAttribute("weaponSession")
//	public Weapon initSessionObject() 
//	{
//		return null;
//	}
	
	@RequestMapping("Inventory.do")
	public ModelAndView listInventory(@RequestParam("button") String button
								  /*@ModelAttribute("weaponSession") Weapon weapon*/)
	{
		ModelAndView mv = new ModelAndView();
		if (button.equals("List"))
		{
			mv.addObject("weaponList", weaponDAO.getWeapons());
		}
		
		mv.setViewName("view.jsp");

		return mv;	
	}
	
	@RequestMapping(path="addInventory.do", method=RequestMethod.POST)
	public ModelAndView addWeapon(Weapon weapon) 
	{
		weaponDAO.addWeapon(weapon);
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("view.jsp");
		return mv;
	}
	
	@RequestMapping("dropDown.do")
	public ModelAndView goToDropDown()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("weaponList", weaponDAO.getWeapons());
		mv.setViewName("remove.jsp");
		return mv;
	}
	
	@RequestMapping(path="removeInventory.do", method=RequestMethod.POST)
	public ModelAndView removeWeapon(@RequestParam("menu") String selected) 
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
	
}
