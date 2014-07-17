package com.klyserv.snipulti.models;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class SnippetFileTest {

	@Test
	public void test() throws IOException {
		File f=File.createTempFile("tempsnip", ".snip");
		PrintWriter pw=new PrintWriter(f);
		pw.println("snippet name1");
		pw.println("   some snippet here");
		pw.println("endsnippet");
		pw.println();
		pw.println("snippet name2");
		pw.println("   some other snippet here");
		pw.println("and more");
		pw.println("endsnippet");
		pw.println();
		pw.println("snippet name3");
		pw.println("   some other snippet here");
		pw.println("endsnippet");
		pw.println();
		pw.close();
		
		SnippetFile sf=new SnippetFile(f);

		Map<String, Snippet> mf=sf.getSnippets();
		Assert.assertEquals(3, mf.size());
		
		Assert.assertEquals(true, mf.containsKey("name1"));
		Assert.assertEquals("   some snippet here\n",mf.get("name1").getSnippetText());
		Assert.assertEquals("",mf.get("name1").getDescription());
	}

}
