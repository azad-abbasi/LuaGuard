function DataExtract()
	NumberItems=get_select_items()
	MaxItems=table.maxn(NumberItems)
	msgbox(MaxItems .. " items selected","")
	if MaxItems >0 then
		filename="c:\\test.txt"
		io.output(filename, "w+")
		for i=1,MaxItems do
			y=tostring(i)..", "..get_item_text(NumberItems[i]).."\n"
			msgbox(y,"")
			io.write(y)
		end
		io.close()
	else
		msgbox("no selected items","")
	end
end