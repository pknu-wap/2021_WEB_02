//api 호출 js
var main = {    //다른 js랑 겹치지 않게
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {    //btn-save: id 엘리먼트 클릭시 save 함수 실행
            _this.save();
        });

        $('#btn-update').on('click', function () {  //수정 함수 실행
            _this.update();
        });

        $('#btn-delete').on('click', function () {  //삭제 함수 실행
            _this.delete();
        });


    },
    save : function () {
        var data = {
            title: $('#title').val(),   //jquery 객체 title 값 불러오기
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',       //등록(PostsApiController에서 정의함)
            url: '/api/v1/posts',
             dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()

        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',        //수정
            url: '/api/v1/posts/'+id,   //id로 게시물 구분
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {      //삭제
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },


};

main.init();