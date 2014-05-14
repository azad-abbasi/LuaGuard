--
-- Ecco LUA extension
-- copy into luacmd.lua in the ecco directory
--
-- assign to the tool menu as a document
--
-- by Larry Yudelson, ads@yudel.com November 2007
--
--
--
function wordCount()
	fullText=" "
	NumberItems=get_select_items()
	MaxItems=table.maxn(NumberItems)

	msgbox(MaxItems .. " items selected","")
	for i=1,MaxItems do

		-- y=tostring(i)..", "..get_item_text(NumberItems[i]).."\n"

		thisText = get_item_text(NumberItems[i])
		fullText= thisText.." " ..fullText
	end -- next i

	len=string.len(fullText)

	-- count it with string.len(variable)

	wc=len/6
	msgbox("item has "..len.." chars and "..wc.." words!","")

	-- let's initalize the variables for this string

	wc=0 -- start with no words

	-- looks like we could do it with a REGEX

	for w in string.gmatch(fullText, "%a+") do
		wc=wc+1
	end -- next w
	msgbox(wc.." words found","ECCO WC")

end

--- end wordCount
