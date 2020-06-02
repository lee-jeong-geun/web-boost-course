const categoryTab = document.querySelector(".event_tab_lst");
let categoryItemCount = [];

function makeRequest(method, url, body) {
    return new Promise((resolve, reject) => {
        const request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState !== XMLHttpRequest.DONE) {
                return;
            } else if (request.status === 200) {
                resolve(request.response);
            } else {
                reject(request.status);
            }
        }
        request.open(method, url);
        request.setRequestHeader('Content-type', 'application/json');
        request.responseType = 'json';
        request.send(JSON.stringify(body));
    })
}

function makeTemplate(node, data) {
    const template = document.querySelector("#categoryItem").innerHTML;
    let result = [];
    result = data["items"].map(x => {
        return template.replace("{id}", x["id"]).replace("{name}", x["name"]);
    });
    result.forEach(x => {
        node.innerHTML += x.trim();
    });
}

function insertItemCount(count) {
    const el = document.querySelector(".event_lst_txt .pink");
    el.innerHTML = count + "개";
}

async function loadCategory() {
    try {
        const data = await makeRequest("GET", "/reservation/api/categories", '');
        categoryItemCount = data["items"].map(x => {
            return x.count;
        });
        makeTemplate(categoryTab, data);
        insertItemCount(categoryItemCount.reduce((sum, x) => {
            return sum + x;
        }));
    } catch (e) {
        console.error(e);
    }
}

loadCategory();