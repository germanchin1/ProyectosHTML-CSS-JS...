document.getElementById("searchBtn").addEventListener("click", buscarPokemon);
document.getElementById("guardarApiBtn").addEventListener("click", guardarPokemonApi);

let pokemonActual = null;

function buscarPokemon() {
  const nombre = document.getElementById("pokemonInput").value.trim().toLowerCase();
  const url = `https://pokeapi.co/api/v2/pokemon/${nombre}`;

  fetch(url)
    .then(res => {
      if (!res.ok) throw new Error("Pokémon no encontrado");
      return res.json();
    })
    .then(data => {
      pokemonActual = {
        id: data.id,
        nombre: data.name,
        tipos: data.types.map(t => t.type.name),
        sprite: data.sprites.front_default,
        sonido: data.cries?.latest || null,
        fuente: "api"
      };

      mostrarPokemon(pokemonActual);
    })
    .catch(err => {
      pokemonActual = null;
      document.getElementById("pokemonGrid").innerHTML = `<p>${err.message}</p>`;
    });
}

function mostrarPokemon(pokemon) {
  const contenedor = document.getElementById("pokemonGrid");
  contenedor.innerHTML = "";

  const card = document.createElement("div");
  card.classList.add("pokemon-card");

  card.innerHTML = `
    <p><strong>${pokemon.nombre.toUpperCase()}</strong></p>
    <p>#${pokemon.id}</p>
    <img src="${pokemon.sprite}" width="120" height="120">
    <p>Tipos: ${pokemon.tipos.join(" y ")}</p>
    ${pokemon.sonido ? `<audio src="${pokemon.sonido}" controls></audio>` : "<p>Sin sonido disponible</p>"}
  `;

  contenedor.appendChild(card);
}

function guardarPokemonApi() {
  if (!pokemonActual) {
    alert("Primero busca un Pokémon.");
    return;
  }

  const apiList = JSON.parse(localStorage.getItem("pokemonsGuardadosParaOtraPagina")) || [];
  apiList.push(pokemonActual);
  localStorage.setItem("pokemonsGuardadosParaOtraPagina", JSON.stringify(apiList));
  alert(`${pokemonActual.nombre.toUpperCase()} guardado correctamente.`);
}

