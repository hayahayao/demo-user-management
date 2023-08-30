// ユーザ追加ボタン
$('.addUserBtn').click(function() {
    $('#modal-form-add').modal('show');
})

// ユーザ編集ボタン
$('.updateUserBtn').click(function() {
    $('#modal-form-update').modal('show');
})

// serch
$('#findBtn').click(function () {
    // 发送GET异步请求
    $.ajax({
        type: 'GET',
        url: '/user/select', // 请求路径
        data: {
            'search': $('#search').val()
        },
        success: function (data) {
            // 局部刷新数据显示部分的div
            $('#userTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert('操作失败，请刷新重新尝试！')
        }
    })
})