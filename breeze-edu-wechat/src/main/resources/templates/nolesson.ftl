<!DOCTYPE html>
<html>

<head>
    ﻿<#include "common/meta.ftl" encoding="UTF-8">
    <title>签到</title>
</head>
<body>
<div class="weui-msg">
    <div class="weui-msg__icon-area">
        <i class="weui-icon-warn weui-icon_msg"></i>
    </div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">签到失败</h2>
        <p class="weui-msg__desc">目前暂无可签到的课程，请确认签到时间后再次尝试。
        </p>
    </div>
</div>

﻿<#include "common/footer.ftl" encoding="UTF-8">
<div id="picker-container"></div>
﻿<#include "common/script.ftl" encoding="UTF-8">
<script>
    $(function () {
        FastClick.attach(document.body);
    });
</script>
</body>