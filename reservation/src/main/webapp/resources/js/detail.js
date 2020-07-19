(() => {
    let detailData = {};

    const makeRequest = (method, url, body) => new Promise((resolve, reject) => {
        const request = new XMLHttpRequest();

        request.onreadystatechange = () => {
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

    async function loadData() {
        let param = (new URL(document.location)).searchParams;
        let id = param.get('id');
        detailData = await makeRequest('GET', `/reservation/api/products/${id}`);
        loadIntroduce(detailData.displayInfo);
    }

    function loadIntroduce({productContent}) {
        const introduceBox = document.querySelector(".detail_info_lst .in_dsc");
        introduceBox.innerHTML = productContent;
    }

    window.addEventListener("DOMContentLoaded", loadData);
})();

