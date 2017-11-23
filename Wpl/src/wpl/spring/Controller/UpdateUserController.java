package wpl.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import wpl.spring.entity.User;
import wpl.spring.service.UpdateUserService;

@Controller
@RequestMapping("/update")
public class UpdateUserController {

	@Autowired
	private UpdateUserService updateUserService;
	
	@RequestMapping("/updateUser")
	public String updateUser(Model theModel)
	{
		//create model attribute to bind item data
		User user = new User();
		theModel.addAttribute("profile",user);
		
		return "update-user";
	}
	
	// Form action = update
	@RequestMapping("/formUpdate")
	public String update(@ModelAttribute("profile") User user)
	{
		//System.out.println("itemid:" +ri.getItemId() + "Quantity: " +ri.getQuantity());
		//save item to registry
		
		updateUserService.updateUser(user);
		return "thankYou";
	}
}
