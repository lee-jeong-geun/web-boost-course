const el = document.querySelectorAll(".card_button");

function findPosition(node) {
	const parent = node.parentNode;
	for (var i in parent.childNodes) {
		if (parent.childNodes[i].nodeName === "LI"
			&& parseInt(parent.childNodes[i].dataset.id) > parseInt(node.dataset.id)) {
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

function moveCardExecute(card, to, nextList) {
	document.querySelector(nextList).appendChild(card);
	document.querySelector(nextList).insertBefore(card, findPosition(card));
	card.dataset.type = to;
}

function moveCard(card) {
	if (card.dataset.type === 'TODO') {
		moveCardExecute(card, 'DOING', '.card_list_doing');
	} else {
		moveCardExecute(card, 'DONE', '.card_list_done');
		for (var i in card.childNodes) {
			if (card.childNodes[i].nodeName === "BUTTON") {
				card.removeChild(card.childNodes[i]);
			}
		}
	}
}

async function update(event) {
	const target = event.target;
	const parent = target.parentNode;


	const data = {
		id: parent.dataset.id,
		type: parent.dataset.type
	};

	try {
		await makeRequest('PUT', 'type', data);
		moveCard(parent);
	} catch (error) {
		console.log(error);
	}
}

el.forEach(function (e) {
	e.addEventListener("click", update);
});