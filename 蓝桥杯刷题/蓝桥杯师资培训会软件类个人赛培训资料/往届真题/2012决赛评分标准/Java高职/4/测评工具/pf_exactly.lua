
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

myread(t_score,"score.txt")
myread(t_out,"out.txt")
myread(t_std,"std.txt")

local sum = 0
for i,v in ipairs(t_out) do
  local v2 = string.gsub(v,"^%s+","")
  v2 = string.gsub(v2,"%s+$","")
  
  local a = 0
  if v2==t_std[i] then a = t_score[i] end  
  print(v, t_std[i], a)
  sum = sum + a
end

print("\n×Ü·Ö="..sum)



