id=get_select_items()
max=table.maxn(id)
	for i=1,max do
		project=get_folder_value("Project",id[i])
		text=get_item_text(id[i])
		date=get_folder_value("Appointments",id[i])
		msgbox("Project "..project.."\n".."Item text "..text.."\n".."Date = "..date,"")
		if project~="" and string.sub(text,1,1)~="#" and date~="" then
			set_item_text(id[i],"#"..project.." "..text)
		end
		if project == "" and date~="" then
			msgbox("Item without project numbers","")
		end
end