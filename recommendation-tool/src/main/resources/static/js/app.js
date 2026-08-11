document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const results = document.querySelector(".results");
    const empty = document.querySelector(".empty");

    const target = results || empty;
    if (target) {
    target.scrollIntoView({ behavior: "smooth", block: "start" });
    }

    if (form) {
    form.addEventListener("submit", (event) => {
        const requiredFields = form.querySelectorAll("[required]");
        let firstInvalid = null;

        requiredFields.forEach((field) => {
        if (!field.value) {
            field.classList.add("field--invalid");
            firstInvalid = firstInvalid || field;
        } else {
            field.classList.remove("field--invalid");
        }
        });

        if (firstInvalid) {
        event.preventDefault();
        firstInvalid.focus();
        }
    });
    }
});