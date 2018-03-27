<!DOCTYPE html>
<html>

<head>
    ﻿<#include "common/meta.ftl" encoding="UTF-8">
    <title>签到</title>
</head>
<body>
<header class='demos-header'>
    <h1 class="demos-title">签到</h1>
    <p class='demos-sub-title'>请点击签到进行打卡</p>
</header>
<div class="weui-flex">
    <div class="weui-flex__item">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label for="name" class="weui-label">课程</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" id="lesson" type="text" value="">
                </div>
            </div>
        </div>
    </div>
</div>
<div class="weui-flex">
    <div class="weui-flex__item">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label for="date" class="weui-label">时间</label>
                </div>
                <div class="weui-cell__bd">
                    <p class="weui-msg__desc" id="times"></p>
                </div>
            </div>
        </div>


    </div>
</div>
<div class='demos-content-padded'>
    <div class="dot1">
        <div class="dot2">
            <div id="checkIn" class="dot3">正在签到</div>
        </div>
    </div>
</div>

﻿<#include "common/footer.ftl" encoding="UTF-8">
<div id="picker-container"></div>
﻿<#include "common/script.ftl" encoding="UTF-8">
<script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"> </script>
<script src="${root}/js/checkin.js"></script>
<script>
    var enableCheckIn = false;
    var lessons = ${lessons};
    $(function () {
        FastClick.attach(document.body);
    });
</script>
</body>