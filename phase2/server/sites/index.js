var state = {
  current: new Date(new Date().setDate(1))
}

async function render(){
  //assembles all visual elements on screen
  generateCalendar();
  console.log(await getJSON());
  generateSidebar();
}

function generateCalendar(){
  //generates calendar by setting dates

  let year = document.getElementById("year");
  year.innerHTML = state.current.getFullYear();

  let month = document.getElementById("month");
  month.innerHTML = getMonthFromInt(state.current.getMonth());

  let root = document.getElementById("calendar-body");
  root.innerHTML = ""; //clear previous

  let dates = getCalendarDates();
  for(const date of dates[0]){
    let el = createElement("div", date, ["calendar-date", "calendar-date-greyed"]);
    root.appendChild(el);
  }

  for(const date of dates[1]){
    let el = createElement("div", date, ["calendar-date"]);
    root.appendChild(el);
  }

  for(const date of dates[2]){
    let el = createElement("div", date, ["calendar-date", "calendar-date-greyed"]);
    root.appendChild(el);
  }
}

function setMonth(value){
  state.current.setMonth(state.current.getMonth() + value);
  render();
}

async function generateSidebar(){
  //populates sidebar with events

  let events = document.getElementById("events");
  events.innerHTML = ""; //clear previous events

  let json = await getJSON();
  let currentDate = new Date(json[0].timeOfEvent);
  addDate(currentDate);

  for(const obj of json){
    let date = new Date(obj.timeOfEvent);
    if(!isSameDay(currentDate, date)){
      currentDate = date;
      addDate(date);
    }
    addEvent(obj);
  }

}