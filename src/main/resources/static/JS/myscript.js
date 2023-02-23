// Use to load usernames to your local storage
const form = document.getElementById("signup-form");
const submitButton = document.getElementById("loginButton");
const usernameInput = form.userText;

const loadUsers = () => {
  const users = ["John", "James", "Paul"];
  // Use to loop through users
  users.forEach(name => {
    // Sets the key and value
    localStorage.setItem(name, name);
  });
  // Sets an item to your local storage, the key and value
  localStorage.setItem("password", "password");
};

form.addEventListener("submit", function(event) {
  event.preventDefault();
// this input array will store all the element(field) from the form
// they will be set to isvalid=true to indicate that they are filled
  const inputs = form.elements;
  let isValid = true;
// the loop will go trough and check if the input is filled
  for (let i = 0; i < inputs.length - 1; i++) {
    if (!inputs[i].value) {
      isValid = false;
      break;
    }
  }
// if there are input they will be check against what is in the storage for validation
  if (isValid) {
    const userName = form.userText.value;
    const userPassword = form.userPassword.value;
// check if the input and local storage are the same
        // if the input match what I have in the local storage send users to google
    if (localStorage.getItem(userName) === userName && localStorage.getItem("password") === userPassword) {
      localStorage.setItem("name", userName);
      window.location.replace("https://www.google.com");
    } else {
 // this will make sure that if the user doesn't login if a wrong pwd is entered 
 // errorposition place the message at the top of the form
      event.preventDefault();
      const errorMessage = document.querySelector("#error");
      if (errorMessage) {
// the query selector will help select the error 
        errorMessage.innerHTML = "Username or password is incorrect. Please try again.";
      } else {
        const errorMessage = document.createElement("div");
        errorMessage.id = "error";
        errorMessage.innerHTML = "Username or password is incorrect. Please try again.";
        errorMessage.style.color = "red";
        errorposition.before(errorMessage);
      }
    }
  } else {
    //this will alert users if they try to submit empty field
    // if the required in the html works this does get triggered 
    alert("Please fill out all the required fields.");
  }
});

loadUsers();
  // Disable the selected options in the dropdown menus
  const sizeDropdown = document.getElementById("size");
  const colorDropdown = document.getElementById("color");

  // Disable the selected size
  sizeDropdown.options[sizeDropdown.selectedIndex].disabled = true;
  // Disable the selected color
  colorDropdown.options[colorDropdown.selectedIndex].disabled = true;

  // Add event listeners to re-enable the disabled options when a new option is selected
  sizeDropdown.addEventListener("change", () => {
      sizeDropdown.options[sizeDropdown.selectedIndex].disabled = false;
  });

  colorDropdown.addEventListener("change", () => {
      colorDropdown.options[colorDropdown.selectedIndex].disabled = false;
  });
  

  