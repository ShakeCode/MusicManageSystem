(function ($) {
        $.notify = function(options) {
            var dft = {
                paddingL: "30px", 
                paddingR: "30px", 
                paddingT: "20px", 
                paddingB: "20px",
                fontSize:"16px",
                bgColor:    "#0288d1",
                fontColor:    "#fff",
                cont:    "成功"
            };
            var ops = $.extend(dft,options||{});
            var box = $("<div>").css({ "padding-left": ops.paddingL, "box-shadow": "2px 2px 2px #888888 ","border-radius":"5em","padding-right": ops.paddingR, "padding-top": ops.paddingT, "padding-bottom": ops.paddingB, "border": "1px #0288d1 solid","position":"fixed","left":"50%","top":"90%","background-color":ops.bgColor,"color":ops.fontColor,"font-size":ops.fontSize,"z-index":101 }).html(options?options:ops.cont).appendTo($("body"));
            box.css({"margin-left":-(box.outerWidth(true)/2),"margin-top":-box.outerHeight(true)/1});
            box.animate({top:'200px',opacity:'0.8'},"fast");
            setTimeout(function(){
                box.remove();
            },2000); 
        }
    })(jQuery);