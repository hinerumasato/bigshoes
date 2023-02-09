import { Shoes } from "./shoes.js";
import { getAllProducts, generateSlug } from "./utils.js";

class ShoesManagement {
    constructor(shoesList) {
        this.shoesList = shoesList;
    }

    renderToHTML(selector) {
        let index = 0;
        let field = document.querySelector(selector);
        for(let shoes of this.shoesList) {
            shoes.renderToHTML(".product_container_right_product_list", `
                <div class="product_container_right_product_list_item">
                    <a class="product_container_right_product_list_link" href="/product/${undefined}">
                        <div class="product_container_right_product_list_item_up">
                            <img src="${undefined}" alt="" class="product_container_right_product_list_item_up_img">
                        </div>
                        <div class="product_container_right_product_list_item_down">
                            <div class="product_container_right_product_list_item_down_name">
                                ${undefined}
                            </div>
                            <div class="product_container_right_product_list_item_down_price">
                                ${undefined}
                            </div>
                        </div>
                    </a>
                </div>
        `, generateSlug(shoes.name), shoes.image, shoes.name, shoes.formatPrice());
            index++;
            if(index % 4 == 0) {
                let newList = document.createElement("div");
                newList.className = "product_container_right_product_list";
                field.appendChild(newList);
            }
        }
    }
}

let rawDatas = await getAllProducts("/api/shoes");
let shoes = rawDatas.map(data => new Shoes(data.id, data.name, data.price, data.image, data.amount));
let shoesList = new ShoesManagement(shoes);
shoesList.renderToHTML(".product_container_right");