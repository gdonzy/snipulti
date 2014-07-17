package com.klyserv.snipulti.models;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnippetFile {
	
	private Map<String,Snippet> snippets;
	private File snipFile;
	
	public SnippetFile(File snipFile) {
		this.snipFile=snipFile;
		Map<String,Snippet> m=new HashMap<String, Snippet>();
		m.put("snip1", new Snippet("snip1", "snip text 1"));
		m.put("snip2", new Snippet("snip2", "snip text 2"));
		snippets=m;
	}

	public Map<String, Snippet> getSnippets() {
		return Collections.unmodifiableMap(snippets);
	}

}
