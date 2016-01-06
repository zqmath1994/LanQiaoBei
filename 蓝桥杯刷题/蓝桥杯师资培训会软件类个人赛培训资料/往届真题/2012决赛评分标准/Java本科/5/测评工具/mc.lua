
-- 已知索引，求第几行，第几列（0 based）
row = function (n)
	return math.floor((n-1)/4)
end

col = function (n)
	return (n-1)%4
end

-- 判断列向是否冲突
goodPlay1 = function(t,n)
	--向上搜索
	for i=n-4,1,-4 do
		if t[i]=='-' then break end
		if t[i]=='1' then return false end
	end
	
	--向下搜索
	for i=n+4,12,4 do
		if t[i]=='-' then break end
		if t[i]=='1' then return false end
	end
	
	return true
end

-- 判断行向是否冲突
goodPlay2 = function(t,n)
	--向左搜索
	for i=n-1,n-col(n),-1 do
		if t[i]=='1' then break end
		if t[i]=='-' then return false end
	end
	
	--向右搜索
	for i=n+1,n+3-col(n),1 do
		if t[i]=='1' then break end
		if t[i]=='-' then return false end
	end
	
	return true
end


-- 已知局面，求解法
-- 2 1 '-'
-- nil
ju = function (t)
	for i=1,12 do
		if t[i] == '0' then
			if goodPlay1(t,i) then
				t[i] = '1' --试放
				local r = ju(t)
				t[i] = '0' -- 恢复
				if not r then return row(i),col(i),'1' end 
			end
			if goodPlay2(t,i) then
				t[i] = '-' --试放
				local r = ju(t)
				t[i] = '0' -- 恢复
				if not r then return row(i),col(i),'-' end 
			end
		end
	end
     -- 找不到必胜的放法, return nil
end

myReadFile = function(filename)
	local f = io.open(filename)
	local t = {}
	for line in f:lines() do
		table.insert(t,line)
	end
	f:close()
	return t
end


fmt1 = function(t)
	local t2 = {}
	local n = tonumber(t[1])
	local ti = 2
	for i=1,n do
		t2[i] = t[ti] .. t[ti+1] .. t[ti+2]
		t2[i] = string.gsub(t2[i],"%s","")
		ti = ti + 3
	end
	
	local t3={}
	for i,v in ipairs(t2) do
		t3[i] = {}
		for k=1,#t2[i] do
			table.insert(t3[i],string.sub(t2[i],k,k))
		end
	end
	
	return t3
end

fmt2 = function(t)
	local t2 = {}
	for i,v in ipairs(t) do
		t2[i] = {}
		v = string.gsub(v, "%s", "")
		t2[i].r = tonumber(string.sub(v,1,1))
		t2[i].c = tonumber(string.sub(v,2,2))
		t2[i].v = string.sub(v,3,3)
		t2[i].v = string.gsub(t2[i].v,"_","-")
		t2[i].v = string.gsub(t2[i].v,"[!il|]","1")
	end
	return t2
end

fmt3 = function(t)
	local t2 = {}
	for i,v in ipairs(t) do
		v = string.gsub(v, "%s","")
		t2[i] = tonumber(v)
	end
	return t2
end

show1 = function(t)
	local s = "t:"
	for i,v in ipairs(t) do
		s = s .. v 
	end
	print(s)
end

judge = function(t, go, score)
	--show1(t)
	if go.v ~= '1' and go.v ~= '-' then return 0 end  -- 放置非法符号，违规！
	
	if go.r<0 or go.r>2 or go.c<0 or go.c>3 then return 0 end  ---位置违规！
	
	local n = go.r * 4 + go.c + 1
	if t[n] ~= '0' then return 0 end  --- 在已有位置放置，违规！
	
	if go.v=='1' and not goodPlay1(t,n) then return 0 end  --连通违规！
	if go.v=='-' and not goodPlay2(t,n) then return 0 end  --连通违规！
	
	t[n] = go.v
	--show1(t)
	local rt = ju(t)
	t[n] = '0'
	
	if rt == nil then  --- 对方认输，则我方正解！ 
		return score
	else
		return 0
	end
end

-------------------------------------------------
-------------------------------------------------

local t_in2 = fmt1(myReadFile("in.txt"))
local t_out = fmt2(myReadFile("out.txt"))
local t_score = fmt3(myReadFile("score.txt"))

--[=[
t1 = {'0','0','-','1','-','0','1','1','1','1','1','1'}
t2 = {'0','1','1','1','-','0','0','0','-','0','0','0'}
t3 = {'1','1','1','-','0','-','0','0','0','1','0','0'}
]=]

local sum = 0
for i,v in ipairs(t_in2) do
	local a = judge(v,t_out[i],t_score[i])
	print(a)
	sum = sum + a
end

print("总分= " .. sum)

