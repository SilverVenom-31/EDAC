//Created by @AkhilD on 28/01/2021.
package com.app.pojos;

public class Candidate {
//id | name    | party    | votes
	private int id,votes;
	private String name,party;
	
	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public Candidate(int id, int votes, String name, String party) {
		super();
		this.id = id;
		this.votes = votes;
		this.name = name;
		this.party = party;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", votes=" + votes + ", name=" + name + ", party=" + party + "]";
	}
	
	
}
