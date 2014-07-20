package com.klyserv.snipulti.models;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class SnippetDirectory {
	private File snipDir;
	
	public SnippetDirectory(File snipDir) {
		this.snipDir=snipDir;
	}

	public List<SnippetFile> getSnippetFiles() {
		List<SnippetFile> lsf=new ArrayList<SnippetFile>();
		for(File f:snipDir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".snippets");
			}
		})) {
			if(f.isFile()) {
				lsf.add(new SnippetFile(f));
			}
		}
		return lsf;
	}
}
