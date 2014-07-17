package com.klyserv.snipulti.models;

public class Snippet {
	
	private String name;
	
	private String snippetText;
	
	public Snippet(String name, String snippString) {
		this.name=name;
		this.snippetText=snippString;
	}

	public String getName() {
		return name;
	}
	
	public String getSnippetText() {
		return snippetText;
	}

}
