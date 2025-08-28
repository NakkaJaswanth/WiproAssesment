console.log("Hello Nodejs");

setTimeout(function () { 
    console.log('This prints after 3000 milliseconds'); 
 }, 3000);

 setTimeout(() => { 
    console.log('Callback as Arrow Function'); 
}, 3000);

 console.log("Hello World");