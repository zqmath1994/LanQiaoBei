
--- 拉丁方块的评分程序

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
	local rt = {}
	for i,v in ipairs(t) do
		rt[i] = tonumber(v)
	end
	return rt
end

fmt2 = function(t)
	local r = {}
	local s = ""
	for i,v in ipairs(t) do
		v = string.gsub(v,"%s","")
		v = string.upper(v)
		if v=="" or string.find(v,"[^A-F]") then 
			if s ~= "" then r[s] = 1 end
			s = ""
		else
			s = s .. v
		end
	end
	if s ~= "" then r[s] = 1 end
	
	return r
end

f = function(ts, to, score)
	local x = 0
	for k in pairs(to) do
		if ts[k] then
			x = x + score
		else
			x = x - score
		end
	end
	
	if x < 0 then x = 0 end
	print(x)
	
	return x
end

-------------------------------------------------
-------------------------------------------------
local t_score = fmt1(myReadFile("score.txt"))
local t_std1 = fmt2(myReadFile("std1.txt"))
local t_std2 = fmt2(myReadFile("std2.txt"))
local t_std3 = fmt2(myReadFile("std3.txt"))
local t_std4 = fmt2(myReadFile("std4.txt"))
local t_out1 = fmt2(myReadFile("out1.txt"))
local t_out2 = fmt2(myReadFile("out2.txt"))
local t_out3 = fmt2(myReadFile("out3.txt"))
local t_out4 = fmt2(myReadFile("out4.txt"))

local sum = 0
sum = sum + f(t_std1, t_out1, t_score[1])
sum = sum + f(t_std2, t_out2, t_score[2])
sum = sum + f(t_std3, t_out3, t_score[3])
sum = sum + f(t_std4, t_out4, t_score[4])

print("总分= " .. sum)
