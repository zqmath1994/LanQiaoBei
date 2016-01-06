
local t_score={}
local t_out={}
local t_std={}

myread = function(t,filename)
local f = io.open(filename)
for line in f:lines() do
	table.insert(t,line)
end
f:close()
end


--从文件中读入：考生答案，标准答案，标准评分
myread(t_score,"score.txt")
myread(t_out,"out.txt")
myread(t_std,"std.txt")

-- 把t_std, t_score 做成键值map
t2_std = {}
for i, k in ipairs(t_std) do
	t2_std[k] = t_score[i]
end

--把t_out中的记录做成单值map（相当于set）
--期间要压缩掉不必要的空白
t2_out = {}
for i,v in ipairs(t_out) do
	v = string.gsub(v,"%s", "")  --清除空白
	t2_out[v] = 1  --“1” 其值没含义，只是个占位符
end

--开始计分
sum = 0
for k in pairs(t2_out) do
	local a = t2_std[k] or -2  --找到则记该分数，若错误扣 2 分
	print(k,a)
	sum = sum + a
end

print("总分=" .. sum)
