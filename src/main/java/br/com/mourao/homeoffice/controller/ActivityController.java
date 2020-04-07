package br.com.mourao.homeoffice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
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

import br.com.mourao.homeoffice.model.Activity;
import br.com.mourao.homeoffice.model.User;
import br.com.mourao.homeoffice.repository.ActivityRepository;

@RestController
@RequestMapping("activity")
@CrossOrigin("*")
public class ActivityController {
	
	private @Autowired ActivityRepository repository;

	@GetMapping(produces=APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(
			@RequestParam(name="date", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			@RequestParam(name="user", required=false) Integer idUser,
			@RequestParam(name="page", required=false) Integer page,
			@RequestParam(name="size", required=false) Integer size
			) {
		
		if(page != null) {
			size = size == null ? 5 : size;
			
			Activity example = new Activity().setDate(date);
			
			if(idUser != null) {
				example.setUser(new User().setId(idUser));
			}
			
			return ResponseEntity.ok(this.repository.findAll(Example.of(example), PageRequest.of(page, size)));
		}
		
		return ResponseEntity.ok(this.repository.findAll());
	}
	
	@PostMapping(consumes=APPLICATION_JSON_VALUE)
	public ResponseEntity<Activity> post(@RequestBody Activity activity) {
		return ResponseEntity.ok(this.repository.save(activity));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Activity> delete(@PathVariable("id") Integer id) {
		this.repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
