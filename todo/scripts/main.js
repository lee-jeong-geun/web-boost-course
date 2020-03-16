var el = document.querySelectorAll(".card_button");

function findPosition(node) {
	var parent = node.parentNode;
	for ( var i in parent.childNodes) {
		if (parent.childNodes[i].nodeName === "LI"
				&& parent.childNodes[i].id > node.id) {
			return parent.childNodes[i];
		}
	}
	return null;
}

function update(event) {
	var oReq = new XMLHttpRequest();
	var target = event.target;
	var parent = target.parentNode;

	// toDo: add put method

	oReq.addEventListener("load", function() {
		console.log("ok");
	})
	oReq.open("GET", "main.jsp");
	oReq.send();

	oReq.onreadystatechange = function() {
		if (oReq.readyState !== XMLHttpRequest.DONE)
			return;

		if (oReq.status === 200) {
			console.log("200", event);

			if (parent.classList.contains("TODO")) {
				document.querySelector(".card_list_DOING").appendChild(parent);
				document.querySelector(".card_list_DOING").insertBefore(parent,
						findPosition(parent));
				parent.classList.replace("TODO", "DOING");
			} else {
				document.querySelector(".card_list_DONE").appendChild(parent);
				document.querySelector(".card_list_DONE").insertBefore(parent,
						findPosition(parent));
				parent.classList.replace("DOING", "DONE");
				parent.removeChild(parent.childNodes[3]);
			}
		}
	}
}

el.forEach(function(e) {
	e.addEventListener("click", update);
});
