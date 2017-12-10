package com.taiji.manager.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taiji.manager.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, String>,JpaSpecificationExecutor<Menu> {
	
	@Transactional
	@Modifying
	@Query("update Menu m set m.url=:url where m.id=:id")
	void updateMenu(@Param("url") String url,
					@Param("id") String id);
	
}
