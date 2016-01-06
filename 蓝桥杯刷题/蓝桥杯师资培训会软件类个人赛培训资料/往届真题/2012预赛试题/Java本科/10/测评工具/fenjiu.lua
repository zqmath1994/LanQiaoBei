
pourinto = function(a,b,full)
	if a <= 0 then return a,b end
	if b >= full then return a,b end
	
	if full-b > a then
		return 0,b+a
	else
		return a-(full-b),full
	end
end

goodstep = function(xx,yy,zz,x1,y1,z1,x2,y2,z2)
	local a,b = pourinto(x1,y1,yy)
	if a==x2 and b==y2 and z1==z2 then return 1 end
	
	a,b = pourinto(x1,z1,zz)
	if a==x2 and y1==y2 and b==z2 then return 1 end
	
	a,b = pourinto(y1,x1,xx)
	if b==x2 and a==y2 and z1==z2 then return 1 end
	
	a,b = pourinto(y1,z1,zz)
	if x1==x2 and a==y2 and b==z2 then return 1 end
	
	a,b = pourinto(z1,x1,xx)
	if b==x2 and y1==y2 and a==z2 then return 1 end
	
	a,b = pourinto(z1,y1,yy)
	if x1==x2 and b==y2 and a==z2 then return 1 end
end


ping = function(fin, fout)
	local f = io.open(fin)
	local s = f:read()
	if s==nil then return 0 end
	
	local _,_,sxx,syy,szz,sx0,sy0,sz0,sgoal 
		= string.find(s,"(%d+),(%d+),(%d+),(%d+),(%d+),(%d+),(%d+)")
	io.close(f)
	
	local xx,yy,zz = tonumber(sxx), tonumber(syy), tonumber(szz)
	local x0,y0,z0 = tonumber(sx0), tonumber(sy0), tonumber(sz0)
	local goal = tonumber(sgoal)
	
	
	for line in io.lines(fout) do
		local _,_,s1,s2,s3 = string.find(line, "(%d+)%s*,%s*(%d+)%s*,%s*(%d+)%s*")
		local x,y,z = tonumber(s1),tonumber(s2),tonumber(s3)
		
		if x==nil or y==nil or z==nil then return 0 end
		
		if goodstep(xx,yy,zz,x0,y0,z0,x,y,z) == nil then return 0 end
		x0,y0,z0 = x,y,z
	end
	
	if x0==goal or y0==goal or z0==goal then return 7 end
	
	return 0
end

t = {
	ping("in1.txt", "out1.txt"),
	ping("in2.txt", "out2.txt"),
	ping("in3.txt", "out3.txt"),
	ping("in4.txt", "out4.txt")
	}
	
print(t[1])
print(t[2])
print(t[3])
print(t[4])
print("×Ü·Ö=" .. (t[1]+t[2]+t[3]+t[4]))
