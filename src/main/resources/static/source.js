$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/Offers",
        type: 'get'
    }).then(function(data) {
    	console.log(data);
       $('.offer-id').append(data.id);
       $('.offer-service').append(data.service);
       $('.offer-description').append(data.description);
       $('.offer-price').append(data.price);
    });
});

$.getJSON("http://localhost:8080/api/Offers", function(data) {
	$(data).each(function(index, offer){
		$('#tableBod').append($("<tr>")
				.append($("<td>").append(offer.id))
				.append($("<td>").append(offer.service))
				.append($("<td>").append(offer.description))
				.append($("<td>").append(offer.price)))
	});
}).done(function() {
	console.log('GetOffer API completed');
}).fail(function(e) {
	console.error(e);
})




