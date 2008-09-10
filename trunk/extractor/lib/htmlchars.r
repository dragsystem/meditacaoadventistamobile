REBOL [
	Title: "Html Characteres"
	Version: 1.0
	File:  %htmlchars.r
	Author: "Eduardo Fonseca Velasques"
	Date:  10-Sep-2008
	Purpose: "Encoder and decoder to HTML entities."
	Reference: http://www.w3schools.com/tags/ref_entities.asp
]

html-chars-table: [
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	;; ASCII Entities with Entity Names
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	; quotation mark
	[ {"} {&quot;} {&#34;} ]
	; apostrophe
	[ {'} {&apos;} {&#39} ]
	; ampersand
	[ {&} {&amp;} {&#38;} ]
	; less-than
	[ {<} {&lt;} {&#60;} ]
	; greater-than
	[ {>} {&gt;} {&#62;} ]
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	;; ISO 8859-1 Symbol Entities
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	; non-breaking space
	[ { } {&nbsp;} {&#160;} ]
	; inverted exclamation mark
	[ {�} {&iexcl;} {&#161;} ]
	; cent
	[ {�} {&cent;} {&#162;} ]
	; pound
	[ {�} {&pound;} {&#163;} ]
	; currency
	[ {�} {&curren;} {&#164;} ]
	; yen
	[ {�} {&yen;} {&#165;} ]
	; broken vertical bar
	[ {�} {&brvbar;} {&#166;} ]
	; section
	[ {�} {&sect;} {&#167;} ]
	; spacing diaeresis
	[ {�} {&uml;} {&#168;} ]
	; copyright
	[ {�} {&copy;} {&#169;} ]
	; feminine ordinal indicator
	[ {�} {&ordf;} {&#170;} ]
	; angle quotation mark (left)
	[ {�} {&laquo;} {&#171;} ]
	; negation
	[ {�} {&not;} {&#172;} ]
	; soft hyphen
	[ {�} {&shy;} {&#173;} ]
	; registered trademark
	[ {�} {&reg;} {&#174;} ]
	; spacing macron
	[ {�} {&macr;} {&#175;} ]
	; degree
	[ {�} {&deg;} {&#176;} ]
	; plus-or-minus
	[ {�} {&plusmn;} {&#177;} ]
	; superscript 2
	[ {�} {&sup2;} {&#178;} ]
	; superscript 3
	[ {�} {&sup3;} {&#179;} ]
	; spacing acute
	[ {�} {&acute;} {&#180;} ]
	; micro
	[ {�} {&micro;} {&#181;} ]
	; paragraph
	[ {�} {&para;} {&#182;} ]
	; middle dot
	[ {�} {&middot;} {&#183;} ]
	; spacing cedilla
	[ {�} {&cedil;} {&#184;} ]
	; superscript 1
	[ {�} {&sup1;} {&#185;} ]
	; masculine ordinal indicator
	[ {�} {&ordm;} {&#186;} ]
	; angle quotation mark (right)
	[ {�} {&raquo;} {&#187;} ]
	; fraction 1/4
	[ {�} {&frac14;} {&#188;} ]
	; fraction 1/2 
	[ {�} {&frac12;} {&#189;} ]
 	; fraction 3/4
	[ {�} {&frac34;} {&#190;} ]
	; inverted question mark
	[ {�} {&iquest;} {&#191;} ]
	; multiplication
	[ {�} {&times;} {&#215;} ]
	; division
	[ {�} {&divide;} {&#247;} ]
 	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	;; ISO 8859-1 Character Entities
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 	; capital a, grave accent
	[ {�} {&Agrave;} {&#192;} ]
	; capital a, acute accent
	[ {�} {&Aacute;} {&#193;} ]
	; capital a, circumflex accent
	[ {�} {&Acirc;} {&#194;} ]
	; capital a, tilde
	[ {�} {&Atilde;} {&#195;} ]
	; capital a, umlaut mark
	[ {�} {&Auml;} {&#196;} ]
	; capital a, ring
	[ {�} {&Aring;} {&#197;} ]
	; capital ae
	[ {�} {&AElig;} {&#198;} ]
	; capital c, cedilla
	[ {�} {&Ccedil;} {&#199;} ]
	; capital e, grave accent
	[ {�} {&Egrave;} {&#200;} ]
	; capital e, acute accent
	[ {�} {&Eacute;} {&#201;} ]
	; capital e, circumflex accent
	[ {�} {&Ecirc;} {&#202;} ]
	; capital e, umlaut mark
	[ {�} {&Euml;} {&#203;} ]
	; capital i, grave accent
	[ {�} {&Igrave;} {&#204;} ]
	; capital i, acute accent
	[ {�} {&Iacute;} {&#205;} ]
	; capital i, circumflex accent
	[ {�} {&Icirc;} {&#206;} ]
	; capital i, umlaut mark
	[ {�} {&Iuml;} {&#207;} ]
	; capital eth, Icelandic
	[ {�} {&ETH;} {&#208;} ]
	; capital n, tilde
	[ {�} {&Ntilde;} {&#209;} ]
	; capital o, grave accent
	[ {�} {&Ograve;} {&#210;} ]
	; capital o, acute accent
	[ {�} {&Oacute;} {&#211;} ]
	; capital o, circumflex accent
	[ {�} {&Ocirc;} {&#212;} ]
	; capital o, tilde
	[ {�} {&Otilde;} {&#213;} ]
	; capital o, umlaut mark
	[ {�} {&Ouml;} {&#214;} ]
	; capital o, slash
	[ {�} {&Oslash;} {&#216;} ]
	; capital u, grave accent
	[ {�} {&Ugrave;} {&#217;} ]
	; capital u, acute accent
	[ {�} {&Uacute;} {&#218;} ]
	; capital u, circumflex accent
	[ {�} {&Ucirc;} {&#219;} ]
	; capital u, umlaut mark
	[ {�} {&Uuml;} {&#220;} ]
	; capital y, acute accent
	[ {�} {&Yacute;} {&#221;} ]
	; capital THORN, Icelandic
	[ {�} {&THORN;} {&#222;} ]
	; small sharp s, German
	[ {�} {&szlig;} {&#223;} ]
	; small a, grave accent
	[ {�} {&agrave;} {&#224;} ]
	; small a, acute accent
	[ {�} {&aacute;} {&#225;} ]
	; small a, circumflex accent
	[ {�} {&acirc;} {&#226;} ]
	; small a, tilde
	[ {�} {&atilde;} {&#227;} ]
	; small a, umlaut mark
	[ {�} {&auml;} {&#228;} ]
	; small a, ring
	[ {�} {&aring;} {&#229;} ]
	; small ae
	[ {�} {&aelig;} {&#230;} ]
	; small c, cedilla
	[ {�} {&ccedil;} {&#231;} ]
	; small e, grave accent
	[ {�} {&egrave;} {&#232;} ]
	; small e, acute accent
	[ {�} {&eacute;} {&#233;} ]
	; small e, circumflex accent
	[ {�} {&ecirc;} {&#234;} ]
	; small e, umlaut mark
	[ {�} {&euml;} {&#235;} ]
	; small i, grave accent
	[ {�} {&igrave;} {&#236;} ]
	; small i, acute accent
	[ {�} {&iacute;} {&#237;} ]
	; small i, circumflex accent
	[ {�} {&icirc;} {&#238;} ]
	; small i, umlaut mark
	[ {�} {&iuml;} {&#239;} ]
	; small eth, Icelandic
	[ {�} {&eth;} {&#240;} ]
	; small n, tilde
	[ {�} {&ntilde;} {&#241;} ]
	; small o, grave accent
	[ {�} {&ograve;} {&#242;} ]
	; small o, acute accent
	[ {�} {&oacute;} {&#243;} ]
	; small o, circumflex accent
	[ {�} {&ocirc;} {&#244;} ]
	; small o, tilde
	[ {�} {&otilde;} {&#245;} ]
	; small o, umlaut mark
	[ {�} {&ouml;} {&#246;} ]
	; small o, slash
	[ {�} {&oslash;} {&#248;} ]
	; small u, grave accent
	[ {�} {&ugrave;} {&#249;} ]
	; small u, acute accent
	[ {�} {&uacute;} {&#250;} ]
	; small u, circumflex accent
	[ {�} {&ucirc;} {&#251;} ]
	; small u, umlaut mark
	[ {�} {&uuml;} {&#252;} ]
	; small y, acute accent
	[ {�} {&yacute;} {&#253;} ]
	; small thorn, Icelandic
	[ {�} {&thorn;} {&#254;} ]
	; small y, umlaut mark
	[ {�} {&yuml;} {&#255;} ]
]
html-chars-encode: func [text] [
	text: copy text
	foreach chars html-chars-table [
		text: replace/all text (pick chars 1) (pick chars 2)
	]
	text
]
html-chars-decode: func [text] [
	text: copy text
	foreach chars html-chars-table [
		text: replace/all text (pick chars 2) (pick chars 1)
		text: replace/all text (pick chars 3) (pick chars 1)
	]
	text
]