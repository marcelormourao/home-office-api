package br.com.mourao.homeoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mourao.homeoffice.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{

}
