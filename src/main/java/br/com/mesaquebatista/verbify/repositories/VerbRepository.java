package br.com.mesaquebatista.verbify.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesaquebatista.verbify.entities.Verb;

public interface VerbRepository extends JpaRepository<Verb, Long> {
	Verb findFirstByVerbOrInfinitiveOrSimplePastOrPastParticiple(String verb, String infinitve, String simplePast, String pastParticiple);
	Page<Verb> findAllByOrderByVerbAsc(Pageable page);
}
