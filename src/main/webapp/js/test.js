/**
 * 
 */
function changeShipping(num, subtotal) {
	var shipping = document.getElementById("shipping");
	var total = document.getElementById("total");
	shipping.innerHTML = num;
	total.innerHTML = subtotal + num;
}