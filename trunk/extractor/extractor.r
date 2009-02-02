REBOL [
	Title: "Meditação Adventista Mobile - Extractor"
	Version: 1.0
	File:  %extractor.r
	Date:  10-Sep-2008
	Author: "Eduardo Fonseca Velasques"
	Purpose: "Converter automáticamente o conteúdo do site oficial para a Meditação Mobile"
]

do load-thru http://irebol.googlecode.com/files/split.r
do load-thru http://irebol.googlecode.com/files/substr.r
do load-thru http://irebol.googlecode.com/files/htmlchars.r
do load-thru http://irebol.googlecode.com/files/htmltagextractor.r
do load-thru http://irebol.googlecode.com/files/utf2ansi.r

extractor: func [year month url] [
	fullContent: read (to-url url) 'latin-1
	fullContentStart: either error? try [(index? find fullContent "<body>") + 6] [
			(index? find fullContent {<body bgcolor="#FFFFFF">}) + 24
		] [
			(index? find fullContent "<body>") + 6
		]
	fullContentEnd: (index? find fullContent "</body>") - fullContentStart
	fullContent: substr fullContent fullContentStart fullContentEnd
	contents: split fullContent (rejoin [newline "<hr />" newline])
	count: 0
	for countContents 1 ((length? contents) - 1) 1 [
		content: pick contents countContents
		count: count + 1
		content: replace content (substr content (index? find content "<a name") ((index? find content "</a>") - (index? find content "<a name") + 4)) ""
		content: html-tag-extractor content
		content: html-chars-decode content
		content: trim content
		content: replace/all content "  " " "
		content: replace/all content (rejoin [newline newline]) newline
		if (trim content) = "" [
			break
		]
		lines: split content newline
		content: ""
		day: "00"
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
			if countLines = 1 [
				day: substr line 0 (index? find line " ")
				day: trim day
				if (to-integer day) < 10 [
					day: rejoin ["0" day]
				]
				contentTagStart: "<d>"
				contentTagEnd: "</d>"
			]
			if countLines = 2 [
				contentTagStart: "<t>"
				contentTagEnd: "</t>"
			]
			if countLines = 4 [
				contentTagStart: "<v>"
				contentTagEnd: "</v>"
			]
			if countLines = 6 [
				content: rejoin [content "<c>" newline]
			]
			if (countLines <> 3) and (countLines <> 5) [
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
		write (to-file (rejoin ["build/" filename])) (utf2ansi content)
	]
]

view layout [
	backcolor white
	
	box 150x138 http://meditacaoadventistamobile.googlecode.com/svn/trunk/logo.jpg
	
	h2 black "Meditacao Adventista Mobile - Extractor"
	
	text "meditacaoadventistamobile.googlecode.com"
	
	text bold black "Mês"
	
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
		if (to-integer month) < 10 [
			month: rejoin ["0" (to-integer month)]
		]
		make-dir %build
		extractor year month (rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmat/" year "/md0110" month year ".html"])
		extractor year month (rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmat/" year "/md1120" month year ".html"])
		if error? try [
			extractor year month (rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmat/" year "/md2131" month year ".html"])
		] [
			if error? try [
				extractor year month (rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmat/" year "/md2130" month year ".html"])
			] [
				if error? try [
					extractor year month (rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmat/" year "/md2129" month year ".html"])
				] [
					extractor year month (rejoin ["http://www.cpb.com.br/htdocs/periodicos/medmat/" year "/md2128" month year ".html"])
				]
			]
		]
		browse/only %build
	]
	
	text bold black "Ficheiros Gerados"
	
	results: text-list 300x100
]