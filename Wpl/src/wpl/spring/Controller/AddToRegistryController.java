package wpl.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;
import wpl.spring.service.AddToRegistryService;

@Controller
@RequestMapping("/additem")
public class AddToRegistryController {

	//inject addToREgistryservice
	@Autowired
	private AddToRegistryService addToRegistryService;
	
	//when user after creating registry click on add items button
	@RequestMapping("/addPage")
	public String addItem(Model theModel)
	{
		//create model attribute to bind item data
		registryItem ri = new registryItem();
		theModel.addAttribute("registryitems",ri);
		
		return "add-item";
	}
	
	//Form action add
	@RequestMapping("/add")
	public String add(@ModelAttribute("registryitems") registryItem ri)
	{
		System.out.println("itemid:" +ri.getItemId() + "Quantity: " +ri.getQuantity());
		//save item to registry
		
		addToRegistryService.addItem(ri);
		return "add-item";
	}
	
	@RequestMapping("/updateItem")
	public String updateItem(Model theModel)
	{
		registryItem update = new registryItem();
		theModel.addAttribute("updateRegistry",update);
		
		return "update-item";
	}
	
	//form action: Update
	@RequestMapping("/update")
	public String update(@ModelAttribute("updateRegistry") registryItem update)
	{
		//System.out.println("itemid:" +ri.getItemId() + "Quantity: " +ri.getQuantity());
		//Update item in registry
		
		addToRegistryService.updateItem(update);
		return "thankYou";
	}
	
	
}
