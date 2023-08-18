/**
 * プロフィール画面でアバター画像をアップロードする
 */

document.getElementById("avatar-image-input").addEventListener("change", function(e) {
	let file = e.target.files[0];
	
	let fileReader = new FileReader();
	fileReader.onload = function() {
		let dataUri = this.result;
		let image = document.getElementById("modal-avatar");
		image.src = dataUri;
	}
	
	fileReader.readAsDataURL(file);
});

document.getElementById("modal-avatar-wrapper").addEventListener("click", function(e) {
	let button = document.getElementById("avatar-image-input");
	button.click();
})


/**
 * プロフィール画面でホーム画像をアップロードする
 */

document.getElementById("home-image-input").addEventListener("change", function(e) {
	let file = e.target.files[0];
	
	let fileReader = new FileReader();
	fileReader.onload = function() {
		let dataUri = this.result;
		let image = document.getElementById("modal-home-image");
		image.src = dataUri;
	}
	
	fileReader.readAsDataURL(file);
});

document.getElementById("modal-home-image-wrapper").addEventListener("click", function(e) {
	let button = document.getElementById("home-image-input");
	button.click();
})


/**
 * プロフィール修正を保存する
 */

document.getElementById("modal-save-button").addEventListener("click", function(e) {
	let submitButton = document.getElementById("edit-profile-submit");
	submitButton.click();
})

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