package com.taiji.manager;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GeneratorType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taiji.manager.dto.MenuDto;
import com.taiji.manager.dto.RoleDto;
import com.taiji.manager.dto.UserDto;
import com.taiji.manager.entity.Menu;
import com.taiji.manager.entity.Role;
import com.taiji.manager.entity.User;
import com.taiji.manager.repository.UserRepository;
import com.taiji.manager.sevice.MenuService;
import com.taiji.manager.sevice.RoleService;
import com.taiji.manager.sevice.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerSysApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@Test
	public void contextLoads() {
	}
	
	/**
	 * 添加用户
	 * 
	 */
	@Test
	public void addUser() {
		//生成dto对象
		UserDto userDto = new UserDto();
		userDto.setId(UUID.randomUUID().toString());
		userDto.setUserNum("001");
		userDto.setUserName("张三");
		userDto.setSex((byte)1);
		userDto.setEmpType("服务员");
		userDto.setWorkAddr("1号楼15层");
		userDto.setFirstDeptDesc("科创部");
		userDto.setSecondDeptDesc("人力资源部");
		userDto.setPositionOrder("f");
		userDto.setPositionLevel("5");
		userDto.setPositionName("前台接待");
		Timestamp date = Timestamp.valueOf("2015-10-10 00:00:00");
		System.out.println(date);
		userDto.setHiredate(date);
		userDto.setPhone("12345678912");
		userDto.setEmail("54@qq.com");
		byte[] image = {0,1};
		userDto.setImages(image);
		userDto.setAge(25);
		userDto.setEducation("本科");
		Timestamp birthday = Timestamp.valueOf("1992-08-17 00:00:00");
		userDto.setBirthday(birthday);
		
		//将dto对象转化为user
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		//保存到数据库
		
		userService.getUserRepository().save(user);
		
	}
	
	/**
	 * 寻找用户
	 * 
	 */
	@Test
	public void findUser() {
		User findOne = userService.getUserRepository().findOne("001");
		System.out.println(findOne);
		List<User> findAll = userService.getUserRepository().findAll();
		for (User user : findAll) {
			System.out.println(user);
		}
	}
	
	/**
	 * 删除用户
	 * 
	 */
	@Test
	public void delUser() {
		userService.getUserRepository().delete("001");
		//userService.getUserRepository().delete(entity);
	}
	
	/**
	 * 更新用户
	 * 
	 */
	@Test
	public void update() {
		userService.getUserRepository().updateUser("xxx", "001");
	}
	
	
	
	
	/**
	 * 添加权限
	 * 
	 */
	@Test
	public void addRole() {
		RoleDto roleDto = new RoleDto();
		roleDto.setId("001");
		roleDto.setRoleName("管理员");
		roleDto.setRoleDesc("所有权限");
		
		Role role = new Role();
		BeanUtils.copyProperties(roleDto,role);
		
		roleService.getRoleRepository().save(role);
		
	}
	
	/**
	 * 寻找权限
	 * 
	 */
	@Test
	public void findRole() {
		Role findOne = roleService.getRoleRepository().findOne("001");
		System.out.println(findOne);
		List<Role> findAll = roleService.getRoleRepository().findAll();
		for (Role role : findAll) {
			System.out.println(role);
		}
	}
	
	/**
	 * 删除权限
	 * 
	 */
	@Test
	public void delRole() {
		roleService.getRoleRepository().delete("001");
		//roleService.getRoleRepository().delete(entity);
	}
	
	/**
	 * 更新权限
	 * 
	 */
	@Test
	public void updateRole() {
		roleService.getRoleRepository().updateRole("quanxian", "管理员");
	}
	
	
	
	
	/**
	 * 添加菜单
	 * 
	 */
	@Test
	public void addMenu() {
		MenuDto menuDto = new MenuDto();
		menuDto.setId("001");
		menuDto.setMenuName("菜单");
		menuDto.setMenuDesc("所有菜单");
		menuDto.setUrl("/getAllMenus");
		menuDto.setMenu(null);
		
		Menu menu = new Menu();
		BeanUtils.copyProperties(menuDto,menu);
		
		menuService.getMenuRepository().save(menu);
	}
	
	/**
	 * 寻找菜单
	 * 
	 */
	@Test
	public void findMenu() {
		Menu findOne = menuService.getMenuRepository().findOne("001");
		System.out.println(findOne);
		List<Menu> findAll = menuService.getMenuRepository().findAll();
		for (Menu menu : findAll) {
			System.out.println(menu);
		}
	}
	
	/**
	 * 删除菜单
	 * 
	 */
	@Test
	public void delMenu() {
		menuService.getMenuRepository().delete("001");
		//menuService.getMenuRepository().delete(entity);
	}
	
	/**
	 * 更新菜单
	 * 
	 */
	@Test
	public void updateMenu() {
		
		menuService.getMenuRepository().updateMenu("/findAllMenus", "001");
		
	}

}
