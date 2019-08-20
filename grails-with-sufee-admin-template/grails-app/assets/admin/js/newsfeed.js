var newsfeed = function () {

    var $ = jQuery;
    var submitNewsUrl = '/user/news-post'
    function initializePostSubmissionComponents () {
        var description = $('.redactor-styles p').html();
        var selectedCategoryId = $('.standardSelect').val();
        var submitNewsButton = $('.submit-news');

        submitNewsButton.on('click', function () {
            if (description && selectedCategoryId) {
                var data = {
                    description: description,
                    selectedCategoryId: selectedCategoryId
                }
                $.ajax(submitNewsUrl, data, function (resp) {
                    console.log(resp)
                })
            }
        });
    }

    return {
         initialize: function () {

         }
     };
};