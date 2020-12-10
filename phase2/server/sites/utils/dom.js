function createElement(type, innerHTML, classList){
  let el = document.createElement(type);
  el.innerHTML = innerHTML;
  el.classList.add(...classList);
  return el;
}

function addDate(date){
  //converts date obj into formatted string, then appends to events sidebar
  let root = document.getElementById("events");
  let el = createElement("div", getFormattedDate(date), ["event-date"]);
  root.appendChild(el);
}

function addEvent(obj){
  let root = document.getElementById("events");
  let el = createElement("div", null, ["event"]);
  let title = createElement("div", obj.title, ["event-name"]);
  let roomNumber = createElement("div", "Room " + obj.roomNumber, ["event-roomNumber"]);
  let time = createElement("div", getFormattedTime(new Date(obj.timeOfEvent)), ["event-time"]);

  el.appendChild(time);
  el.appendChild(title);
  el.appendChild(roomNumber);

  root.appendChild(el);
}
