var newsfeed = function () {

    var $ = jQuery;
    var submitNewsUrl = '/user/news-post'
    function initializePostSubmissionComponents () {
        var submitNewsButton = $('.submit-news');

        submitNewsButton.on('click', function () {
            var description = $('.redactor-styles p').html();
            var selectedCategoryId = $('.standardSelect').val();
            if (description && selectedCategoryId != 'null') {
                var data = {
                    description: description,
                    selectedCategoryId: selectedCategoryId
                };
                $.ajax({
                    url: submitNewsUrl,
                    method: 'POST',
                    data: data,
                    success: function(resp) {
                        console.log(resp);
                    },
                    error: function (resp) {
                        console.log(resp)
                    }
                });
            }
        });
    }

    return {
         initialize: function () {
            initializePostSubmissionComponents();
         }
     };
}().initialize();