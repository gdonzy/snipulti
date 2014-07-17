package com.klyserv.snipulti.models;

import java.util.Collections;
import java.util.List;

public class SnippetFileList {
	private List<SnippetFile> snippetFile;
	
	public List<SnippetFile> getSnippetFile() {
		return Collections.unmodifiableList(snippetFile);
	}
}
