package br.com.mesaquebatista.verbify.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "verbs")
public class Verb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String verb;
	private String infinitive;
	private String simplePast;
	private String pastParticiple;

	public Verb() {
	}

	public Verb(Long id, String verb, String infinitive, String simplePast, String pastParticiple) {
		super();
		this.id = id;
		this.verb = verb;
		this.infinitive = infinitive;
		this.simplePast = simplePast;
		this.pastParticiple = pastParticiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getInfinitive() {
		return infinitive;
	}

	public void setInfinitive(String infinitive) {
		this.infinitive = infinitive;
	}

	public String getSimplePast() {
		return simplePast;
	}

	public void setSimplePast(String simplePast) {
		this.simplePast = simplePast;
	}

	public String getPastParticiple() {
		return pastParticiple;
	}

	public void setPastParticiple(String pastParticiple) {
		this.pastParticiple = pastParticiple;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Verb other = (Verb) obj;
		return Objects.equals(id, other.id);
	}

}
