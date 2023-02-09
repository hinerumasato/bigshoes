
class Shoes {
    constructor(id, name, price, image, amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.amount = amount;
    }

    formatPrice() {
        let temp = String(this.price);
        let result = "";
        let count = 0;
        for(let i = temp.length - 1; i >= 0; i--) {
            result = temp.charAt(i) + result;
            count++;
            if(count % 3 == 0) result = '.' + result;
        }
        return (temp.length % 3 == 0) ? result.slice(1, result.length) + "đ" : result + "đ";
    }

    renderToHTML(selector, content, ...args) {
        const field = document.querySelectorAll(selector)[document.querySelectorAll(selector).length - 1];
        for(let arg of args) {
            content = content.replace("undefined", arg);    
        }
        field.innerHTML += content;
    }

    generateSlug() {
        return this.name.replaceAll(" ", "-");
    }
}

export { Shoes };
