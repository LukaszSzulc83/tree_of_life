package pl.szulc.tree.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.szulc.tree.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Serializable>, PersonRepositoryCustom {
	
}