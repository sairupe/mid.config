local redis = require "resty.redis"
local cjson = require("cjson")

local red = redis:new()

red:set_timeouts(1000, 1000, 1000) -- 1 sec
red:connect("127.0.0.1", 6379)

local headers = ngx.req.get_headers()
local authorization = headers["Authorization"]
if authorization == nil then
    ngx.say('{"code":"400100", "data":"www.baidu.com", "msg":"非安全的会话", "success":"false"}')
    return
end
ngx.log(ngx.INFO, " authorization:", authorization)
local accessToken = string.gsub(authorization, "Bearer ", '', 1) --替换完似乎前面有个不知道什么符号不对
--local accessToken = string.sub(authorization,8,string.len(authorization))
ngx.log(ngx.INFO, " accessToken:", accessToken)

local accessTokenKey = "sso:oidc:api:accessToken:access:"..accessToken
ngx.log(ngx.INFO, " accessTokenKey:", accessTokenKey)
local res,err = red:get(accessTokenKey)
ngx.log(ngx.INFO, " res:", res)
if res == ngx.null then
    ngx.say('{"code":"400100", "data":"www.baidu.com", "msg":"登录已失效或无效的TOKEN", "success":"false"}')
    return
else
    -- TODO 分发到后端对应服务
    -- TODO 是否直接解析成明文TOKEN,后端服务不再解析
    ngx.say("TOKEN正确: ", res)
end
red:set_keepalive(10000, 100)

