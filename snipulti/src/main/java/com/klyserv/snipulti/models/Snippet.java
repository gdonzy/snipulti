package com.klyserv.snipulti.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Snippet {
	
	private String name;
	
	private String description;
	
	private String snippetText;
	
	private String fullText;
	
	public static final String REGULAREXP="(snippet\\s+(\\S+)(\\s+\"([^\"]*)\"[^\n]*?)?\n((.*?\n)*?)\\s*endsnippet\\s*)";
	
	private static Pattern matchPattern;
	
	static {
		try {
			matchPattern=Pattern.compile(REGULAREXP, Pattern.MULTILINE);
		} catch(Throwable t) {
			matchPattern=null;
		}
	}
	
	public Snippet(String snippString) {
		this.fullText=snippString;
		parse();
	}

	public String getName() {
		return name;
	}
	
	private void parse() {
		Matcher m=matchPattern.matcher(fullText);
		if(m.find()) {
			this.name=m.group(2);
			this.description=m.group(4);
			this.snippetText=m.group(5);
		}
	}
	
	public String getSnippetText() {
		return snippetText;
	}
	
	public String getFullText() {
		return fullText;
	}

	public Object getDescription() {
		return description==null?"":description;
	}

}
