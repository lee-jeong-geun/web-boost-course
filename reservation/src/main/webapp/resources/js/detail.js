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
        const topIntroduceBox = document.querySelector('.store_details .dsc');
        const bottomIntroduceBox = document.querySelector('.detail_info_lst .in_dsc');
        loadImage(detailData);
        loadIntroduce(detailData.displayInfo, topIntroduceBox)
        loadComment(detailData, id);
        loadIntroduce(detailData.displayInfo, bottomIntroduceBox);
    }

    let imageIndex = 0;

    function loadImage(data) {
        const MAX_IMAGE_COUNT = 2;
        const {displayInfo} = data;
        const {productDescription} = displayInfo;
        const {productImages} = data;
        const template = document.querySelector('#imageTemplate').innerHTML;
        const imageBox = document.querySelector('.visual_img');
        const currentImageIndexBox = document.querySelector('.figure_pagination .num');
        const maxImageCountBox = document.querySelector('.figure_pagination .off')
        const bindTemplate = Handlebars.compile(template);
        const image = getImage(productImages, MAX_IMAGE_COUNT);
        const imageList = image.map((v) => {
            const bindObject = {
                imageDescription: productDescription,
                imageUrl: `../${v.saveFileName}`,
                title: productDescription
            }
            return bindTemplate(bindObject).trim();
        });
        imageBox.innerHTML = imageList[0];
        currentImageIndexBox.innerHTML = '1';
        maxImageCountBox.innerHTML = `/ <span>${image.length}</span>`;
        if (image.length < 2) {
            return;
        }
        const {width} = imageBox.childNodes[0].getBoundingClientRect();
        insertImage(imageBox, imageList, width);

        const groupVisualBox = document.querySelector('.group_visual div');
        const leftCursorTemplate = document.querySelector('#leftCursorTemplate').innerHTML;
        const rightCursorTemplate = document.querySelector('#rightCursorTemplate').innerHTML;
        const bindLeftTemplate = Handlebars.compile(leftCursorTemplate);
        const bindRightTemplate = Handlebars.compile(rightCursorTemplate);
        groupVisualBox.innerHTML += bindLeftTemplate() + bindRightTemplate();
        document.querySelector('.group_visual').addEventListener('click', function (e) {
            moveImage(imageList, e, width, currentImageIndexBox);
        });
    }

    function moveImage(imageList, {target}, width, currentImageIndexBox) {
        const imageBox = document.querySelector('.visual_img');
        if (findParentClass('group_visual', 'nxt_inn', target)) {
            imageBox.childNodes.forEach(x => {
                x.style.right = parseInt(x.style.right) + width + 'px';
            });
            setTimeout(() => {
                imageIndex = (imageIndex + 1) % imageList.length;
                currentImageIndexBox.innerHTML = imageIndex + 1;
                insertImage(imageBox, imageList, width);
            }, 500);
        } else if (findParentClass('group_visual', 'prev_inn', target)) {
            imageBox.childNodes.forEach(x => {
                x.style.right = parseInt(x.style.right) - width + 'px';
            });
            setTimeout(() => {
                imageIndex = (imageIndex - 1 + imageList.length) % imageList.length;
                currentImageIndexBox.innerHTML = imageIndex + 1;
                insertImage(imageBox, imageList, width);
            }, 500);
        }
    }

    function insertImage(imageBox, imageList, width) {
        imageBox.innerHTML = imageList[(imageIndex - 1 + imageList.length) % imageList.length] + imageList[imageIndex] + imageList[(imageIndex + 1) % imageList.length];
        imageBox.childNodes.forEach(x => {
            x.style.right = `${width}px`;
            x.style.transition = 'right 0.5s, left 0.5s';
        });
    }

    function getImage(images, maxImageCount) {
        const imageCount = Math.min(maxImageCount, images.length);
        const result = images.slice(0, imageCount);
        return result;
    }


    function loadComment(data, id) {
        const MAX_COMMENT_COUNT = 3;
        const MAX_AVERAGE_SCORE = 5;
        const {averageScore} = data;
        const {comments} = data;
        const list = document.querySelector('.list_short_review');
        const commentCount = document.querySelector('.join_count .green');
        const gradeValue = document.querySelector('.grade_area .text_value span');
        const graphValue = document.querySelector('.grade_area .graph_mask .graph_value');
        const moreCommentButton = document.querySelector('.btn_review_more');
        const roundOffAverageScore = averageScore.toFixed(1);
        graphValue.style.width = `${roundOffAverageScore / MAX_AVERAGE_SCORE * 100}%`;
        gradeValue.innerText = roundOffAverageScore;
        commentCount.innerHTML = `${comments.length}건`;
        moreCommentButton.setAttribute('href', `review.html?id=${id}`);

        if (comments.length === 0) {
            list.innerHTML = '';
            return;
        }

        const template = document.querySelector('#commentTemplate').innerHTML;
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
        const introduceBox = document.querySelector('.store_details');
        const openButton = document.querySelector('.section_store_details ._open');
        const closeButton = document.querySelector('.section_store_details ._close');

        if (findParentClass('section_store_details', '_open', target)) {
            removeClass(introduceBox, 'close3');
            openButton.style.display = 'none';
            closeButton.style = '';
            closeButton.removeAttribute('style');
        } else {
            addClass(introduceBox, 'close3');
            openButton.style = '';
            openButton.removeAttribute('style');
            closeButton.style.display = 'none';
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

    function addClass(element, classString) {
        element.className = element
            .className
            .split(' ')
            .filter((name) => {
                return name !== classString;
            })
            .concat(classString)
            .join(' ');
    }

    function removeClass(element, classString) {
        element.className = element
            .className
            .split(' ')
            .filter((name) => {
                return name !== classString;
            })
            .join(' ');
    }

    window.addEventListener('DOMContentLoaded', loadData);
    document.querySelector('.section_store_details').addEventListener('click', topIntroduceToggle);
})();

