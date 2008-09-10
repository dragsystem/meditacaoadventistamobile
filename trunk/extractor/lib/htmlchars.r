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
	[ {¡} {&iexcl;} {&#161;} ]
	; cent
	[ {¢} {&cent;} {&#162;} ]
	; pound
	[ {£} {&pound;} {&#163;} ]
	; currency
	[ {¤} {&curren;} {&#164;} ]
	; yen
	[ {¥} {&yen;} {&#165;} ]
	; broken vertical bar
	[ {¦} {&brvbar;} {&#166;} ]
	; section
	[ {§} {&sect;} {&#167;} ]
	; spacing diaeresis
	[ {¨} {&uml;} {&#168;} ]
	; copyright
	[ {©} {&copy;} {&#169;} ]
	; feminine ordinal indicator
	[ {ª} {&ordf;} {&#170;} ]
	; angle quotation mark (left)
	[ {«} {&laquo;} {&#171;} ]
	; negation
	[ {¬} {&not;} {&#172;} ]
	; soft hyphen
	[ {­} {&shy;} {&#173;} ]
	; registered trademark
	[ {®} {&reg;} {&#174;} ]
	; spacing macron
	[ {¯} {&macr;} {&#175;} ]
	; degree
	[ {°} {&deg;} {&#176;} ]
	; plus-or-minus
	[ {±} {&plusmn;} {&#177;} ]
	; superscript 2
	[ {²} {&sup2;} {&#178;} ]
	; superscript 3
	[ {³} {&sup3;} {&#179;} ]
	; spacing acute
	[ {´} {&acute;} {&#180;} ]
	; micro
	[ {µ} {&micro;} {&#181;} ]
	; paragraph
	[ {¶} {&para;} {&#182;} ]
	; middle dot
	[ {·} {&middot;} {&#183;} ]
	; spacing cedilla
	[ {¸} {&cedil;} {&#184;} ]
	; superscript 1
	[ {¹} {&sup1;} {&#185;} ]
	; masculine ordinal indicator
	[ {º} {&ordm;} {&#186;} ]
	; angle quotation mark (right)
	[ {»} {&raquo;} {&#187;} ]
	; fraction 1/4
	[ {¼} {&frac14;} {&#188;} ]
	; fraction 1/2 
	[ {½} {&frac12;} {&#189;} ]
 	; fraction 3/4
	[ {¾} {&frac34;} {&#190;} ]
	; inverted question mark
	[ {¿} {&iquest;} {&#191;} ]
	; multiplication
	[ {×} {&times;} {&#215;} ]
	; division
	[ {÷} {&divide;} {&#247;} ]
 	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	;; ISO 8859-1 Character Entities
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 	; capital a, grave accent
	[ {À} {&Agrave;} {&#192;} ]
	; capital a, acute accent
	[ {Á} {&Aacute;} {&#193;} ]
	; capital a, circumflex accent
	[ {Â} {&Acirc;} {&#194;} ]
	; capital a, tilde
	[ {Ã} {&Atilde;} {&#195;} ]
	; capital a, umlaut mark
	[ {Ä} {&Auml;} {&#196;} ]
	; capital a, ring
	[ {Å} {&Aring;} {&#197;} ]
	; capital ae
	[ {Æ} {&AElig;} {&#198;} ]
	; capital c, cedilla
	[ {Ç} {&Ccedil;} {&#199;} ]
	; capital e, grave accent
	[ {È} {&Egrave;} {&#200;} ]
	; capital e, acute accent
	[ {É} {&Eacute;} {&#201;} ]
	; capital e, circumflex accent
	[ {Ê} {&Ecirc;} {&#202;} ]
	; capital e, umlaut mark
	[ {Ë} {&Euml;} {&#203;} ]
	; capital i, grave accent
	[ {Ì} {&Igrave;} {&#204;} ]
	; capital i, acute accent
	[ {Í} {&Iacute;} {&#205;} ]
	; capital i, circumflex accent
	[ {Î} {&Icirc;} {&#206;} ]
	; capital i, umlaut mark
	[ {Ï} {&Iuml;} {&#207;} ]
	; capital eth, Icelandic
	[ {Ð} {&ETH;} {&#208;} ]
	; capital n, tilde
	[ {Ñ} {&Ntilde;} {&#209;} ]
	; capital o, grave accent
	[ {Ò} {&Ograve;} {&#210;} ]
	; capital o, acute accent
	[ {Ó} {&Oacute;} {&#211;} ]
	; capital o, circumflex accent
	[ {Ô} {&Ocirc;} {&#212;} ]
	; capital o, tilde
	[ {Õ} {&Otilde;} {&#213;} ]
	; capital o, umlaut mark
	[ {Ö} {&Ouml;} {&#214;} ]
	; capital o, slash
	[ {Ø} {&Oslash;} {&#216;} ]
	; capital u, grave accent
	[ {Ù} {&Ugrave;} {&#217;} ]
	; capital u, acute accent
	[ {Ú} {&Uacute;} {&#218;} ]
	; capital u, circumflex accent
	[ {Û} {&Ucirc;} {&#219;} ]
	; capital u, umlaut mark
	[ {Ü} {&Uuml;} {&#220;} ]
	; capital y, acute accent
	[ {Ý} {&Yacute;} {&#221;} ]
	; capital THORN, Icelandic
	[ {Þ} {&THORN;} {&#222;} ]
	; small sharp s, German
	[ {ß} {&szlig;} {&#223;} ]
	; small a, grave accent
	[ {à} {&agrave;} {&#224;} ]
	; small a, acute accent
	[ {á} {&aacute;} {&#225;} ]
	; small a, circumflex accent
	[ {â} {&acirc;} {&#226;} ]
	; small a, tilde
	[ {ã} {&atilde;} {&#227;} ]
	; small a, umlaut mark
	[ {ä} {&auml;} {&#228;} ]
	; small a, ring
	[ {å} {&aring;} {&#229;} ]
	; small ae
	[ {æ} {&aelig;} {&#230;} ]
	; small c, cedilla
	[ {ç} {&ccedil;} {&#231;} ]
	; small e, grave accent
	[ {è} {&egrave;} {&#232;} ]
	; small e, acute accent
	[ {é} {&eacute;} {&#233;} ]
	; small e, circumflex accent
	[ {ê} {&ecirc;} {&#234;} ]
	; small e, umlaut mark
	[ {ë} {&euml;} {&#235;} ]
	; small i, grave accent
	[ {ì} {&igrave;} {&#236;} ]
	; small i, acute accent
	[ {í} {&iacute;} {&#237;} ]
	; small i, circumflex accent
	[ {î} {&icirc;} {&#238;} ]
	; small i, umlaut mark
	[ {ï} {&iuml;} {&#239;} ]
	; small eth, Icelandic
	[ {ð} {&eth;} {&#240;} ]
	; small n, tilde
	[ {ñ} {&ntilde;} {&#241;} ]
	; small o, grave accent
	[ {ò} {&ograve;} {&#242;} ]
	; small o, acute accent
	[ {ó} {&oacute;} {&#243;} ]
	; small o, circumflex accent
	[ {ô} {&ocirc;} {&#244;} ]
	; small o, tilde
	[ {õ} {&otilde;} {&#245;} ]
	; small o, umlaut mark
	[ {ö} {&ouml;} {&#246;} ]
	; small o, slash
	[ {ø} {&oslash;} {&#248;} ]
	; small u, grave accent
	[ {ù} {&ugrave;} {&#249;} ]
	; small u, acute accent
	[ {ú} {&uacute;} {&#250;} ]
	; small u, circumflex accent
	[ {û} {&ucirc;} {&#251;} ]
	; small u, umlaut mark
	[ {ü} {&uuml;} {&#252;} ]
	; small y, acute accent
	[ {ý} {&yacute;} {&#253;} ]
	; small thorn, Icelandic
	[ {þ} {&thorn;} {&#254;} ]
	; small y, umlaut mark
	[ {ÿ} {&yuml;} {&#255;} ]
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