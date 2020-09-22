package spring.mvc.thymeleaf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.thymeleaf.entities.User;

@Controller
public class BaseController {

	public List<User> initList() {
		List<User> listUser = new ArrayList<User>();
		listUser.add(new User(1, "Batman", "DC"));
		listUser.add(new User(2, "Super Woman", "DC"));
		listUser.add(new User(3, "Super Man", "DC"));
		return listUser;
	}

	public Set<User> initSet() {
		Set<User> setUser = new HashSet<User>();
		setUser.add(new User(4, "Iron Man", "Marvel"));
		setUser.add(new User(5, "Spider Man", "Marvel"));
		setUser.add(new User(6, "Ant Man", "Marvel"));
		return setUser;
	}

	public Map<Integer, User> initMap() {
		Map<Integer, User> mapUser = new HashMap<Integer, User>();
		mapUser.put(7, new User(7, "Mickey", "Disney"));
		mapUser.put(8, new User(8, "Donal", "Disney"));
		return mapUser;
	}

	@RequestMapping(value = "/")
	public String index(final Model model) {
		model.addAttribute("listUser", initList());
		model.addAttribute("mapUser", initMap());
		model.addAttribute("setUser", initSet());
		return "index";
	}
}
