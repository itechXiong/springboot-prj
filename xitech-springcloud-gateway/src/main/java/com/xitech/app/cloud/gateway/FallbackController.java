package com.xitech.app.cloud.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xitech.app.cloud.gateway.test.entity.XitechMenu;
import com.xitech.app.cloud.gateway.test.service.XitechMenuService;

@RestController
public class FallbackController {

	
	@GetMapping("/fallback")
	public String fallback() {
		return "spring cloud gateway hystrix fallback devtools " + System.currentTimeMillis();
	}
	
	
	@Autowired
	private XitechMenuService xitechMenuService;
	
	@GetMapping("/listMenu/{menuId}")
	public String listMenu(@PathVariable("menuId")Integer menuId) {
		
		XitechMenu menu = xitechMenuService.findMenuById(menuId);
		return menu.getMenuName();
		
	}
	
	@GetMapping("/insertMenu")
	public Boolean insertMenu() {
		
		XitechMenu menu = new XitechMenu();
		menu.setMenuName("menu1");
		menu.setMenuState("1");
		menu.setMenuUrl("www.test.com");
		xitechMenuService.insertMenu(menu);


		return true;
		
	}
	
}
