package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView firstBoss(@RequestParam("button") String button
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
}
