/**
 * いいねボタンをホバーすると色を付ける
 */
document.querySelectorAll(".action-button").forEach(target => {
	target.addEventListener("mouseenter", function(e) {
		let wrapper = e.target.parentElement;
		wrapper.classList.add("action-hover");
		wrapper.nextElementSibling.classList.add("action-hover-text");
		wrapper.nextElementSibling.classList.remove("text-secondary");
	})
	target.addEventListener("mouseleave", function(e) {
		let wrapper = e.target.parentElement;
		wrapper.classList.remove("action-hover");
		wrapper.nextElementSibling.classList.remove("action-hover-text");
		wrapper.nextElementSibling.classList.add("text-secondary");
	})
})