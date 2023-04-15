package br.com.mesaquebatista.verbify.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesaquebatista.verbify.entities.Verb;
import br.com.mesaquebatista.verbify.services.VerbService;

@RestController
@RequestMapping("/verbs")
public class VerbResource {
	
	@Autowired
	private VerbService verbService;
	
	@GetMapping("")
	public ResponseEntity<List<Verb>> getAll(@RequestParam(name = "page", defaultValue = "0") int page) {
		Page<Verb> verbPage = verbService.findAll(page, 500);
		List<Verb> verbs = verbPage.getContent();
		return ResponseEntity.ok().body(verbs);
	}
	
	@GetMapping("/{verb}")
	public ResponseEntity<Verb> getAll(@PathVariable String verb) {
		Verb verbResponse = verbService.findFirstByVerbOrInfinitiveOrSimplePastOrPastParticiple(verb, verb, verb, verb);
		return ResponseEntity.ok().body(verbResponse);
	}
	
}
