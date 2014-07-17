package com.klyserv.snipulti.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

class ViewLabelProvider extends LabelProvider {

	public String getText(Object obj) {
		return obj.toString();
	}
	public Image getImage(Object obj) {
		String imageKey;
		if (obj instanceof SnippetFileNode) 
			imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		else if (obj instanceof TreeParent)
		   imageKey = ISharedImages.IMG_OBJ_FOLDER;
		else 
           imageKey = ISharedImages.IMG_OBJ_ADD;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}
