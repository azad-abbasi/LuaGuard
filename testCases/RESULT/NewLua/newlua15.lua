function wordCount() 
fullText=''
NumberItems=get_select_items() 
MaxItems=table.maxn(NumberItems) 
msgbox(MaxItems..'itemsselected','') for i=1,MaxItems do
thisText=get_item_text(NumberItems[i]) 
fullText=thisText..''..fullText

end
 len=string.len(fullText) 
wc=len/6
msgbox('itemhas'..len..'charsand'..wc..'words!','') wc=0
for w in string.gmatch(fullText,'%a+') do
wc=(wc+1)

end
msgbox(wc..'wordsfound','ECCOWC') 
end
