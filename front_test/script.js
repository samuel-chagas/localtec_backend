const formulario = document.querySelector("form");
const nome = document.querySelector(".nome");
const email = document.querySelector(".email");

const Users = [];
const User = {};


function getData() {
    fetch('http://localhost:8080/users')
    .then( data => data.json())
    .then( dados => Users.push(dados))
    .catch( error => console.log(error));
}

function cadastro(){
    fetch('http://localhost:8080/user',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: nome.value,
            email: email.value
        })
    })
    .then(function(res) { console.log(res)})
    .catch(function(res) { console.log(res)})

}

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    cadastro();
    getData();
    console.log(Users);
})


