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
        console.log(detailData);
        loadComment(detailData);
        loadIntroduce(detailData.displayInfo);
    }

    function loadComment(data) {
        const {averageScore} = data;
        const {comments} = data;
        const MAX_COMMENT_COUNT = 3;
        const list = document.querySelector(".list_short_review");
        const commentCount = document.querySelector(".join_count .green");

        commentCount.innerHTML = `${comments.length}건`;
        if (comments.length === 0) {
            list.innerHTML = '';
            return;
        }

        const template = document.querySelector("#commentTemplate").innerHTML;
        const bindTemplate = Handlebars.compile(template);

        const comment = getComment(comments, MAX_COMMENT_COUNT);
        const resultHTML = comment.reduce((sum, v) => {
            const commentObject = {
                review: v.comment,
                grade: v.score + '.0',
                email: modifyEmail(v.reservationEmail),
                date: modifyDate(v.reservationDate),
                imageUrl: getCommentImage(v.commentImages)
            };
            return sum += bindTemplate(commentObject);
        }, '');
        list.innerHTML = resultHTML;

    }

    const getComment = (comments, maxCommentCount) => {
        const result = [];
        const commentSize = Math.min(maxCommentCount, comments.length);
        for (let i = 0; i < commentSize; i++) {
            result.push(comments[i]);
        }
        return result;
    }

    const modifyEmail = (email) => {
        return `${email.substring(0, 4)}****`;
    }

    const modifyDate = (date) => {
        const dateToArr = date.split('-');
        const year = dateToArr[0];
        const month = parseInt(dateToArr[1], 10);
        const day = parseInt(dateToArr[2].substring(0, 2));
        return `${year}.${month}.${day}. 방문`;
    }

    const getCommentImage = (images) => {
        return images.length > 0 ? `../img/${images[0].saveFileName}` : null;
    }

    function loadIntroduce({productContent}) {
        const introduceBox = document.querySelector(".detail_info_lst .in_dsc");
        introduceBox.innerHTML = productContent;
    }

    window.addEventListener("DOMContentLoaded", loadData);
})();

