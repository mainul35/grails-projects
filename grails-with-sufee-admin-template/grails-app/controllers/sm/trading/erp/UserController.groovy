package sm.trading.erp

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

class UserController {

    UploadService uploadService

    @Secured("ROLE_USER")
    def 'newsfeed'() {
        List<Category> categories = Category.findAll {
            max: 10
            offset: 10
        }


        List<News> newsList = News.findAll()
        for (News news in newsList) {
            String base64Image = ''
            if (news.postedBy.getProfileImage()) {
                base64Image = uploadService.getFile(news.postedBy.getProfileImage())
                news.postedBy.setProfileImage('data:image/png;base64, ' + base64Image)
            }
        }

        render(view: '/user/newsfeed', model: [categoryItems: categories, newsList: newsList])
    }

    @Secured("ROLE_USER")
    def 'news-post'() {
        News news = new News()
        boolean saved = false
        Map model = [status: 'error', message: 'Failed to save!']

        if (params.description) {
            news.description = params.description
            news.publishingTime = new Date()
            news.postedBy = SecurityContextHolder.getContext().getAuthentication().principal
            saved = news.save(failOnError: true)
        }

        if (params.selectedCategoryId) {
            Category category = Category.findById(params.getLong('selectedCategoryIds'))
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
