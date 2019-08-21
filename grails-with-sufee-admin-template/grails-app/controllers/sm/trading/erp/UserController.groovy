package sm.trading.erp

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class UserController {

    @Secured("ROLE_USER")
    def 'newsfeed'() {
        List<Category> categories = Category.findAll {
            max: 10
            offset: 10
        }


        render(view: '/user/newsfeed', model: [categoryItems: categories])
    }

    @Secured("ROLE_USER")
    def 'news-post'() {
        News news = new News()
        boolean saved = false
        Map model = [status: 'error', message: 'Failed to save!']

        if (params.description) {
            news.description = params.description
            news.publishingTime = new Date()
            saved = news.save(failOnError: true)
        }

        if (params.selectedCategoryId) {
            Category category = Category.findById(params.toLong('selectedCategoryIds'))
            if (saved) {
                category.newsList.add(news)
                category.save(failOnError: true)
                model.status = 'success'
                model.message = 'Saved Successfully.'
            }
        }
        respond (model as JSON)
    }

    def 'edit'(User user) {
        respond (view: '/user/edit')
    }
}
