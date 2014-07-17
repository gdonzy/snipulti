package com.klyserv.snipulti.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SnippetDirectory {
	private File snipDir;
	
	public SnippetDirectory(File snipDir) {
		this.snipDir=snipDir;
	}

	public List<SnippetFile> getSnippetFiles() {
		List<SnippetFile> lsf=new ArrayList<SnippetFile>();
		for(File f:snipDir.listFiles()) {
			if(f.isFile()) {
				lsf.add(new SnippetFile(f));
			}
		}
		return lsf;
	}
}
