

  async function cargarCarton() {
    
    const request = await fetch('http://localhost:8080/sheet')
.then(response => response.json())

var carton = await request

for(var i=0;i<24;i++){
  document.getElementById("square"+i).outerHTML=carton[0][i];
}

}

  async function cargarBalotas() {
    
    const request = await fetch('http://localhost:8080/game')
.then(response => response.json())

var balotas = await request


co=0
function showB(){
  if(co>74){
    clearInterval(idinterval)
  }else{
    document.getElementById("bal").outerHTML='<div id="bal"><h1>'+balotas[co]+'</h1></div>';
    co++
  }
  
}

  const idinterval=setInterval(showB,5000);

  
  }


  async function cargarFunciones(){
    cargarCarton();
    cargarBalotas();
  }


  function changeColor(c){
    celda = document.getElementById(c)
    if(celda.style.backgroundColor== 'green'){
      celda.style.backgroundColor= 'white'
    }else{
      celda.style.backgroundColor= 'green'
    }
    
  }

  function getHeaders() {
      return {
       'Accept': 'application/json',
       'Content-Type': 'application/json'
     };
  }


    
