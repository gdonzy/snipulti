package com.klyserv.snipulti.views;

import java.io.File;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

class ViewContentProvider implements IStructuredContentProvider,
		ITreeContentProvider {
	private SnippetFileSuperListNode invisibleRoot;
	private SnipultiView sv;

	public ViewContentProvider(SnipultiView snipultiView) {
		this.sv=snipultiView;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		if (parent.equals(sv.getViewSite())) {
			if (invisibleRoot == null)
				initialize();
			return getChildren(invisibleRoot);
		}
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		if (child instanceof SnippetObject) {
			return ((SnippetObject) child).getParent();
		}
		return null;
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof TreeParent) {
			return ((TreeParent) parent).getChildren();
		}
		return new Object[0];
	}

	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeParent)
			return ((TreeParent) parent).hasChildren();
		return false;
	}

	/*
	 * We will set up a dummy model to initialize tree heararchy. In a real
	 * code, you will connect to a real model and expose its hierarchy.
	 */
	private void initialize() {
		SnippetFileNode p1 = new SnippetFileNode(new File("/tmp/a.txt"));

		SnippetFileNode p2 = new SnippetFileNode(new File("/tmp/b.txt"));

		SnippetFileListNode root = new SnippetFileListNode("Root");
		root.addChild(p1);
		root.addChild(p2);

		invisibleRoot = new SnippetFileSuperListNode("");
		invisibleRoot.addChild(root);
	}
}
