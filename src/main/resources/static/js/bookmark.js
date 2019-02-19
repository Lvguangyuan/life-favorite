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
        let bookmarkId = $current.data("id");
        let bookmarkType = $current.parent().parent().parent().attr("id");

        let dataTransfer = e.originalEvent.dataTransfer;
        dataTransfer.setData("bookmarkId", bookmarkId);
        dataTransfer.setData("bookmarkType", bookmarkType);
    });

    $(".recycle-bin").on("drop", function (e) {
        e.preventDefault();

        let dataTransfer = e.originalEvent.dataTransfer;
        let bookmarkId = dataTransfer.getData("bookmarkId");
        let bookmarkType = dataTransfer.getData("bookmarkType");

        let $bookmark = $("#" + bookmarkType).find("[data-id='"+ bookmarkId +"']");
        let title = $bookmark.text();
        let link = $bookmark.attr("href");
        let description = $bookmark.next().text();

        $bookmark.parent().remove();
        $("." + RECYCLE_BIN_CLASS).hide();

        $.ajax({
            url: "bin/bookmark/delete",
            data: {
                "id": bookmarkId,
                "type": bookmarkType,
                "title": title,
                "link": link,
                "description": description
            }
        });
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

    function removeStyleClasses() {
        let $obj = $("." + RECYCLE_BIN_CLASS);
        $obj.removeClass("drag-enter");
        $obj.removeClass("drag-start");
    }
}());
