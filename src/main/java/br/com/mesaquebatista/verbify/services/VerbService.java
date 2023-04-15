package br.com.mesaquebatista.verbify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mesaquebatista.verbify.entities.Verb;
import br.com.mesaquebatista.verbify.repositories.VerbRepository;

@Service
public class VerbService {
	
	@Autowired
	private VerbRepository repository;
	
	public Page<Verb> findAll(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAllByOrderByVerbAsc(pageable);
	}
	
	public Verb findFirstByVerbOrInfinitiveOrSimplePastOrPastParticiple(String verb, String infinitive, String simplePast, String pastParticiple) {
		return repository.findFirstByVerbOrInfinitiveOrSimplePastOrPastParticiple(verb, infinitive, simplePast, pastParticiple);
	}

}
