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
		console.log(dataUri);
	}
	
	fileReader.readAsDataURL(file);
});

document.getElementById("modal-avatar-wrapper").addEventListener("click", function(e) {
	let button = document.getElementById("avatar-image-input");
	button.click();
})