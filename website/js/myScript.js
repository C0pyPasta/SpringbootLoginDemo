
// Formatted bearer token we will recieve and format later
let bearerToken;

// Hiding empty Div id loginResultDisplay at the start of the program
window.onload = function () {
    document.getElementById("loginResultDisplay").style.visibility = 'hidden';
    document.getElementById("omgevingKeuzeDisplay").style.visibility = 'hidden';
}


function sendLogin() {

    // Reset omgevingKeuzeDisplay div when another user logs on
    document.getElementById("omgevingKeuzeDisplay").innerHTML = "";

    // Get the content of the two input fields by id
    let name = document.getElementById("usernameInput").value;
    let password = document.getElementById("passwordInput").value;

    // Convert the JSON object into a string "json"
    let jsonString = JSON.stringify({
        username: name,
        password: password
    });

    // Create a new XMLHttpRequest object "xhr"
    let xhr = new XMLHttpRequest();

    // Configure it: POST-request for the URL /api/auth
    xhr.open('POST', 'http://localhost:8080/api/auth');

    // Set the request header to application/json
    xhr.setRequestHeader('Content-Type', 'application/json');

    // Send the request
    xhr.send(jsonString);

    // Display and store the token
    xhr.onload = function () {
        document.getElementById("loginResultDisplay").style.visibility = 'visible';
        document.getElementById("loginResultDisplay").innerHTML = xhr.responseText.replaceAll('"', '')
            .replace('{', '').replaceAll(':', ' : ').replaceAll(',', '<br>').replace('}', '');

        localStorage.setItem("bearerToken", xhr.response);
    };
}


function testBearerToken() {

    // Get the token out of localStorage and concatinate/substring it into the right format
    let storedHash = localStorage.getItem("bearerToken");
    bearerToken = 'Bearer ' + storedHash.substring(10, storedHash.length - 2);

    // Perform the request with the bearerToken send in the header
    fetch('http://localhost:8080/api/auth/user', {
        method: 'GET',
        headers: {
            'Authorization': bearerToken
        }
    })
    .then(response => response.text())
    .then(loginResult => document.getElementById("loginResultDisplay").innerHTML = loginResult.replaceAll(',', '<br>')
        .replaceAll('{', '').replaceAll('"', '').replaceAll(':', ' : ').replaceAll('[', '<br>').replaceAll('}', '').replace(']', '')
        .replace('enabled : true', '').replace('username', 'gebruikersnaam').replace('password', 'wachtwoord')
        .replace('authorities', 'toegangsniveaus').replaceAll('authority', 'toegangsniveau')
    );
}


function trySprekerOmgeving() {

    document.getElementById("omgevingKeuzeDisplay").style.visibility = 'visible';

    fetch('http://localhost:8080/sprekerOmgeving', {
        method: 'GET',
        headers: {
            'Authorization': bearerToken
        }

    })
    .then(response => response.text())
    .then(loginResult => document.getElementById("omgevingKeuzeDisplay").innerHTML = loginResult)
}


function tryOrganisatorOmgeving() {

    document.getElementById("omgevingKeuzeDisplay").style.visibility = 'visible';

    fetch('http://localhost:8080/organisatorOmgeving', {
        method: 'GET',
        headers: {
            'Authorization': bearerToken
        }
    })
    .then(response => response.text())
    .then(loginResult => document.getElementById("omgevingKeuzeDisplay").innerHTML = loginResult)
}


function tryAdministratorOmgeving() {

    document.getElementById("omgevingKeuzeDisplay").style.visibility = 'visible';

    fetch('http://localhost:8080/AdministratorOmgeving', {
        method: 'GET',
        headers: {
            'Authorization': bearerToken
        }
    })
    .then(response => response.text())
    .then(loginResult => document.getElementById("omgevingKeuzeDisplay").innerHTML = loginResult)
}