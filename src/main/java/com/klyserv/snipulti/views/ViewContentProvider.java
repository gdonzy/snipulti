package com.klyserv.snipulti.views;

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
		SnippetObject to1 = new SnippetObject("Leaf 1");
		SnippetObject to2 = new SnippetObject("Leaf 2");
		SnippetObject to3 = new SnippetObject("Leaf 3");
		SnippetFileNode p1 = new SnippetFileNode("Parent 1");
		p1.addChild(to1);
		p1.addChild(to2);
		p1.addChild(to3);

		SnippetObject to4 = new SnippetObject("Leaf 4");
		SnippetFileNode p2 = new SnippetFileNode("Parent 2");
		p2.addChild(to4);

		SnippetFileListNode root = new SnippetFileListNode("Root");
		root.addChild(p1);
		root.addChild(p2);

		invisibleRoot = new SnippetFileSuperListNode("");
		invisibleRoot.addChild(root);
	}
}
