// ユーザ追加ボタン
$('.addUserBtn').click(function() {
    $('#modal-form-add').modal('show');
})

// ユーザ編集ボタン
$('.updateUserBtn').click(function() {
    $('#modal-form-update').modal('show');
})

// 検索
$('#findBtn').click(function () {
    $.ajax({
        type: 'GET',
        url: '/user/select',
        data: {
            'search': $('#search').val()
        },
        success: function (data) {
            // 局部刷新
            $('#userTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert('操作失败，请刷新重新尝试！')
        }
    })
})

// ユーザ追加
$('#addSubmitBtn').click(function () {
    var username = $('#addUserName').val()
    var nickname = $('#addNickname').val()
    var password = $("#addPassword").val()

    // validate
    if (username.length == 0){
        alert("用户名不能为空")
    } else if (nickname.length == 0){
        alert("昵称不能为空")
    } else if (password.length == 0){
        alert("密码不能为空")
    } else {
        $.ajax({
            type: 'POST',
            url: '/user/insert',
            data: {
                'username': username,
                'nickname': nickname,
                'password': password
            },
            success: function (data) {
                // 关闭modal框
                $('#modal-form-add').modal('hide')
                // 局部刷新
                $('#userTable').html(data)
            },
            error: function (err) {
                console.log(err)
                alert("操作失败，请刷新重新尝试！")
            }
        })
    }
})

// ユーザ編集
$('#updateSubmitBtn').click(function () {
    var id = $('#updateUserId').val()
    var username = $('#updateUsername').val()
    var nickname = $('#updateNickname').val()
    var password = $("#updatePassword").val()

    // validate
    if (username.length == 0){
        alert("用户名不能为空")
    } else if (nickname.length == 0){
        alert("昵称不能为空")
    } else if (password.length == 0){
        alert("密码不能为空")
    } else {
        $.ajax({
            type: 'POST',
            url: '/user/update',
            data: {
                'id': id,
                'username': username,
                'nickname': nickname,
                'password': password
            },
            success: function (data) {
                // 关闭modal框
                $('#modal-form-update').modal('hide')
                // 局部刷新
                $('#userTable').html(data)
            },
            error: function (err) {
                console.log(err)
                alert("操作失败，请刷新重新尝试！")
            }
        })
    }
})

// 削除
function deleteBtn(id) {
    // 发送请求
    $.ajax({
        type: 'POST',
        url: '/user/delete',
        data: {
            'id': id
        },
        success: function (data) {
            // 局部刷新
            $('#userTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}

// 編集
function updateBtn(id, username, nickname, password) {
    $('#modal-form-update').modal('show');
    $('#updateUserId').val(id)
    $('#updateUsername').val(username)
    $('#updateNickname').val(nickname)
    $('#updatePassword').val(password)
}