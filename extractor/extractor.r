REBOL [
	Title: "Medita��o Adventista Mobile - Extractor"
	Version: 1.0
	File:  %extractor.r
	Date:  10-Sep-2008
	Author: "Eduardo Fonseca Velasques"
	Purpose: "Converter autom�ticamente o conte�do do site oficial para a Medita��o Mobile"
]

do load-thru http://irebol.googlecode.com/files/split.r
do load-thru http://irebol.googlecode.com/files/substr.r
do load-thru http://irebol.googlecode.com/files/htmlchars.r
do load-thru http://irebol.googlecode.com/files/htmltagextractor.r
do load-thru http://irebol.googlecode.com/files/utf2ansi.r

extractor: func [edition folder year month url] [
	fullContent: read (to-url url) 'latin-1
	fullContentStart: (index? find fullContent {<div id="conteudo">}) + 19
	either not none? (find fullContent {<p style="font-size: 18px">&nbsp;</p>}) [
		fullContentEnd: (index? find fullContent {<p style="font-size: 18px">&nbsp;</p>}) - fullContentStart
	] [
		fullContentEnd: (index? find fullContent {<div class="clear"></div>}) - fullContentStart
	]
	fullContent: substr fullContent fullContentStart fullContentEnd
	either not none? (find fullContent {<hr width="735" />}) [
		contents: split fullContent {<hr width="735" />}
	] [
		contents: split fullContent {<hr width="730" />}
	]
	count: 0
	tituloLineNumber: 2
	versoLineNumber: 3
	contentLineNumber: 4
	if edition = "mulher" [
		tituloLineNumber: 2
		versoLineNumber: 3
		contentLineNumber: 4
	]
	if edition = "juvenil" [
		tituloLineNumber: 2
		versoLineNumber: 3
		contentLineNumber: 4
	]
	for countContents 1 (length? contents) 1 [
		content: pick contents countContents
		count: count + 1
		content: replace/all content newline ""
		content: replace/all content "</p>" rejoin["</p>" newline]
		content: replace/all content "</h2>" rejoin["</h2>" newline]
		if (trim content) = "" [
			break
		]
		if none? (find content "</a>") [
			break
		]
		content: replace content (substr content (index? find content "<a name") ((index? find content "</a>") - (index? find content "<a name") + 4)) ""
		content: html-tag-extractor content
		content: html-chars-decode content
		content: trim content
		content: replace/all content "   " " "
		content: replace/all content "  " " "
		content: replace/all content (rejoin [newline newline]) newline
		if (trim content) = "" [
			break
		]
		lines: split content newline
		content: ""
		day: "00"
		bugLine: 0
		for countLines 1 (length? lines) 1 [
			contentTagStart: ""
			contentTagEnd: ""
			tempLine: ""
			tempLine: pick lines countLines
			line: ""
			lastByte1: #{00}
			lastByte2: #{00}
			lastByte3: #{00}
			while [1 = 1] [
				if (length? tempLine) >= 1 [
					char: substr tempLine 0 1
					lastByte1: lastByte2
					lastByte2: lastByte3
					lastByte3: to-binary char
					; print (rejoin [char " - " (to-binary char)])
					either (lastByte1 = #{C2}) and (lastByte2 = #{B0}) [
						lastByte1: #{00}
						lastByte2: #{00}
					] [
						either (lastByte1 = #{C2}) and (lastByte2 = #{BA}) [
							lastByte1: #{00}
							lastByte2: #{00}
						] [
							either ((lastByte1 = #{E2}) and (lastByte2 = #{80}) and (lastByte3 = #{9C})) or ((lastByte1 = #{E2}) and (lastByte2 = #{80}) and (lastByte3 = #{9D})) [
								lastByte1: #{00}
								lastByte2: #{00}
								lastByte3: #{00}
								line: append (copy line) {"}
							] [
								either ((lastByte1 = #{E2}) and (lastByte2 = #{80}) and (lastByte3 = #{98})) or ((lastByte1 = #{E2}) and (lastByte2 = #{80}) and (lastByte3 = #{99})) [
									lastByte1: #{00}
									lastByte2: #{00}
									lastByte3: #{00}
									line: append (copy line) {'}
								] [
									either (lastByte1 = #{E2}) and (lastByte2 = #{80}) and (lastByte3 = #{93}) [
										lastByte1: #{00}
										lastByte2: #{00}
										lastByte3: #{00}
										line: append (copy line) {-}
									] [
										if lastByte1 <> #{00} [
											line: append (copy line) lastByte1
											lastByte1: #{00}
										]
									]
								]
							]
						]
					]
					tempLine: substr tempLine 2 ((length? tempLine) - 1)
				]
				if (length? tempLine) = 0 [
					break
				]
			]
			if lastByte2 <> #{00} [
				line: append (copy line) lastByte2
			]
			if lastByte3 <> #{00} [
				line: append (copy line) lastByte3
			]
			line: replace line "&nbsp;" ""
			line: replace line "&quot;" ""
			if countLines = (1 + bugLine) [
				if not none? (find line ", ") [
					line: substr line (index? find line ", ") + 2 (length? line)
				]
				day: substr line 0 (index? find line " ")
				day: trim day
				if error? try [
					if (to-integer day) < 10 [
						day: rejoin ["0" day]
					]
					content: ""
					contentTagStart: "<d>"
					contentTagEnd: "</d>"
				] [
					if error? try [
						day: substr line ((index? find line " ") + 1) (length? line)
						day: substr day 0 (index? find day " ")
						day: trim day
						if (to-integer day) < 10 [
							day: rejoin ["0" day]
						]
						content: ""
						contentTagStart: "<d>"
						contentTagEnd: "</d>"
					] [
						bugLine: bugline + 1
					]
				]
			]
			if countLines = (tituloLineNumber + bugLine) [
				contentTagStart: "<t>"
				contentTagEnd: "</t>"
			]
			if countLines = (versoLineNumber + bugLine) [
				contentTagStart: "<v>"
				contentTagEnd: "</v>"
			]
			if countLines = (contentLineNumber + bugLine) [
				content: rejoin [content "<c>" newline]
			]
			if line <> "" [
				content: rejoin [content contentTagStart line contentTagEnd newline]
			]
			if countLines = (length? lines) [
				content: rejoin [content "</c>"]
			]
		]
		filename: rejoin [year month day ".txt"]
		append results/data filename
		results/sld/redrag results/lc / max 1 length? head results/lines
		show results
		results/text: rejoin [results/text filename newline]
		write (to-file (rejoin [folder "/" filename])) (utf2ansi content)
	]
]

extractor_starter: func [edition code year month url] [
	if (to-integer month) < 10 [
		month: rejoin ["0" (to-integer month)]
	]
	folder: rejoin ["build/" edition "/" year]
	make-dir (to-file "build")
	make-dir (to-file (rejoin ["build/" edition]))
	make-dir (to-file (rejoin ["build/" edition "/" year]))
	extractor edition folder year month (rejoin [url year "/" code year ".html"])
;	if error? try [
;		extractor edition folder year month (rejoin [url year "/" code "0110" month year ".html"])
;	] [
;		extractor edition folder year month (rejoin [url year "/" code "0110" month year " .html"])
;	]
;	if error? try [
;		extractor edition folder year month (rejoin [url year "/" code "1120" month year ".html"])
;	] [
;		extractor edition folder year month (rejoin [url year "/" code "1120" month year " .html"])
;	]
;	if error? try [
;		extractor edition folder year month (rejoin [url year "/" code "2131" month year ".html"])
;	] [
;		if error? try [
;			extractor edition folder year month (rejoin [url year "/" code "2130" month year ".html"])
;		] [
;			if error? try [
;				extractor edition folder year month (rejoin [url year "/" code "2129" month year ".html"])
;			] [
;				extractor edition folder year month (rejoin [url year "/" code "2128" month year ".html"])
;			]
;		]
;	]
]

view layout [
	backcolor white
	
	box 150x138 http://meditacaoadventistamobile.googlecode.com/svn/trunk/logo.jpg
	
	h2 black "Meditacao Adventista Mobile - Extractor"
	
	text "meditacaoadventistamobile.googlecode.com"
	
	text bold black "M�s"
	
	inputMonth: field 50 (to-string now/month)
	
	text bold black "Ano"
	
	inputYear: field 100 (to-string now/year)
	
	style btn btn 130
	
	btn "Importar!" [
		clear results/data
		results/sld/redrag results/lc / max 1 length? head results/lines
		show results
		month: inputMonth/text
		year: inputYear/text
		extractor_starter "adulto" "frmd" year month "http://www.cpb.com.br/htdocs/periodicos/medmat/"
		extractor_starter "mulher" "frmmul" year month rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmulher/"]
		extractor_starter "juvenil" "frij" year month rejoin ["http://www.cpb.com.br/htdocs/periodicos/ij/"]
		browse/only %build
	]
	
	text bold black "Ficheiros Gerados"
	
	results: text-list 300x100
]
