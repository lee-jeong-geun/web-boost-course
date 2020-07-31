(() => {
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
        const detailData = await makeRequest('GET', `/reservation/api/products/${id}`);
    }
    
})