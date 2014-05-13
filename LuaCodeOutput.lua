function entry1(o)
N=(N+1)
local title=o.title or o.org or 'org'
fwrite('<HR><H3>') local href=''
if(o.url) then
href=string.format('HREF="%s"',o.url) 

end
fwrite('<ANAME="%d"%s>%s</A>',N,href,title) if(o.title and o.org) then
fwrite('<BR><SMALL><EM>%s</EM></SMALL>',o.org) 
end
fwrite('</H3>') if(o.description) then
fwrite('%s',string.gsub(o.description,'*','<P>') ) fwrite('<P>') 
end
if(o.email) then
fwrite('Contact:<AHREF="mailto:%s">%s</A>',o.email,o.contact or o.email) o.contact) then
fwrite('Contact:%s',o.contact) 
end

end
