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

async function updateCategoryTab(e) {
    const target = e.target;
    let categoryNode;
    if (target.tagName !== "SPAN" && target.tagName !== "A") {
        return;
    }
    // todo li tag search
    if (target.parentElement.tagName === "LI") {
        categoryNode = target.parentNode;
    } else {
        categoryNode = target.parentNode.parentNode;
    }
    // todo makeRequest (GET, /api/products?categoryId)
    const data = await makeRequest("GET", "/reservation/api/products?categoryId=" + categoryNode.dataset.category);
    // todo update categoryTab active
    // todo Li 태그의 자식 노드중 클래스 이름에 active 찾기
    categoryNode.parentNode.childNodes.forEach(x => {
        if (x.nodeName === "LI") {
            x.childNodes.forEach(y => {
                y.childNodes.forEach(z => {
                    console.log(z.parentElement.classList);
                });
                if (y.ownerDocument.documentElement.classList.contains("active")) {
                    console.log("oh");
                }
            });
        }
    })
    // todo insertItemCount

    // todo update wrap_event_box
}

loadCategory();

categoryTab.addEventListener("click", updateCategoryTab);