/**
 * 
 */

// Restaurant Page JavaScript

document.addEventListener('DOMContentLoaded', function() {
    const filterBtns = document.querySelectorAll('.filter-btn');
    const restaurantCards = document.querySelectorAll('.restaurant-card');
    const sortSelect = document.getElementById('sortSelect');

    // Filter by cuisine
    filterBtns.forEach(btn => {
        btn.addEventListener('click', function() {
            const cuisine = this.getAttribute('data-cuisine');
            
            // Update active button
            filterBtns.forEach(b => b.classList.remove('active'));
            this.classList.add('active');
            
            // Filter restaurants
            restaurantCards.forEach(card => {
                const cardCuisine = card.getAttribute('data-cuisine');
                if (cuisine === 'all' || cardCuisine === cuisine) {
                    card.style.display = 'block';
                    setTimeout(() => card.classList.remove('hidden'), 10);
                } else {
                    card.classList.add('hidden');
                    setTimeout(() => card.style.display = 'none', 300);
                }
            });
        });
    });

    // Sort functionality
    if (sortSelect) {
        sortSelect.addEventListener('change', function() {
            const sortBy = this.value;
            const restaurantsGrid = document.querySelector('.restaurants-grid');
            const cardsArray = Array.from(restaurantCards);
            
            cardsArray.sort((a, b) => {
                if (sortBy === 'rating') {
                    const ratingA = parseFloat(a.querySelector('.rating').textContent.replace('⭐ ', ''));
                    const ratingB = parseFloat(b.querySelector('.rating').textContent.replace('⭐ ', ''));
                    return ratingB - ratingA;
                } else if (sortBy === 'delivery') {
                    const timeA = parseInt(a.querySelector('.delivery-time').textContent.replace(/[^0-9]/g, ''));
                    const timeB = parseInt(b.querySelector('.delivery-time').textContent.replace(/[^0-9]/g, ''));
                    return timeA - timeB;
                } else if (sortBy === 'name') {
                    const nameA = a.querySelector('h3').textContent.toLowerCase();
                    const nameB = b.querySelector('h3').textContent.toLowerCase();
                    return nameA.localeCompare(nameB);
                }
            });
            
            // Reorder the cards
            cardsArray.forEach(card => restaurantsGrid.appendChild(card));
        });
    }
});

// Add animation on scroll
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -100px 0px'
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.opacity = '1';
            entry.target.style.transform = 'translateY(0)';
        }
    });
}, observerOptions);

// Observe all restaurant cards
document.querySelectorAll('.restaurant-card').forEach(card => {
    card.style.opacity = '0';
    card.style.transform = 'translateY(20px)';
    card.style.transition = 'all 0.6s ease-out';
    observer.observe(card);
});