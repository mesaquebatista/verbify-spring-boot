package br.com.mesaquebatista.verbify.resources;

import java.util.List;

import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesaquebatista.verbify.constants.Messages;
import br.com.mesaquebatista.verbify.entities.Verb;
import br.com.mesaquebatista.verbify.exceptions.DataNotFoundException;
import br.com.mesaquebatista.verbify.responses.ResponseHandler;
import br.com.mesaquebatista.verbify.services.VerbService;

@RestController
@RequestMapping("/verbs")
public class VerbResource {

	@Autowired
	private VerbService verbService;

	@GetMapping("")
	public ResponseEntity<Object> getAll(@RequestParam(name = "page", defaultValue = "0") int page) {
		try {
			Page<Verb> verbPage = verbService.findAll(page, 500);
			List<Verb> verbs = verbPage.getContent();

			return ResponseHandler.generateResponse(Messages.HTTP_GET_RESPONSE_SUCCESS, HttpStatus.OK, verbs);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{verb}")
	public ResponseEntity<Object> getAll(@PathVariable String verb) {
		try {
			Verb verbResponse = verbService.findFirstByVerbOrInfinitiveOrSimplePastOrPastParticiple(verb, verb, verb,
					verb);

			if (verbResponse == null)
				throw new DataNotFoundException("Data not founded", HttpStatus.NOT_FOUND);

			return ResponseHandler.generateResponse(Messages.HTTP_GET_RESPONSE_SUCCESS, HttpStatus.OK, verbResponse);
		} catch (DataNotFoundException dataNotFoundException) {
			return ResponseHandler.generateResponse(dataNotFoundException.getMessage(),
					dataNotFoundException.getHttpCode(), null);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
