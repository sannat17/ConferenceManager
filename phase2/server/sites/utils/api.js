async function getJSON(){
  //gets event data from remote API

  let params = document.URL.split("/");
  if(params.length < 2)
    return;
  
  //replace localhost with VPS address!
  let url = "http://localhost:5000/json/" + params[params.length - 1];

  let result = await fetch(url);
  return result.json();
}