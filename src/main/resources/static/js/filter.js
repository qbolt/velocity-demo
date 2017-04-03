$('#filter').keypress(function(e) {
	if (e.which == 13) {
		$.ajax({
			url: '/updateFilter?filter=' + e.target.value,
			success: window.location.reload(),
			failure: window.location.reload()
		})
	}
}) 