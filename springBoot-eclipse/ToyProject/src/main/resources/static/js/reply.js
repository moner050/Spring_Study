// replyObject 객체 선언 
let replyObject = {

	// init() 함수 선언 
	init: function() {
		let _this = this;
		
		// "#btn-insert" 버튼에 "click" 이벤트가 발생하면 insertPost() 함수를 호출한다. 
		$(".btn-insertReply").on("click", () => {
			_this.insertReply();
		});
		
		// "#btn-insert" 버튼에 "click" 이벤트가 발생하면 insertPost() 함수를 호출한다. 
		$(".btn-deleteReply").on("click", () => {
			_this.deleteReply();
		});
		
	},
	
	
		deleteReply: function(id) {
		alert("댓글 삭제 요청됨");

		// Ajax를 이용한 비동기 호출
		$.ajax({
			type: "DELETE", // 요청 방식
			url: "/post/deleteReply/" + id, // 요청 path
		}).done(function(response) {
			alert(response);
			location.reload();
		});
	}

}
 
// replyObject 객체의 init() 함수 호출. 
replyObject.init();
