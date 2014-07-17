package com.klyserv.snipulti.models;

import java.util.Collections;
import java.util.List;

public class SnippetFile {
	
	private List<Snippet> snippets;
	
	public List<Snippet> getSnippets() {
		return Collections.unmodifiableList(snippets);
	}

}
