package com.klyserv.snipulti.views;

import java.io.File;

import com.klyserv.snipulti.models.SnippetDirectory;
import com.klyserv.snipulti.models.SnippetFile;

public class SnippetDirectoryNode extends TreeParent {
	private SnippetDirectory snipDir;

	public SnippetDirectoryNode(File snipDir) {
		super(snipDir.getName());
		this.snipDir = new SnippetDirectory(snipDir);
		addFiles();
	}
	
	/* default */ void addFiles() {
		for(SnippetFile sf:snipDir.getSnippetFiles()) {
			addChild(new SnippetFileNode(sf));
		}
	}

}
