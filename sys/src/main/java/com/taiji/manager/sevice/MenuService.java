package com.taiji.manager.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.manager.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;

	public MenuRepository getMenuRepository() {
		return menuRepository;
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}
	
	
}
