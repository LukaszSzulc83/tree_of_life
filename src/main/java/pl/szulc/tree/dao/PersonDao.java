package pl.szulc.tree.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.szulc.tree.entity.Person;


public interface PersonDao extends JpaRepository<Person, Serializable>, PersonDaoCustom{
	
}