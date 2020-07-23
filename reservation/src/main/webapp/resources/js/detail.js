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
        const topIntroduceBox = document.querySelector(".store_details .dsc");
        const bottomIntroduceBox = document.querySelector(".detail_info_lst .in_dsc");
        loadIntroduce(detailData.displayInfo, topIntroduceBox)
        loadComment(detailData);
        loadIntroduce(detailData.displayInfo, bottomIntroduceBox);
    }

    function loadComment(data) {
        const MAX_COMMENT_COUNT = 3;
        const MAX_AVERAGE_SCORE = 5;
        const {averageScore} = data;
        const {comments} = data;
        const list = document.querySelector(".list_short_review");
        const commentCount = document.querySelector(".join_count .green");
        const gradeValue = document.querySelector(".grade_area .text_value span");
        const graphValue = document.querySelector(".grade_area .graph_mask .graph_value");
        const roundOffAverageScore = averageScore.toFixed(1);

        graphValue.style.width = `${roundOffAverageScore / MAX_AVERAGE_SCORE * 100}%`;
        gradeValue.innerText = roundOffAverageScore;
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
        const commentCount = Math.min(maxCommentCount, comments.length);
        const result = comments.slice(0, commentCount);
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

    function loadIntroduce({productContent}, introduceBox) {
        introduceBox.innerHTML = productContent;
    }

    function topIntroduceToggle({target}) {
        if (findParentClass('section_store_details', 'store_details', target)) {
            return;
        }
    }

    function findParentClass(rootClassString, findClassString, currentElement) {
        if (findClass(currentElement, rootClassString)) {
            return false;
        } else if (findClass(currentElement, findClassString)) {
            return true;
        }
        return findParentClass(rootClassString, findClassString, currentElement.parentElement);
    }

    function findClass(element, classString) {
        return element
            .className
            .split(' ')
            .filter((name) => {
                return name === classString;
            })
            .length > 0;
    }

    window.addEventListener("DOMContentLoaded", loadData);
    document.querySelector(".section_store_details").addEventListener("click", topIntroduceToggle);
})();

