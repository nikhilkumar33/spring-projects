package com.user.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.scheduling.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	
	@Query(value = "SELECT * FROM user " + "WHERE DAY(dob) = DAY(CURDATE()) "
			+ "AND MONTH(dob) = MONTH(CURDATE())", nativeQuery = true)
	List<UserEntity> findTodayBirthdays();

}
