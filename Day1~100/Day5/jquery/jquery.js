/**
 * 
 */

$(function(){
	// 그림 크기에 대한 설정
	$('.menu > img').css({'width':'100px','height':'100px'});
	
	// select 할 때마다 동적으로 주문내역을 추가하기
	let finalPrice = 0;
	
	$('.menuCount').change(function(){
		
		let name = $(this).siblings('span:first').text();
		let count = $(this).val() ;
		let price = $(this).siblings('span:eq(1)').text();
		let html = '';

		finalPrice += count*price;

		html += '<tr id = "newTable">';
		html += '<td width="150">'+name+ " " + count + " 개" + '</td>';
		html += '<td width="100">'+price*count +  "원" +'</td>';
		html += '<td width="50">'+"<input type=button id='newButton' value='삭제'>"+'</td>';
		html += '</tr>';
		
		$('#listTable').append(html);
		$('#total').attr('value',finalPrice);

	})
		
	// 동적으로 생성된 삭제 버튼의 이벤트
	$('#listTable').on('click','#newButton',function(){
			
			let par = $(this).parent();
			let minusPrice = par.siblings('td:eq(1)').text().replace("원","");
			finalPrice -= parseInt(minusPrice);

			par.siblings('td').remove();
			par.remove();
			
			// 총합 입력
			$('#total').attr('value',finalPrice);
		})
		
	// 주문에 대한 입력 값
	$('#btn').click(function(){
		alert("총 " + finalPrice+"원 결제 부탁드립니다.");
	})
})