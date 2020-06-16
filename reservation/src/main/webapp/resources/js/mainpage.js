(() => {
    const categoryTab = document.querySelector(".event_tab_lst");
    const eventBox = document.querySelectorAll(".lst_event_box");
    const moreBox = document.querySelector(".more");
    const promotionBox = document.querySelector(".visual_img");
    let promotionList = [];

    const makeRequest = (method, url, body) => new Promise((resolve, reject) => {
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
    });

    const makeCategoryItemTemplate = (node, {items}) => {
        const template = document.querySelector("#categoryItem").innerHTML;

        const result = items.map(({id, name}) => {
            return template.replace("${id}", id)
                .replace("${name}", name);
        });

        node.innerHTML += result.reduce((sum, x) => sum += x.trim(), '');
    };

    const makeProductTemplate = (node, {items}) => {
        const template = document.querySelector("#itemList").innerHTML;

        const result = items.map(({productId, productImageUrl, productDescription, placeName, productContent}) => {
            return template.replace("${id}", productId)
                .replace("${productImageUrl}", "../../" + productImageUrl)
                .replace("${description}", productDescription)
                .replace("${description}", productDescription)
                .replace("${placeName}", placeName)
                .replace("${content}", productContent);
        });

        const div = Math.round(result.length) / 2;
        result.forEach((x, index) => node[Math.floor(index / div)].innerHTML += x.trim());
    };

    const insertItemCount = count => document.querySelector(".event_lst_txt .pink").innerHTML = `${count}개`;

    const eventBoxProductCount = node => Array.from(node).map(x => x.childElementCount).reduce((sum, x) => sum + x);

    async function loadData() {
        try {
            const promotionTemplate = document.querySelector("#promotionItem");
            const dataCategory = await makeRequest("GET", "/reservation/api/categories");
            const dataProduct = await makeRequest("GET", "/reservation/api/products?categoryId=0");
            const {items} = await makeRequest("GET", "/reservation/api/promotions");
            const categoryItemCount = dataCategory.items
                .map(x => x.count)
                .reduce((sum, x) => sum + x);

            promotionList = items.map(({productImageUrl}) => promotionTemplate.innerHTML
                .replace("${promotionImageUrl}", `../../${productImageUrl}`)
                .trim());
            makeCategoryItemTemplate(categoryTab, dataCategory);
            insertItemCount(categoryItemCount);
            makeProductTemplate(eventBox, dataProduct);
            insertPromotionItem();
            setInterval(createPromotion, 1000);
        } catch (e) {
            console.error(e);
        }
    }

    async function updateCategoryTab({target}) {
        if (target.tagName !== "SPAN" && target.tagName !== "A") {
            return;
        }
        const {tagName} = target.parentElement;
        const categoryNode = tagName === 'LI' ? target.parentNode : target.parentNode.parentNode;
        try {
            if (moreBox.childElementCount === 0) {
                moreBox.innerHTML += document.querySelector("#moreBtn").innerHTML.trim();
            }
            const data = await makeRequest("GET", `/reservation/api/products?categoryId=${categoryNode.dataset.category}`);
            document.getElementsByClassName("anchor active").item(0).classList.remove("active");
            categoryNode.children.item(0).classList.add("active");
            insertItemCount(data.totalCount);
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

    async function addProductItem({target}) {
        if (target.className === "more") {
            return;
        }
        try {
            const categoryNumber = document.getElementsByClassName("anchor active").item(0).parentElement.dataset.category;
            const productCount = eventBoxProductCount(eventBox);
            const data = await makeRequest("GET", "/reservation/api/products?categoryId=" + categoryNumber + "&start=" + productCount);
            makeProductTemplate(eventBox, data);
            const updateProductCount = eventBoxProductCount(eventBox);

            if (updateProductCount === data.totalCount) {
                target.parentNode.removeChild(target);
            }
        } catch (e) {
            console.error(e);
        }
    }

    var promotionIndex = 0;

    function insertPromotionItem() {
        promotionBox.innerHTML = promotionList[promotionIndex] + promotionList[(promotionIndex + 1) % promotionList.length];
        promotionBox.childNodes.forEach(x => {
            x.style.right = "0px";
            x.style.transform = "translate(-0px)";
            x.style.transition = "right 0.5s";
        });
    }

    function createPromotion() {
        const {width} = promotionBox.childNodes[0].getBoundingClientRect();
        promotionBox.childNodes.forEach(x => {
            x.style.right = parseInt(x.style.right) + width - 1 + "px";
        });
        if (parseInt(promotionBox.childNodes[0].style.right) >= width) {
            promotionIndex = (promotionIndex + 1) % 11;
            insertPromotionItem();
        }
    }

    window.addEventListener("DOMContentLoaded", loadData);
    categoryTab.addEventListener("click", updateCategoryTab);
    moreBox.addEventListener("click", addProductItem);
})();