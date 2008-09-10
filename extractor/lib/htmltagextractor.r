REBOL [
    Title: "HTML Tag Extractor"
    File:  %htmltagextractor.r
	Author: "Eduardo Fonseca Velasques"
    Date:  10-Sep-2008
    Purpose: "Separate the HTML tags from the body text of a document."
	Reference: http://www.reboltech.com/library/html/websplit.html
]
html-tag-extractor: func [text-html] [
	tags: make block! 100
	text: make string! 8000
	html-code: [
	    copy tag ["<" thru ">"] (append tags tag) | 
	    copy txt to "<" (append text txt)
	]
	parse text-html [to "<" some html-code]
	text
]