package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.MenuItem;
import dmacc.repository.MenuItemRepository;

@Controller
public class WebController {

	@Autowired
	MenuItemRepository repo;

	@GetMapping({ "/", "/viewMenu" })
	public String viewFullMenu(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewItem(model);
		}
		model.addAttribute("menuItems", repo.findAll());
		return "results";
	}

	@GetMapping("/inputItem")
	public String addNewItem(Model model) {
		MenuItem m = new MenuItem();
		model.addAttribute("newMenuItem", m);
		return "input";
	}

	@PostMapping("/inputItem")
	public String addNewItem(@ModelAttribute MenuItem m, Model model) {
		repo.save(m);
		return viewFullMenu(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateItem(@PathVariable("id") long id, Model model) {
		MenuItem m = repo.findById(id).orElse(null);
		model.addAttribute("newMenuItem", m);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseItem(MenuItem m, Model model) {
		repo.save(m);
		return viewFullMenu(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") long id, Model model) {
		MenuItem m = repo.findById(id).orElse(null);
		repo.delete(m);
		return viewFullMenu(model);
	}
}
