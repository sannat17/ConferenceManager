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

function toDate(str){
  //converts java date string to js date obj
  //assumes str is a java date string
  return new Date(str);
}

function getStartEnd(){
  let first = new Date(state.current);
  let day = first.getDate();
  first = new Date(first.setDate())
}