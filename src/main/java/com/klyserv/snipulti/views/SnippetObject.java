package com.klyserv.snipulti.views;

import com.klyserv.snipulti.models.Snippet;

public class SnippetObject extends TreeObject {
	
	private Snippet snip;

	public SnippetObject(Snippet snip) {
		super(snip.getName());
		this.snip=snip;
	}
	
	public Snippet getSnippet() {
		return snip;
	}
	
}
