const form = document.getElementById('pokemonForm');
const contenedorLista = document.getElementById('listaPokemon');
let listaPokemon = JSON.parse(localStorage.getItem('pokemonList')) || [];

function guardarEnLocalStorage() {
  localStorage.setItem('pokemonList', JSON.stringify(listaPokemon));
}

function mostrarPokemones() {
  contenedorLista.innerHTML = '';
  listaPokemon.forEach((p) => {
    contenedorLista.innerHTML += 
    `
      <div class="pokemon">
        <strong>#${p.numero}</strong>: ${p.nombre} 
        <br>Tipo: ${p.tipo1}${p.tipo2 ? ` / ${p.tipo2}` : ''}
        <br>Habilidad: ${p.habilidad}
      </div>
    `;
  });
}

function obtenerHabilidadSeleccionada() {
  const checkboxes = document.querySelectorAll('input[name="habilidad"]');
  for (const box of checkboxes) {
    if (box.checked) return box.value;
  }
  return null;
}

function desmarcarOtras(checkboxSeleccionado) {
  const checkboxes = document.querySelectorAll('input[name="habilidad"]');
  checkboxes.forEach(box => {
    if (box !== checkboxSeleccionado) box.checked = false;
  });
}

// Limitar a una habilidad marcada
document.querySelectorAll('input[name="habilidad"]').forEach(box => {
  box.addEventListener('change', function () {
    if (this.checked) desmarcarOtras(this);
  });
});

form.addEventListener('submit', function(event) {
  event.preventDefault();

  const numero = parseInt(document.getElementById('numero').value);
  const nombre = document.getElementById('nombre').value.trim();
  const tipo1 = document.getElementById('tipo1').value.trim();
  const tipo2 = document.getElementById('tipo2').value.trim();
  const habilidad = obtenerHabilidadSeleccionada();

  if (!habilidad) {
    alert('Por favor selecciona una habilidad.');
    return;
  }

  const nuevoPokemon = {
    numero,
    nombre,
    tipo1,
    tipo2: tipo2 || null,
    habilidad
  };

  listaPokemon.push(nuevoPokemon);
  guardarEnLocalStorage();
  mostrarPokemones();
  form.reset();
});

// =============================
// Guardar en otra página
// =============================

document.getElementById('guardarBtn').addEventListener('click', function() {
  if (listaPokemon.length === 0) {
    alert("No hay Pokémon registrados para guardar.");
    return;
  }

  const ultimoPokemon = listaPokemon[listaPokemon.length - 1];
  let listaGuardados = JSON.parse(localStorage.getItem('pokemonsGuardadosParaOtraPagina')) || [];
  listaGuardados.push(ultimoPokemon);
  localStorage.setItem('pokemonsGuardadosParaOtraPagina', JSON.stringify(listaGuardados));

  alert(`Pokémon ${ultimoPokemon.nombre} guardado para la otra página.`);
});
