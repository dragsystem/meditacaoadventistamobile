REBOL [
	Title: "Substr"
	Version: 1.0
	File:  %substr.r
	Author: "Eduardo Fonseca Velasques"
	Date:  10-Sep-2008
	Purpose: "Substring."
	Reference: http://www.rebol.com/faq.html#040
]
substr: func [string start length][
	copy/part at string start length
]