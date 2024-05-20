function addToCart(button) {
    const row = button.parentNode.parentNode;
    const title = row.getElementsByTagName('td')[0].textContent;
    const price = row.getElementsByTagName('td')[2].textContent;
    const amount = prompt(`Введите количество для покупки товара "${title}" по цене ${price} руб.`);

    if (amount !== null && amount !== "" && Number(amount) > 0) {
        const order = {
            name: title,
            price: price,
            amount: amount
        };

        const orders = JSON.parse(localStorage.getItem("orders")) || [];
        orders.push(order);
        localStorage.setItem("orders", JSON.stringify(orders));

        alert(`Товар "${title}" был успешно добавлен в корзину!`);
    } else {
        alert(`Количество должно быть больше нуля!`);
    }
}