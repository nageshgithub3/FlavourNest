/**
 * 
 */

// Menu Filter Functionality
document.addEventListener('DOMContentLoaded', function() {
    const filterBtns = document.querySelectorAll('.filter-btn');
    const menuCards = document.querySelectorAll('.menu-card');
    const searchInput = document.getElementById('menuSearch');

    // Filter by category
    filterBtns.forEach(btn => {
        btn.addEventListener('click', function() {
            const category = this.getAttribute('data-category');
            
            // Update active button
            filterBtns.forEach(b => b.classList.remove('active'));
            this.classList.add('active');
            
            // Filter menu items
            menuCards.forEach(card => {
                if (category === 'all' || card.getAttribute('data-category').includes(category)) {
                    card.style.display = 'block';
                    setTimeout(() => card.classList.remove('hidden'), 10);
                } else {
                    card.classList.add('hidden');
                    setTimeout(() => card.style.display = 'none', 300);
                }
            });
        });
    });

    // Search functionality
    if (searchInput) {
        searchInput.addEventListener('input', function() {
            const searchTerm = this.value.toLowerCase();
            
            menuCards.forEach(card => {
                const itemName = card.querySelector('h3').textContent.toLowerCase();
                const description = card.querySelector('.description').textContent.toLowerCase();
                
                if (itemName.includes(searchTerm) || description.includes(searchTerm)) {
                    card.style.display = 'block';
                    card.classList.remove('hidden');
                } else {
                    card.classList.add('hidden');
                    card.style.display = 'none';
                }
            });
        });
    }
});

// Add to Cart Function
function addToCart(menuId, itemName, price) {
    // Create form and submit
    const form = document.createElement('form');
    form.method = 'POST';
    form.action = 'cart';
    
    const fields = {
        action: 'add',
        menuId: menuId,
        quantity: '1'
    };
    
    for (let key in fields) {
        const input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = fields[key];
        form.appendChild(input);
    }
    
    document.body.appendChild(form);
    form.submit();
}

// Smooth scroll for anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});