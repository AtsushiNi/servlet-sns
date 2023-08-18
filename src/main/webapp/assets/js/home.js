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

/**
 * いいねボタン押下でいいね！
 */
document.querySelectorAll(".favorite-button").forEach(element => {
	element.addEventListener("click", function(event) {
		event.preventDefault();
	
		let postId = event.target.nextElementSibling.querySelector(".postId").textContent;
		let data = "postId=" + encodeURIComponent(postId);
	
	  var xhr = new XMLHttpRequest();
	  xhr.open("POST", "/ServletSNS/ajaxEndpoint/favorite", true);
	  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  xhr.onreadystatechange = function() {
	    if (xhr.readyState === XMLHttpRequest.DONE) {
	      if (xhr.status === 200) {
	        var responseData = xhr.responseText;
	        // レスポンスデータの処理
	        let favoritesCountDiv = event.target.parentNode.nextElementSibling;
	        favoritesCountDiv.textContent = responseData;
	      } else {
	        console.error("Request failed:", xhr.status, xhr.statusText);
	      }
	    }
	  };
	  xhr.send(data);
	
	})
})