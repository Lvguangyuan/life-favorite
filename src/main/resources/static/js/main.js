;(function () {
    'use strict';

    navigate();

    function navigate() {
        let url = window.location.href;
        if (url.indexOf('home') !== -1) {
            $('.nav.nav-tabs').find('li[data-page-type="home"]').addClass('active');
        } else if (url.indexOf('bookmark') !== -1) {
            $('.nav.nav-tabs').find('li[data-page-type="bookmark"]').addClass('active');
        } else if (url.indexOf('board') !==  -1) {
            $('.nav.nav-tabs').find('li[data-page-type="board"]').addClass('active');
        }
    }


}());
