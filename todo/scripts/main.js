var el = document.querySelectorAll(".card_button");

function findPosition(node) {
	var parent = node.parentNode;
	for (var i in parent.childNodes) {
		if (parent.childNodes[i].nodeName === "LI"
			&& parent.childNodes[i].id > node.id) {
			return parent.childNodes[i];
		}
	}
	return null;
}

function makeRequest(method, url, payload) {
	return new Promise(function (resolve, reject) {
		const request = new XMLHttpRequest();

		request.onreadystatechange = function () {
			if (request.readyState !== XMLHttpRequest.DONE) {
				return;
			}
			if (request.status === 200) {
				resolve(request.responseText);
			} else {
				reject(request.status);
			}
		};

		request.open(method, url);
		request.setRequestHeader('Content-type', 'application/json');
		request.send(JSON.stringify(payload));
	});

}

function moveCardExecute(card, from, to, nextList) {
	document.querySelector(nextList).appendChild(card);
	document.querySelector(nextList).insertBefore(card, findPosition(card));
	card.classList.replace(from, to);
}

function moveCard(card) {
	if (card.classList.contains("todo")) {
		moveCardExecute(card, 'todo', 'doing', '.card_list_doing');
	} else {
		moveCardExecute(card, 'doing', 'done', '.card_list_done');
		card.removeChild(card.childNodes[3]);
	}
}

async function update(event) {
	const target = event.target;
	const parent = target.parentNode;


	const data = {
		id: parseInt(parent.id),
		type: parent.classList[1].toUpperCase()
	};

	try {
		const message = await makeRequest('PUT', 'type', data);
		if (message === "success") {
			moveCard(parent);
		}
	} catch (error) {
		console.log(error);
	}
}

el.forEach(function (e) {
	e.addEventListener("click", update);
});