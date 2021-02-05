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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", votes=" + votes + ", name=" + name + ", party=" + party + "]";
	}
	
	
}
