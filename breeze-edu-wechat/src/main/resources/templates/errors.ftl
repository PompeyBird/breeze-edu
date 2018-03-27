<!DOCTYPE html>
<html>

<head>
    ﻿<#include "common/meta.ftl" encoding="UTF-8">
    <title>出错了</title>

</head>

<body ontouchstart>

<div class="weui-msg">
    <div class="weui-msg__icon-area">
        <i class="weui-icon-warn weui-icon_msg"></i>
    </div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">操作失败</h2>
        <#--<p class="weui-msg__desc">抱歉：系统出了点小问题，请关闭公众号，并稍后重试-->
        <#--</p>-->
        <p class="weui-msg__desc">
            ﻿${msg!"抱歉：系统出了点小问题，请关闭公众号，并稍后重试"}
        </p>
    </div>
    <#--<div class="weui-msg__opr-area">-->
        <#--<p class="weui-btn-area">-->
            <#--<a href="javascript:;" class="weui-btn weui-btn_primary">推荐操作</a>-->
            <#--<a href="javascript:;" class="weui-btn weui-btn_default">辅助操作</a>-->
        <#--</p>-->
    <#--</div>-->
</div>
﻿<#include "common/footer.ftl" encoding="UTF-8">
﻿<#include "common/script.ftl" encoding="UTF-8">
</body>

</html>