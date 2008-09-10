REBOL [
	Title: "UTF TO ANSI"
	Version: 1.0
	File:  %utf2ansi.r
	Author: "Eduardo Fonseca Velasques"
	Date:  10-Sep-2008
	Purpose: "Convert contents in UTF to ANSI."
]
utf2ansi: func [text] [
	baseText: copy text
	finalText: ""
	lastByte1: #{00}
	lastByte2: #{00}
	lastByte3: #{00}
	while [true] [
		either (length? baseText) >= 1 [
			char: tempText: copy/part at baseText 0 1
			lastByte1: lastByte2
			lastByte2: lastByte3
			lastByte3: to-binary char
			either (to-integer lastByte1) = 194 [
				append finalText (to-char (128 + ((256 - (to-integer lastByte2)) - 128)))
				lastByte1: #{00}
				lastByte2: #{00}
				lastByte3: #{00}
			] [
				either (to-integer lastByte1) = 195 [
					append finalText (to-char (192 + (128 - (256 - (to-integer lastByte2)))))
					lastByte1: #{00}
					lastByte2: #{00}
					lastByte3: #{00}
				] [
					if lastByte1 <> #{00} [
						finalText: append (copy finalText) lastByte1
					]
					baseText: copy/part at baseText 2 ((length? baseText) - 1)
				]
			]
		] [
			if lastByte2 <> #{00} [
				finalText: append (copy finalText) lastByte2
			]
			if lastByte3 <> #{00} [
				finalText: append (copy finalText) lastByte3
			]
			break
		]
	]
	finalText
]