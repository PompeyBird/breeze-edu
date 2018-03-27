(function ($) {
    $(document).on("click", "#bindSubmit", function () {
        submitBind();
    });
})(jQuery);

function submitBind() {
    $.showLoading();
    var obj = checkBind();
    if(obj == null){
        $.hideLoading();
        return;
    }

    $.ajax({
        type: "POST",
        dataType: 'json',
        url: rootPath + '/bind',
        data: obj,
        success: function (data) {
            $.hideLoading();
            if(data.success){
                $.toast("操作成功", function() {
                    // alert(directUrl);
                    if(directUrl !== ''){
                        window.location.href = directUrl;
                    }
                });
                $('#bindSubmit').addClass('weui-btn_disabled');
                $('#bindSubmit').html('已提交');
            }
            else {
                $.toast("操作失败", "forbidden");
            }
        },
        error: function () {
            $.hideLoading();
            $.toast("操作失败", "forbidden");
        }
    });
}

function checkBind() {
    var realName = $('#realName').val();
    var studentId = $('#studentId').val();
    var classId = $('#classId').val();
    var checkFlag = true;

    if(realName === ''){
        checkFlag = false;
        showError('realName');
    }else {
        showOk('realName');
    }

    if(studentId === ''){
        checkFlag = false;
        showError('studentId');
    }else {
        showOk('studentId');
    }

    if(classId === ''){
        checkFlag = false;
        showError('classId');
    }else {
        showOk('classId');
    }

    if(!checkFlag){
        $.alert("请正确填写个人信息！", "警告！");
    }else {
        return {
            realname: realName,
            studentId: studentId,
            classId: classId
        };
    }

    return null;
}

function showError(id) {
    var weuiForm = $('#' + id).parents('.weui-cell');
    weuiForm.addClass('weui-cell_warn');
    weuiForm.find('i').attr('class','weui-icon-warn');
}

function showOk(id) {
    var weuiForm = $('#' + id).parents('.weui-cell');
    weuiForm.removeClass('weui-cell_warn');
    weuiForm.find('i').attr('class','weui-icon-success');
}