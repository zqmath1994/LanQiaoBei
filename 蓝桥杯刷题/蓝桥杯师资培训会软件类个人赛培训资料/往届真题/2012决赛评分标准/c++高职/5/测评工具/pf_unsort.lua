
myread = function(t,filename)
local f = io.open(filename)
for line in f:lines() do
	table.insert(t,line)
end
f:close()
end

-- 矩阵变单行
myturn = function (t)
	local r = {}
	local ri = 1
	for _,v in ipairs(t) do
		--print (v)
		v = string.gsub(v,"%s", "")  --清除空白
		if v=="" then 
			if r[ri] then ri = ri + 1 end 
		else
			r[ri] = (r[ri] or "") .. v
		end
	end
	
	return r
end

---------------------------------------
---------------------------------------

t_score={}
t_out={}
t_std={}

--从文件中读入：考生答案，标准答案，标准评分
myread(t_score,"score.txt")
myread(t_out,"out.txt")
myread(t_std,"std.txt")

-- 把t_std, t_out 矩阵合并为单行
t_std2 = myturn(t_std)
t_out2 = myturn(t_out)

-- 把t_std2, t_score 做成键值map
map_std = {}
for i, k in ipairs(t_std2) do
	map_std[k] = t_score[i]
end

--把t_out2中的记录做成单值map（相当于set）
map_out = {}
for i,v in ipairs(t_out2) do
	v = string.gsub(v,"%s", "")  --清除空白
	--print (v)
	map_out[v] = 1  --“1” 其值没含义，只是个占位符
end

--开始计分
sum = 0
for k in pairs(map_out) do
	--print (k)
	local a = map_std[k] or -5  --找到则记该分数，若错误扣 5 分
	print(k,a)
	sum = sum + a
end

print("总分=" .. sum)
