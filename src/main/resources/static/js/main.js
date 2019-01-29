
;(function () {
    'use strict';

    // navigate();

    function navigate() {
        let pageType = $('.nav.nav-tabs').find('.active').data('page-type');
        if ('home-page' === pageType) {
            $('.home-page').removeClass('hide');
        }
    }

}());
