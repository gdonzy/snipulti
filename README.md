# Intro

This Eclipse plugin uses simple text files to store code snippets. Currently it looks for snippets in `${HOME}/snips` and lists all the files and snippets in that directory. This is very useful if you like to store all your snippets in a human editable text file like me.

Name was inspired by UltiSnips. Even tough this is no way as powerful as UltiSnips is, I hope to add most of the features of Ultisnips in this one.

# Sample snippet:

    snippet font_arial ""
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    endsnippet

    snippet font_arial_black ""
    font-family: "Arial Black", "Arial Bold", Gadget, sans-serif;
    endsnippet

# Features: 

* Store and manage snippets in a human editable text file.
* Edit snippets file directly by clicking edit from context menu.

# More features coming soon:

* Customize location of snippets folder.
* Dynamic reload of snippets.
* Allow editable parameters in snippets. 
