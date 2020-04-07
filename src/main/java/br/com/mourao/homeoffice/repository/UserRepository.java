package br.com.mourao.homeoffice.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mourao.homeoffice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public Page<User> findAllByOrderByNome(Pageable pageable);
	
	public Collection<User> findAllByOrderByNome();
}
