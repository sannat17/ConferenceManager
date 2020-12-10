function getMonthFromInt(value){
  //returns month name from month int value.
  //assumes 0 <= value <= 11
  let months = [
    "January", "February", "March", "April", "May", "June", "July", 
    "August", "September", "October", "November", "December"
  ]
  return months[value];
}

function getCalendarDates(){
  //return lists of days on a calendar page
  let first = new Date(state.current);
  let temp = new Date(state.current);
  let last = new Date(temp.setDate(32))
  last = new Date(last.setDate(0));

  let pre = [];
  for(let i = 0; i < first.getDay(); i++){
    let prev = new Date(first); //get last day of previous month
    prev.setDate(-i);
    pre.unshift(prev.getDate());
  }

  let dates = [];
  for(let i = first.getDate(); i <= last.getDate(); i++){
    dates.push(i);
  }

  let post = [];
  let length = pre.length + dates.length;
  for(let i = 1; i <= 42 - length; i++){
    post.push(i);
  }

  return [pre, dates, post];
}

function getStartEnd(){
  //returns start and end date for this calendar page
  let first = new Date(state.current);
  let day = first.getDate();
  first = new Date(first.setDate(-day));
  let last = new Date(first)
  last.setDate(first.getDate() + 41);
  return [first, last];
}

function getFormattedDate(date){
  //accepts date obj, and formats into readable string
  let month = getMonthFromInt(date.getMonth());
  let day = date.getDate();
  let year = date.getFullYear();
  return `${month} ${day}, ${year}`;
}

function getFormattedTime(date){
  let hours = date.getHours();
  let minutes = date.getMinutes();
  let ampm = hours >= 12 ? 'PM' : "AM";
  hours = hours % 12;
  hours = hours ? hours : 12; // the hour '0' should be '12'
  minutes = minutes < 10 ? '0'+minutes : minutes;
  var strTime = hours + ':' + minutes + ' ' + ampm;
  return strTime;
}

function isSameDay(first, second){
  //returns true if date objects day1 and day2 are in the same day
  return first.getFullYear() === second.getFullYear() &&
    first.getMonth() === second.getMonth() &&
    first.getDate() === second.getDate();
}