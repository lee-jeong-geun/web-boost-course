const categoryTab = document.querySelector(".event_tab_lst");
const eventBox = document.querySelectorAll(".lst_event_box");
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

function makeProductTemplate(node, data) {
    const template = document.querySelector("#itemList").innerHTML;
    let result = [];
    result = data["items"].map(x => {
        return template.replace("${id}", x["productId"]).replace("${productImageUrl}", "../../" + x["productImageUrl"])
            .replace("${description}", x["productDescription"]).replace("${description}", x["productDescription"])
            .replace("${placeName}", x["placeName"]).replace("${content}", x["productContent"]);
    });
    result.forEach((x, index) => {
        if (index <= (result.length - 1) / 2) {
            node[0].innerHTML += x.trim();
        } else {
            node[1].innerHTML += x.trim();
        }
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
    if (target.parentElement.tagName === "LI") {
        categoryNode = target.parentNode;
    } else {
        categoryNode = target.parentNode.parentNode;
    }
    try {
        const data = await makeRequest("GET", "/reservation/api/products?categoryId=" + categoryNode.dataset.category);
        document.getElementsByClassName("anchor active").item(0).classList.remove("active");
        categoryNode.children.item(0).classList.add("active");
        insertItemCount(data["totalCount"]);
        eventBox.forEach(x => {
            while (x.firstChild) {
                x.removeChild(x.firstChild);
            }
        })
        makeProductTemplate(eventBox, data);
    } catch (e) {
        console.error(e);
    }
}

loadCategory();

categoryTab.addEventListener("click", updateCategoryTab);