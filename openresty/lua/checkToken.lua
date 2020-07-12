local redis = require "resty.redis"
local cjson = require"cjson"
local jwt = require "resty.jwt"

local red = redis:new()

red:set_timeouts(1000, 1000, 1000) -- 1 sec
red:connect("127.0.0.1", 6379)

-- 检查HEADER是否合法
local headers = ngx.req.get_headers()
local authorization = headers["Authorization"]
if authorization == nil then
    ngx.say('{"code":"400100", "data":"www.baidu.com", "msg":"非安全的会话", "success":"false"}')
    return
end
ngx.log(ngx.INFO, " authorization:", authorization)
local accessToken = string.gsub(authorization, "Bearer ", '', 1) --替换完似乎前面有个不知道什么符号不对
ngx.log(ngx.INFO, " accessToken:", accessToken)

-- 校验TOKEN是否合法
local secret = "SALT"
local jwt_obj = jwt:verify(secret, accessToken)
ngx.log(ngx.INFO, " jwt_obj.verified:", jwt_obj.verified)

if jwt_obj.verified == false then
    ngx.say('{"code":"400100", "data":"www.baidu.com", "msg":"不合法的TOKEN", "success":"false"}')
    return
end

-- REDIS获取TOKEN是否存在
local accessTokenKey = "sso:oidc:api:accessToken:access:"..accessToken
ngx.log(ngx.INFO, " accessTokenKey:", accessTokenKey)
local res,err = red:get(accessTokenKey)
ngx.log(ngx.INFO, " res:", res)
if res == ngx.null then
    ngx.say('{"code":"400100", "data":"www.baidu.com", "msg":"登录已失效", "success":"false"}')
    return
else
    -- TODO 分发到后端对应服务
    -- TODO 是否直接解析成明文TOKEN,后端服务不再解析  // 但是分发到后端服务后，是JWTSTORE原本解析了，不再读REDIS，似乎也没有必要省，后端暂时不改了
    ngx.req.set_header("token", accessToken)
end
red:set_keepalive(10000, 100)

