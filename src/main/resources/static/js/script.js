async function script() {
  var selectDate = document.querySelector("#select-date");
  var selectTime = document.querySelector("#select-time");

  //fetch request for taken times
  async function getTakenTimes(date) {
    if (!date) return;
    const request = fetch(`/visitTimes/${date}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
      },
    });
    return (await request).json();
  }

  //loop through all options and disable where value matches something in value array
  function setTimeValues(takenTimes) {
    if (!takenTimes) return;
    //console.log(takenTimes);
    let options = selectTime.children;
    for (let i = 0; i < options.length; i++) {
      for (let j = 0; j < takenTimes.length; j++) {
        if (takenTimes[j].visitTime == options[i].value) {
          options[i].disabled = true;
        }
      }
    }
  }

  //on changing date selection, enable time selection and query for already taken times for the date selected
  selectDate.addEventListener("change", async (e) => {
    //console.log(e.target.value);
    if (e.target.value) {
      const res = await getTakenTimes(e.target.value);
      //console.log(res);
      selectTime.disabled = false;
      setTimeValues(res);
    }
  });
}

script();
