local redis = require "resty.redis"
local red = redis:new()

red:set_timeouts(1000, 1000, 1000) -- 1 sec
red:connect("127.0.0.1", 6379)

local res,err = red:get("dog")
if res == ngx.null then
    ngx.say("dog not found.")
    return
else
    ngx.say("dog: ", res)
end
red:set_keepalive(10000, 100)

