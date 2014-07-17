package com.klyserv.snipulti.models;

import org.junit.Assert;
import org.junit.Test;

public class SnippetTest {

	@Test
	public void test() {
		Snippet snipet = new Snippet(
				"snippet font_arial \"Some long description here\" b\nfont-family: Arial, \"Helvetica Neue\", Helvetica, sans-serif; \nand more\n  and some more \n  endsnippet  \n");
		Assert.assertEquals(snipet.getName(),"font_arial");
		Assert.assertEquals(snipet.getDescription(),"Some long description here");
		Assert.assertEquals(snipet.getSnippetText(),"font-family: Arial, \"Helvetica Neue\", Helvetica, sans-serif; \nand more\n  and some more \n" );
		
		snipet=new Snippet("snippet snip1\ntext here\nendsnippet");
		Assert.assertEquals("snip1", snipet.getName());
		Assert.assertEquals("", snipet.getDescription());
	}

}
