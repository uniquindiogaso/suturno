
function menuSeleccionado(link) {
    $("#menuLateral").find(".ui-state-active").removeClass("ui-state-active");
    if (link) {
        $(link).addClass("ui-state-active");
    }
}