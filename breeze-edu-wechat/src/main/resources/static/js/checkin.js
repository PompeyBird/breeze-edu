var checkIn = {
    lessonId: null,
    lat:null,
    lng:null
};
$(function () {
    getJsApi();
    // alert(location.href.split('#')[0]);
    showUnCheckIn('checkIn','获取地址');
    $(document).on("click", "#checkIn", function () {
        if(enableCheckIn){
            signIn();
        }
    });

    $("#lesson").select({
        title: "选择课程",
        items: lessons,
        // onChange: function(d) {
        //     console.log(this, d);
        // },
        onClose: function (d) {
            // if(d.data.values === "002"){
            //     checkLocation(true);
            // }else{
            //     checkLocation(false);
            // }
            // console.log('close')
            // alert(JSON.stringify(d.data.origins[0]));
            $('#times').html(d.data.origins[0].period);
            getLocation(d.data.values);
        }
    });

});
function showCheckIn(id) {
    var selector = $("#"+ id);
    selector.attr("class", "dot5");
    selector.html("点击签到");
    selector.parent().attr("class", "dot5");
    selector.parent().parent().attr("class", "dot5");
    enableCheckIn = true;
}
function showCheckingIn(id) {
    var selector = $("#"+ id);
    selector.attr("class", "dot3");
    selector.html("正在签到");
    selector.parent().attr("class", "dot2");
    selector.parent().parent().attr("class", "dot1");
    enableCheckIn = false;
}
function showUnCheckIn(id, tip) {
    var selector = $("#"+ id);
    selector.attr("class", "dot4");
    selector.html(tip);
    selector.parent().attr("class", "dot4");
    selector.parent().parent().attr("class", "dot4");
    enableCheckIn = false;
}
function showUnCheckOk(id) {
    var selector = $("#"+ id);
    selector.attr("class", "dot6");
    selector.html("已签到");
    selector.parent().attr("class", "dot6");
    selector.parent().parent().attr("class", "dot6");
    enableCheckIn = false;
}
function getLocation(lessonId) {
    $.showLoading();
    wx.getLocation({
        type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
        success: function (res) {
            $.hideLoading();
            // var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
            // var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
            // var speed = res.speed; // 速度，以米/每秒计
            // var accuracy = res.accuracy; // 位置精度
            checkIn.lessonId = lessonId;
            checkIn.lat = res.latitude;
            checkIn.lng = res.longitude;
            checkLocation(lessonId,res.latitude,res.longitude);
        }
    });
}
function checkLocation(lessonId, lat, lng) {
    // alert(JSON.stringify(checkIn));
    $.showLoading();
    // alert(11);
    $.ajax({
        type: "GET",
        dataType: 'json',
        url: rootPath + '/checkDis',
        data: {
            lessonId: lessonId,
            lat: lat,
            lng: lng
        },
        success: function (data) {
            $.hideLoading();
            // alert(JSON.stringify(data));
            if(data.success){
                if(data.data == 'true' || data.data){
                    // alert(22);
                    showCheckIn("checkIn");
                }
                else {
                    // alert(33);
                    showUnCheckIn("checkIn","无法签到");
                }
            }
            else {
                // alert(44);
                $.toast("获取位置失败", "forbidden");
            }
        },
        error: function () {
            // alert(55);
            $.hideLoading();
            $.toast("获取位置失败", "forbidden");
        }
    });
    // setTimeout(function () {
    //     if (flag) {
    //         showCheckIn("checkIn");
    //     } else {
    //         showUnCheckIn("checkIn","无法签到");
    //     }
    //     $.hideLoading();
    // }, 3000)
}
function signIn() {
    // alert(JSON.stringify(checkIn));
    // $.showLoading();
    showCheckingIn('checkIn');
    // alert(1);
    $.ajax({
        type: "POST",
        dataType: 'json',
        url: rootPath + '/signIn',
        data: {
            lessonId: checkIn.lessonId,
            lat: checkIn.lat,
            lng: checkIn.lng
        },
        success: function (data) {
            // alert(JSON.stringify(data));
            // $.hideLoading();
            if(data.success){
                // alert(2);
                $.toast("签到成功", function() {
                    showUnCheckOk("checkIn");
                    wx.closeWindow();
                });
            }
            else {
                // alert(3);
                $.toast("签到失败", "forbidden");
                showUnCheckIn("checkIn","无法签到");
            }
        },
        error: function () {
            // alert(4);
            $.hideLoading();
            $.toast("获取位置失败", "forbidden");
        }
    });
}
// function checkLocation(flag) {
//     $.showLoading();
//     setTimeout(function () {
//         if (flag) {
//             showCheckIn("checkIn");
//         } else {
//             showUnCheckIn("checkIn","无法签到");
//         }
//         $.hideLoading();
//     }, 3000)
// }

function getJsApi() {
    $.showLoading();
    $.ajax({
        type: "GET",
        dataType: 'json',
        url: rootPath + '/signature',
        data: {url:location.href.split('#')[0]},
        success: function (data) {
            $.hideLoading();
            if(data.signature == null){
                $.hideLoading();
                $.toast("获取位置失败", "forbidden");
                return;
            }
            wx.config({
                // debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: data.appId, // 必填，公众号的唯一标识
                timestamp: data.timestamp , // 必填，生成签名的时间戳
                nonceStr: data.nonceStr, // 必填，生成签名的随机串
                signature: data.signature,// 必填，签名，见附录1
                jsApiList: [
                    'checkJsApi',
                    'hideAllNonBaseMenuItem',
                    'closeWindow',
                    // 'chooseImage',
                    // 'previewImage',
                    // 'uploadImage',
                    // 'downloadImage',
                    // 'getNetworkType',//网络状态接口
                    // 'openLocation',//使用微信内置地图查看地理位置接口
                    'getLocation' //获取地理位置接口
                ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });
        },
        error: function () {
            $.hideLoading();
            $.toast("获取位置失败", "forbidden");
        }
    });
}
wx.ready(function(res){
    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
    wx.hideAllNonBaseMenuItem();
});