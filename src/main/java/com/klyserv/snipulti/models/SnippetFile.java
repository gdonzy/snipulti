package com.klyserv.snipulti.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnippetFile {

	private Map<String, Snippet> snippets;
	private File snipFile;
	
	static Pattern p;
	
	static {
		try {
           p=Pattern.compile(Snippet.REGULAREXP,Pattern.MULTILINE);
		} catch( Throwable e) {
		   p=null;	
		}
	}

	public SnippetFile(File snipFile) {
		this.snipFile = snipFile;
		Map<String, Snippet> m = new HashMap<String, Snippet>();
		snippets=m;
		try {
			String content="";
			try {
                @SuppressWarnings("resource")
                String content1 = (new Scanner(snipFile)).useDelimiter("\\Z").next();
                content=content1;
			} catch( NoSuchElementException ex) {
				// empty file ignore error
				return;
			}

			Matcher mx=p.matcher(content);
			while(mx.find()) {
				Snippet s=new Snippet(mx.group(1));
				m.put(s.getName(), s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Snippet> getSnippets() {
		return Collections.unmodifiableMap(snippets);
	}

	public String getName() {
		return snipFile.getName();
	}

	public File getFile() {
		return snipFile;
	}

}
