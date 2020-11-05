function test() {
  var url = "https://vobygca.com/vobygca/api/utilisateur/personnalData";

  var xhr = new XMLHttpRequest();
  xhr.open("POST", url);

  xhr.setRequestHeader("Accept", "application/json");
  xhr.setRequestHeader("Content-Type", "application/json");

  xhr.onreadystatechange = function () {
     if (xhr.readyState === 4) {
        console.log(xhr.status);
        console.log(xhr.responseText);
   }};

  var data = `{
    "nom": "LAPIERRE", "prenom": "Franck", "email": "Franck_lapierre@gcatrans.com", telephone: "123456789"
  }`;

  xhr.send(data);

}
