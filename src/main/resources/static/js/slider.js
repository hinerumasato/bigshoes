class Slider {

    constructor(sliderField) {
        this.sliderField = sliderField;
    }

    controlSlider() {
        let transform = (screen.width >= 740) ? -50 : -100;
        setInterval(() => {
            this.sliderField.style.transform = `translateX(calc(${transform}%)`;
            transform = (transform < 0) ? 0 : (screen.width >= 740) ? -50 : -100;
        }, 7000);
    }

    addSlider(src) {
        const newImg = document.createElement('img');
        newImg.src = src;
        this.sliderField.appendChild(newImg);
    }
}

const slider = new Slider(document.querySelector(".slider_img_wrap"));
slider.controlSlider();