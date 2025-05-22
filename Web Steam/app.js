document.addEventListener('DOMContentLoaded', function() {
    fetch('games.json')
        .then(response => response.json())
        .then(data => {
            const gamesContainer = document.querySelector('.row');

            data.forEach(game => {
                const card = document.createElement('div');
                card.classList.add('col');

                card.innerHTML = `
                    <div class="card">
                        <img src="${game.image}" class="card-img-top" alt="${game.title}">
                        <div class="card-body">
                            <h5 class="card-title">${game.title}</h5>
                            <p class="card-text">${game.description}</p>
                            <p class="card-text">${game.rating}</p>
                            <a href="#" class="btn btn-primary btn-custom">Comprar</a>
                            <p class="text-muted">Plataforma: ${game.platform}</p>
                        </div>
                    </div>
                `;

                gamesContainer.appendChild(card);
            });
        })
        .catch(error => console.error('Error al cargar los datos:', error));
});
