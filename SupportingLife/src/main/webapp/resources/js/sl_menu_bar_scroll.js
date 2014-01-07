/**** Function Header Description *****/
$(document).ready(function () {
	/**** Brief Description Here *****/
    $("ul.topLevelMenuBar li").hover(function () { //When trigger is hovered...
        $(this).children("ul.secondLevelMenuBar").slideDown('fast').show();
    }, function () {
        $(this).children("ul.secondLevelMenuBar").slideUp('slow');
    });
    
    /**** Brief Description Here *****/
    $("ul.secondLevelMenuBar li").hover(function () { //When trigger is hovered...
        $(this).children("ul.thirdLevelMenuBar").slideDown('fast').show();
    }, function () {
        $(this).children("ul.thirdLevelMenuBar").slideUp('slow');
    });
});