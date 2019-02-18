;(function () {
    'use strict';

    const RECYCLE_BIN_CLASS = "recycle-bin";

    $("#sh-bk-form").on("click", function () {
        $("#bk-form").toggle(300);
    });

    $(".content").on("dragstart", function (e) {
        let $obj = $("." + RECYCLE_BIN_CLASS);
        $obj.addClass("drag-start");
        $obj.show(100);

        let $current = $(e.target);
        let bookmarkItemId = $current.data("id");
        $current.addClass("" + bookmarkItemId);
        let ancestorId = $current.parent().parent().parent().parent().attr("id");

        let dataTransfer = e.originalEvent.dataTransfer;
        dataTransfer.setData("id", bookmarkItemId);
        dataTransfer.setData("ancestorId", ancestorId);
    });

    $(".content").on("dragend", function () {
        removeStyleClasses();
        $("." + RECYCLE_BIN_CLASS).hide(100);
    });

    $(".recycle-bin").on("dragover", function (e) {
        e.preventDefault();
    });

    $(".recycle-bin").on("dragenter", function (e) {
        removeStyleClasses();
        $(this).addClass("drag-enter");
    });

    $(".recycle-bin").on("dragleave", function (e) {
        removeStyleClasses();
        $(this).addClass("drag-start");
    });

    $(".recycle-bin").on("drop", function (e) {
        e.preventDefault();

        let dataTransfer = e.originalEvent.dataTransfer;
        let bookmarkItemId = dataTransfer.getData("id");
        let ancestorId = dataTransfer.getData("ancestorId");

        $("#" + ancestorId).find("." + bookmarkItemId).parent().remove();
        $("." + RECYCLE_BIN_CLASS).hide();

        $.ajax({
            url: "bin/bookmark/delete",
            data: {"id": bookmarkItemId}
        });
    });


    function removeStyleClasses() {
        let $obj = $("." + RECYCLE_BIN_CLASS);
        $obj.removeClass("drag-enter");
        $obj.removeClass("drag-start");
    }
}());
