const categoryTab = document.querySelector(".event_tab_lst");
const eventBox = document.querySelectorAll(".lst_event_box");
const moreBox = document.querySelector(".more");
const promotionBox = document.querySelector(".visual_img");
let promotionList = [];

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

function makeCategoryItemTemplate(node, data) {
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

async function loadData() {
    const promotionTemplate = document.querySelector("#promotionItem");
    try {
        const dataCategory = await makeRequest("GET", "/reservation/api/categories");
        const dataProduct = await makeRequest("GET", "/reservation/api/products?categoryId=0");
        const dataPromotion = await makeRequest("GET", "/reservation/api/promotions");
        const categoryItemCount = dataCategory["items"].map(x => {
            return x.count;
        }).reduce((sum, x) => {
            return sum + x;
        });
        promotionList = dataPromotion["items"].map(x => {
            return promotionTemplate.innerHTML.replace("${promotionImageUrl}", "../../" + x["productImageUrl"]).trim();
        });
        makeCategoryItemTemplate(categoryTab, dataCategory);
        insertItemCount(categoryItemCount);
        makeProductTemplate(eventBox, dataProduct);
        setInterval(createPromotion, 1000);
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
        if (moreBox.childElementCount === 0) {
            moreBox.innerHTML += document.querySelector("#moreBtn").innerHTML.trim();
        }
        const data = await makeRequest("GET", "/reservation/api/products?categoryId=" + categoryNode.dataset.category);
        document.getElementsByClassName("anchor active").item(0).classList.remove("active");
        categoryNode.children.item(0).classList.add("active");
        insertItemCount(data["totalCount"]);
        eventBox.forEach(x => {
            while (x.firstChild) {
                x.removeChild(x.firstChild);
            }
        });
        makeProductTemplate(eventBox, data);
    } catch (e) {
        console.error(e);
    }
}

async function addProductItem(e) {
    const target = e.target;
    if (target.className === "more") {
        return;
    }
    try {
        const categoryNumber = document.getElementsByClassName("anchor active").item(0).parentElement.dataset.category;
        const productCount = Array.from(eventBox).map(x => x.childElementCount).reduce((sum, x) => {
            return sum + x;
        });
        const data = await makeRequest("GET", "/reservation/api/products?categoryId=" + categoryNumber + "&start=" + productCount);
        makeProductTemplate(eventBox, data);
        const updateProductCount = Array.from(eventBox).map(x => x.childElementCount).reduce((sum, x) => {
            return sum + x;
        });
        if (updateProductCount === data["totalCount"]) {
            target.parentNode.removeChild(target);
        }
    } catch (e) {
        console.error(e);
    }
}

var promotionIndex = 0;

function insertPromotionItem() {
    promotionBox.innerHTML = promotionList[promotionIndex];
    promotionBox.innerHTML += promotionList[(promotionIndex + 1) % promotionList.length];
    promotionBox.childNodes.forEach(x => {
        x.style.right = "0px";
        x.style.transform = "translate(-0px)";
        x.style.transition = "right 1s";
    });
}

function createPromotion() {
    if (promotionBox.childElementCount === 0) {
        insertPromotionItem();
    } else {
        promotionBox.childNodes.forEach(x => {
            x.style.right = parseInt(x.style.right) + 413  + "px";
        });
        if (parseInt(promotionBox.childNodes[0].style.right) >= 414) {
            promotionIndex = (promotionIndex + 1) % 11;
            insertPromotionItem();
        }
    }
}


window.addEventListener("DOMContentLoaded", loadData);
categoryTab.addEventListener("click", updateCategoryTab);
moreBox.addEventListener("click", addProductItem);