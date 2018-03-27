<!DOCTYPE html>
<html>

<head>
    ﻿<#include "common/meta.ftl" encoding="UTF-8">
    <title>签到</title>
</head>

<body>

<header class='demos-header'>
    <h1 class="demos-title">签到</h1>
    <p class='demos-sub-title'>请填写学号班级并提交</p>
</header>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">姓名</label>
        </div>
        <div class="weui-cell__bd">
            <input id="realName" class="weui-input" type="text" pattern="" placeholder="请输入真实姓名">
        </div>
        <div class="weui-cell__ft">
            <i></i>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">学号</label>
        </div>
        <div class="weui-cell__bd">
            <input id="studentId" class="weui-input" type="text" placeholder="请输入学生编号">
        </div>
        <div class="weui-cell__ft">
            <i></i>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd">
            <label class="weui-label">班级</label>
        </div>
        <div class="weui-cell__bd">
            <input id="classId" class="weui-input" type="text" placeholder="请输入所在班级">
        </div>
        <div class="weui-cell__ft">
            <i></i>
        </div>
    </div>
</div>
<div class='demos-content-padded'>
    <a href="javascript:;" id="bindSubmit" class="weui-btn weui-btn_primary">提交</a>
<#--<a href="javascript:;" id="bindSubmiting" class="weui-btn weui-btn_primary weui-btn_loading">正在提交...</a>-->
</div>
﻿<#include "common/footer.ftl" encoding="UTF-8">
﻿<#include "common/script.ftl" encoding="UTF-8">
<script>
    var lessonId = ${lessonId};
    var code = '${code}';
</script>
<script src="${root}/js/check.js"></script>
</body>