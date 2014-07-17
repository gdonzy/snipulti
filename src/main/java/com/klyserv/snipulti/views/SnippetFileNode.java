package com.klyserv.snipulti.views;

import java.io.File;
import java.util.Map;

import com.klyserv.snipulti.models.Snippet;
import com.klyserv.snipulti.models.SnippetFile;

public class SnippetFileNode extends TreeParent {
	private File snipFile;
	
	public SnippetFileNode(File file) {
		super(file.getName());
		this.snipFile=file;
		loadFile();
	}
	
	public SnippetFileNode(SnippetFile sf) {
		this(sf.getFile());
	}
	
	public File getFile() {
		return snipFile;
	}

	/* default */ void loadFile() {
		SnippetFile sf=new SnippetFile(snipFile);
		Map<String, Snippet> snipList=sf.getSnippets();
		for(Snippet s:snipList.values()) {
			addChild(new SnippetObject(s));
		}
	}
}
