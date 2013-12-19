$(document).ready(function () {	
	$('#menubar li').hover(
			function () {
				/* Animated appearance of dropdown menu onHover. */
				/* .slideDown() value sets time length of appearance. */
				$('ul', this).stop().slideDown(100);
			}, 
			function () {
				/* Animated hiding of dropdown menu onHover. */
				/* .slideDown() value sets time length of disappearance. */
				$('ul', this).stop().slideUp(100);			
			}
	);
});