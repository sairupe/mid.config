ngx.say("<br>已进入方法体<br>")


ngx.say("<br>get_uri_args<br>")
local headers = ngx.req.get_headers()
for k,v in pairs(headers) do
    ngx.say("[HEADER ] key:", k , "v", v)
end

ngx.say("<br>get_uri_args<br>")
local arg = ngx.req.get_uri_args()
for k,v in pairs(arg) do
    ngx.say("[GET ] key:", k , "v", v)
end

-- 重复K如何打印数组(LIST格式)
--ngx.say("<br>ngx.var.arg<br>")
--local var_arg = ngx.var.arg()
--for k,v in pairs(var_arg) do
--    ngx.say("[GET ] key:", k , "v", v)
--    ngx.say("<br>")
--end

ngx.say("<br>get_post_args<br>")
ngx.req.read_body()
local arg = ngx.req.get_post_args()
for k, v in pairs(arg) do
    ngx.say("[POST ] key:", k , "v", v)
end

ngx.say("<br>已结束方法体<br>")