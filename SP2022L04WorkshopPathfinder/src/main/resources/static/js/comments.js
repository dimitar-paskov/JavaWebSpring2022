;
const routeId = document.getElementById('routeId').value;
const commentForm = document.getElementById('commentForm');

const maxComments = 2;
commentForm.addEventListener("submit",handleFormSubmission);

const csrfHeaderName = document.head.querySelector('[name=_csrf_header]').content;
const csrfHeaderValue = document.head.querySelector('[name=_csrf]').content;

const commentContainer = document.getElementById('commentCtnr');

let allComments = [];

async function handleFormSubmission(event){
    event.preventDefault();

    const messageVal = document.getElementById('message').value;

    fetch(`http://localhost:8080/api/${routeId}/comments`,{
        method: "POST",
        headers:{
            'Content-Type': 'application/json',
            'Accepts': 'application/json',
            [csrfHeaderName]:csrfHeaderValue

        },
        body: JSON.stringify({
            message: messageVal
        })
    }).then(res => res.json())
        .then(data =>{
            allComments.push(data);
            document.getElementById('message').value = "";
           // commentContainer.innerHTML += commentAsHtml(data);
            displayComments();
        });

}

function commentAsHtml(comment, visible, num){
    let commentHtml = `<div ${visible ? "" : "style='display: none'"} id="comment${num}">\n`;
    commentHtml += `<h4>${comment.authorName}</h4>\n`;
    commentHtml += `<p>${comment.message}</p>\n`
    commentHtml += '</div>\n';

    return commentHtml;
}

fetch(`http://localhost:8080/api/${routeId}/comments`,{
    headers:{
        "Accept": "application/json"
    }
}).then(res => res.json())
    .then(data => {
        for (let comment of data){
            allComments.push(data);
           // commentContainer.innerHTML += commentAsHtml(comment);
            displayComments();
        }
    })

function displayComments(){

    commentContainer.innerHTML = "";

    for(let i = 0 ; i < allComments.length; i++){
        if(i < maxComments ){
            commentContainer.innerHTML += commentAsHtml(allComments[i],true,i);
        }else{
            commentContainer.innerHTML += commentAsHtml(allComments[i],false, i);
        }
    }

    if(allComments.length > maxComments){
        commentContainer.innerHTML += '<button id="showmore_btn" onclick="showmore()">Show more</button>';
        commentContainer.innerHTML += '<button hidden id="showless_btn" onclick="showless()">Show less </button> '
    }else{
        commentContainer.innerHTML += '<button hidden id="showmore_btn" onclick="showmore()">Show more</button>';
        commentContainer.innerHTML += '<button id="showless_btn" onclick="showless()">Show less </button> '
    }

    // commentContainer.innerHTML += '<button hidden id="showless_btn" onclick="showless()">Show less </button> '

}

function showmore(){
    for (let i = maxComments-1; i < allComments.length; i++) {
        show( document.getElementById("comment" + i));
    }
   hide( document.getElementById("showmore_btn"));
   show( document.getElementById("showless_btn"));
}

function showless(){
    for (let i = maxComments; i < allComments.length; i++) {
       hide( document.getElementById("comment" + i))
    }
   show( document.getElementById("showmore_btn"));
   hide( document.getElementById("showless_btn"));
}

var show = function (elem){
	elem.removeAttribute("hidden");
    if (elem.style == null){
        elem.style = {
            display: 'block'
        }
    }else{
        elem.style.display = 'block';
    }

}

var hide = function (elem){
    if (elem.style == null){
        elem.style = {
            display: 'none'
        }
    }else {
        elem.style.display = 'none';
    }
}