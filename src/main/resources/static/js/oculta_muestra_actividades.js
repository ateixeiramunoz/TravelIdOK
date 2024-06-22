// Imagenes - Botones - Categoria Actividades
const btnAcuatica = document.querySelector(".muestraAcuatica");
const btnDia = document.querySelector(".muestraDia");
const btnNoche = document.querySelector(".muestraNoche");
const btnGastronomia = document.querySelector(".muestraGastronomia");
const btnAdrenalina = document.querySelector(".muestraAdrenalina");
const btnTour = document.querySelector(".muestraTour");
const btnTodas = document.querySelector(".muestraTodas"); // Botón adicional para mostrar todas las actividades

// Secciones de cards de actividades por su categoria
const secciones = {
  acuaticas: document.querySelector(".actividadesAcuaticas"),
  dia: document.querySelector(".actividadesDia"),
  noche: document.querySelector(".actividadesNoche"),
  gastronomia: document.querySelector(".actividadesGastronomia"),
  adrenalina: document.querySelector(".actividadesAdrenalina"),
  tours: document.querySelector(".actividadesTours"),
};

// Botones
const botones = {
  acuaticas: btnAcuatica,
  dia: btnDia,
  noche: btnNoche,
  gastronomia: btnGastronomia,
  adrenalina: btnAdrenalina,
  tours: btnTour,
  todas: btnTodas, // Botón adicional para mostrar todas las actividades
};

// Ocultar todas las secciones
function ocultarTodasSecciones() {
  for (let seccion in secciones) {
    secciones[seccion].style.setProperty("display", "none", "important");
  }
}

// Mostrar todas las secciones
function mostrarTodasSecciones() {
  for (let seccion in secciones) {
    secciones[seccion].style.setProperty("display", "flex", "important");
  }
}

// Cambiar la clase activa del botón
function cambiarClaseActiva(botonActivo) {
  for (let boton in botones) {
    if (botones[boton] === botonActivo) {
      botones[boton].classList.replace("client-logo", "client-logos");
    } else {
      botones[boton].classList.replace("client-logos", "client-logo");
    }
  }
}

// Mostrar la sección seleccionada y ocultar las demás
function mostrarSeccion(seccion) {
  ocultarTodasSecciones();
  secciones[seccion].style.display = "block";
}

// Funciones de evento
function mostrarOcultarAcuatica() {
  mostrarSeccion("acuaticas");
  cambiarClaseActiva(btnAcuatica);
}

function mostrarOcultarDia() {
  mostrarSeccion("dia");
  cambiarClaseActiva(btnDia);
}

function mostrarOcultarNoche() {
  mostrarSeccion("noche");
  cambiarClaseActiva(btnNoche);
}

function mostrarOcultarGastronomia() {
  mostrarSeccion("gastronomia");
  cambiarClaseActiva(btnGastronomia);
}

function mostrarOcultarAdrenalina() {
  mostrarSeccion("adrenalina");
  cambiarClaseActiva(btnAdrenalina);
}

function mostrarOcultarTour() {
  mostrarSeccion("tours");
  cambiarClaseActiva(btnTour);
}

// Nueva función para mostrar todas las actividades
function mostrarOcultarTodas() {
  mostrarTodasSecciones();
  cambiarClaseActiva(btnTodas);
}

// Eventos escuchando click para mostrar-ocultar las secciones
btnAcuatica.addEventListener("click", mostrarOcultarAcuatica);
btnDia.addEventListener("click", mostrarOcultarDia);
btnNoche.addEventListener("click", mostrarOcultarNoche);
btnGastronomia.addEventListener("click", mostrarOcultarGastronomia);
btnAdrenalina.addEventListener("click", mostrarOcultarAdrenalina);
btnTour.addEventListener("click", mostrarOcultarTour);
btnTodas.addEventListener("click", mostrarOcultarTodas); // Evento para el nuevo botón
