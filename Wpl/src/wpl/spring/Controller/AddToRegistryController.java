package wpl.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import wpl.spring.entity.Inventory;
import wpl.spring.entity.Registry;
import wpl.spring.entity.User;
import wpl.spring.entity.registryItem;
import wpl.spring.service.AddToRegistryService;

@Controller
@RequestMapping("/item")
public class AddToRegistryController {

	//inject addToREgistryservice
	@Autowired
	private AddToRegistryService addToRegistryService;
	
	
	//when user after creating registry click on add items button
	@RequestMapping("/addItem")
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
	
	@RequestMapping("/removeItem")
	public String removeItem(Model theModel)
	{
		registryItem remove = new registryItem();
		theModel.addAttribute("removeItem",remove);
		
		return "remove-item";
	}
	
	//form action: remove
	@RequestMapping("/remove")
	public String remove(@ModelAttribute("removeItem") registryItem remove)
	{
		//remove items from registry		
		addToRegistryService.removeItem(remove);
		return "thankYou";
	}
	
	@RequestMapping("/searchItem")
	public String searchItem(Model theModel)
	{
		Inventory search = new Inventory();
		theModel.addAttribute("searchItem",search);
		
		return "search-item";
	}
	
	@RequestMapping("/search")
	public String search(@ModelAttribute("searchItem") Inventory search, Model newModel)
	{
		List<Inventory> itemList =  addToRegistryService.searchItem(search);
		
		// NPE if item not found
		System.out.println(itemList.get(0).getItemId());
		newModel.addAttribute("itemList", itemList);
		return "thankYou";
	}
	
	
}
