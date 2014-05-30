function fsbtfUfsnjobm(iiliicyliahio,iiliijjljjjjl,iiliijijeliji) 
io.write('[2J') 
end
function nbsl(y,y,iiliicixjjijj,iiliiiljciiim,iiliiiiplijjl,iiliilllmyizi) 
io.write(string.format('[%d;%dH*',y,y) ) 
end
UfsnTjaf={['w']=80,['h']=24}

function qmpu(g,iiliixjiixjij,iiliiicodiiji,iiliipijjjgig) 
fsbtfUfsnjobm(iiliioiilziil,iiliiidjcviii,iiliilvjjljij) for i=1,UfsnTjaf.w do
local y=(i/UfsnTjaf.w*2-1)
local y=(g(y) +1)/2*UfsnTjaf.h
nbsl(i,y,iiliiixijimll,iiliilaivljes,iiliirnljlcii,iiliijjililil) 
end
 io.read() 
end
qmpu(function (y) return math.sin(y*2*math.pi)   end ,iiliiljiltljl,iiliidjijlirl,iiliiiiiilijh) 