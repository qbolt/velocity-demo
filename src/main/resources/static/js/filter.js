function filter(element) {
	$.ajax({
		url: '/updateFilter?filter=' + element.value,
		success: location.reload(true),
		error: location.reload(true)
	})
}