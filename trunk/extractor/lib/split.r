REBOL [
	Title: "Split"
	Version: 1.0
	File:  %split.r
	Author: "Eduardo Fonseca Velasques"
	Date:  10-Sep-2008
	Purpose: "Split."
	Reference: http://snippets.dzone.com/posts/show/1108
]
; Gabriele's, with Andreas's ANY mod.
split: func [string delim /local result data] [
	result: copy []
	parse/all string [
		; The ANY bit ensures we don't insert NONE values.
		any [copy data to delim (insert tail result any [data copy ""]) delim]
		copy data to end (insert tail result any [data copy ""])
	]
	result
]