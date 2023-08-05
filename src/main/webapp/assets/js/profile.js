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