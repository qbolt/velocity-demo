$('#filter').keypress(function(e) {
	if (e.which == 13) {
		$.ajax({
			url: '/updateFilter?filter=' + e.target.value,
			success: window.location.reload(),
			failure: window.location.reload()
		})
	}
}) 

$('.person').click(function(e) {
	console.log(e.target.innerText)
	$.ajax({
		url: '/setCurrentPerson?currentPerson=' + e.target.innerText,
		success: window.location.reload(),
		failure: window.location.reload()
	})
})
