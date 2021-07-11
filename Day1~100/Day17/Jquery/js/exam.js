$(function(){
// 1번 : 시간 추가하기
	let now = new Date();
	$('#date_wrap').find('span.year').html(now.getFullYear());
	$('#date_wrap').find('span.month').html(now.getMonth()+1);
	$('#date_wrap').find('span.date').html(now.getDate());
	
// 2번 : 포커스 가면 "검색어를 입력하세요"를 안보이고 다시 포커스가 없으면 다시 출력
	$('#keyword').on('focus',function(){
		$('#keyword').css({'background':'none'});
	});
		$('#keyword').on('blur',function(){
		$('#keyword').css({'background':'url("images/sch_guide.gif") no-repeat'});
	});
	
// 3번 탭팬 구현
	$('.tab_btn1 a').click(function(){
		$('.tab_btn1 a').find('img').attr("src","images/tab_btn_1_over.gif");
		$('.tab_btn2 a').find('img').attr("src","images/tab_btn_2_out.gif");
		$('.tab_btn3 a').find('img').attr("src","images/tab_btn_3_out.gif");
		$('#tabmenu dt:first-child + dd').css({'display':'block'})
		$('#tabmenu dt:eq(1) + dd').css({'display':'none'})
		$('#tabmenu dt:eq(2) + dd').css({'display':'none'})
	})
	
	$('.tab_btn2 a').click(function(){
		$('.tab_btn1 a').find('img').attr("src","images/tab_btn_1_out.gif");
		$('.tab_btn2 a').find('img').attr("src","images/tab_btn_2_over.gif");
		$('.tab_btn3 a').find('img').attr("src","images/tab_btn_3_out.gif");
		$('#tabmenu dt:first-child + dd').css({'display':'none'})
		$('#tabmenu dt:eq(1) + dd').css({'display':'block'})
		$('#tabmenu dt:eq(2) + dd').css({'display':'none'})
	})
	
	$('.tab_btn3 a').click(function(){
		$('.tab_btn1 a').find('img').attr("src","images/tab_btn_1_out.gif");
		$('.tab_btn2 a').find('img').attr("src","images/tab_btn_2_out.gif");
		$('.tab_btn3 a').find('img').attr("src","images/tab_btn_3_over.gif");
		$('#tabmenu dt:first-child + dd').css({'display':'none'})
		$('#tabmenu dt:eq(1) + dd').css({'display':'none'})
		$('#tabmenu dt:eq(2) + dd').css({'display':'block'})
	})
	
// 4번 bxSlider 구현
    $('#best_bg > ul').addClass('bxslider');  
	$('.bxslider').css({"marginLeft":'10px'});
	$('.prev_btn > a').css({'display':'none'});
	$('.next_btn > a').css({'display':'none'});
	$('.bxslider').bxSlider({
		minSlides : 5,
		maxSlides : 5,
		moveSlides : 1,
		slideWidth : 150,
		slideMargin :20,
		auto : true,
		nextSelector : '.next_btn',
		prevSelector: '.prev_btn',
		controls : true,
		pager : false,
		prevText: "<img src='images/bestbook_btn_left.png' />",
		nextText: "<img src='images/bestbook_btn_right.png' />"
	});
	
// 5번 로그인을 누르면 폼창 보이고 close 누르면 안보이기
	$('.login_wrap a').click(function(){
		$('#login_f').css({top : "20px"});
	})
	$('.login_close_btn').click(function(){
			$('#login_f').css({top : "-500px"})
	})
	
// 6번 전체메뉴를 클릭하면 전체메뉴가 보이고 close 누르면 안보이기
	$("#total_btn").click(function(){
		$("#total_menu").show();
	})
	$("#total_close").click(function(){
		$("#total_menu").hide();
	})
	
// 7번 알림판 클릭 시 알림판 변경
	$('.roll_btn1 a').click(function(){
		$('#roll_banner_wrap dt:eq(0) a').find('img').attr("src","images/pop_btn_1_over.gif");
		$('#roll_banner_wrap dt:eq(1) a').find('img').attr("src","images/pop_btn_2_out.gif");
		$('#roll_banner_wrap dt:eq(2) a').find('img').attr("src","images/pop_btn_3_out.gif");
		$('#roll_banner_wrap dt:eq(3) a').find('img').attr("src","images/pop_btn_4_out.gif");
		
		$('#roll_banner_wrap dd:eq(0)').show();
		$('#roll_banner_wrap dd:eq(1)').hide();
		$('#roll_banner_wrap dd:eq(2)').hide();
		$('#roll_banner_wrap dd:eq(3)').hide();

	})
	$('.roll_btn2 a').click(function(){
		$('#roll_banner_wrap dt:eq(0) a').find('img').attr("src","images/pop_btn_1_out.gif");
		$('#roll_banner_wrap dt:eq(1) a').find('img').attr("src","images/pop_btn_2_over.gif");
		$('#roll_banner_wrap dt:eq(2) a').find('img').attr("src","images/pop_btn_3_out.gif");
		$('#roll_banner_wrap dt:eq(3) a').find('img').attr("src","images/pop_btn_4_out.gif");
		
		$('#roll_banner_wrap dd:eq(0)').hide();
		$('#roll_banner_wrap dd:eq(1)').show();
		$('#roll_banner_wrap dd:eq(2)').hide();
		$('#roll_banner_wrap dd:eq(3)').hide();
	})
	$('.roll_btn3 a').click(function(){
		$('#roll_banner_wrap dt:eq(0) a').find('img').attr("src","images/pop_btn_1_out.gif");
		$('#roll_banner_wrap dt:eq(1) a').find('img').attr("src","images/pop_btn_2_out.gif");
		$('#roll_banner_wrap dt:eq(2) a').find('img').attr("src","images/pop_btn_3_over.gif");
		$('#roll_banner_wrap dt:eq(3) a').find('img').attr("src","images/pop_btn_4_out.gif");
		
		$('#roll_banner_wrap dd:eq(0)').hide();
		$('#roll_banner_wrap dd:eq(1)').hide();
		$('#roll_banner_wrap dd:eq(2)').show();
		$('#roll_banner_wrap dd:eq(3)').hide();
	})
	$('.roll_btn4 a').click(function(){
		$('#roll_banner_wrap dt:eq(0) a').find('img').attr("src","images/pop_btn_1_out.gif");
		$('#roll_banner_wrap dt:eq(1) a').find('img').attr("src","images/pop_btn_2_out.gif");
		$('#roll_banner_wrap dt:eq(2) a').find('img').attr("src","images/pop_btn_3_out.gif");
		$('#roll_banner_wrap dt:eq(3) a').find('img').attr("src","images/pop_btn_4_over.gif");
		
		$('#roll_banner_wrap dd:eq(0)').hide();
		$('#roll_banner_wrap dd:eq(1)').hide();
		$('#roll_banner_wrap dd:eq(2)').hide();
		$('#roll_banner_wrap dd:eq(3)').show();
	})
// ============================================================	
}) // end of function

