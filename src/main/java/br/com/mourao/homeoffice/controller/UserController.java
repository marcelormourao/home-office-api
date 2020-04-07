package br.com.mourao.homeoffice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mourao.homeoffice.model.User;
import br.com.mourao.homeoffice.repository.UserRepository;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {
	
	private @Autowired UserRepository repository;

	@GetMapping(produces=APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(
		@RequestParam(name="page", required=false) Integer page,
		@RequestParam(name="size", required=false) Integer size
	) {
		
		if(page != null) {
			size = size == null ? 5 : size;
			
			return ResponseEntity.ok(this.repository.findAllByOrderByNome(PageRequest.of(page, size)));
		}
		
		return ResponseEntity.ok(this.repository.findAllByOrderByNome());
	}
	
	@PostMapping(consumes=APPLICATION_JSON_VALUE)
	public ResponseEntity<User> post(@RequestBody User User) {
		return ResponseEntity.ok(this.repository.save(User));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<User> delete(@PathVariable("id") Integer id) {
		this.repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
