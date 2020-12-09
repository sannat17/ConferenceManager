var state = {
  current: new Date(new Date().setDate(1))
}

async function main(){
  generateCalendar();
  console.log(await getJSON());
}

function generateCalendar(){
  //generates calendar by setting dates

  let year = document.getElementById("year");
  year.innerHTML = state.current.getFullYear();

  let month = document.getElementById("month");
  month.innerHTML = getMonthFromInt(state.current.getMonth());

  let root = document.getElementById("calendar-body");

  let dates = getCalendarDates();
  for(const date of dates[0]){
    let el = document.createElement("div");
    el.innerHTML = date;
    el.classList.add("calendar-date", "calendar-date-greyed");
    root.appendChild(el);
  }

  for(const date of dates[1]){
    let el = document.createElement("div");
    el.innerHTML = date;
    el.classList.add("calendar-date");
    root.appendChild(el);
  }

  for(const date of dates[2]){
    let el = document.createElement("div");
    el.innerHTML = date;
    el.classList.add("calendar-date", "calendar-date-greyed");
    root.appendChild(el);
  }
}

async function generateSidebar(){
  let json = getJSON();
  for(const obj in json){
    let date = new Date(obj.timeOfEvent);
  }
}

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