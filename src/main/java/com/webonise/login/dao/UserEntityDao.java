package com.webonise.login.dao;

import com.webonise.login.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long> {
	
//	 solution 1
	@Query("from UserEntity where loginId=:loginId and password=:password group by loginId,password")
    UserEntity findByLoginIdAndPassword(@Param("loginId") String loginId,@Param("password") String password);
	
//	 solution 2
//		List<UserEntity> findByLoginIdAndPassword(String loginId, String password);
}
