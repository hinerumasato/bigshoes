async function getAllProducts(url) {
    let products = await fetch(url);
    return await products.json();
}

function generateSlug(str) {
    return str.toLowerCase().replaceAll(" ", "-");
}

export { getAllProducts, generateSlug }