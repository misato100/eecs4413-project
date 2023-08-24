$(document).ready(function () {
        $("#menu > li > div").click(function () {
            if (false == $(this).next().is(':visible')) {
                $('#menu ul').slideUp(300);
            }
            $(this).next().slideToggle(300);
        });
        $('#menu ul:eq(0)').show();
});

$(document).ready(function() {
	$("#grid tr:even").addClass('classEven');
});


$(document).ready(function () {
	  $("span.tooltip_message").hover(function () {
	    $(this).append('<div class="message"><p>Search by Name</p></div>');
	  },function () {
	    $("div.message").remove();
	  });/*
	  $("span.tooltip_img1").hover(function(){$(this).append('<div class="message"><ul><li>Title - Beginning Groovy, Grails and Griffon</li><li>Author: Vishal Layka</li><li>Publisher: Apress</li></ul></div>');
}, function(){$("div.message").remove();});*/
});

function minusOne(num) {
	var value = parseInt(document.getElementById('qty'+num).value);
	value--;
	if (value > 0) {
		document.getElementById('qty'+num).value = value;
	}

}

function addOne(num) {
	var value = parseInt(document.getElementById('qty'+num).value);
	value++;
	document.getElementById('qty'+num).value = value;
}

function changeShipping(num, subtotal) {
	var shipping = document.getElementById("shipping");
	var total = document.getElementById("total");
	shipping.innerHTML = "Shipping:" + num + ".00";
	var final = subtotal + num;
	final = Math.round(final * 100) / 100;
	total.innerHTML = "Total: " + final;
}
