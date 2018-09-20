package grails.login.app

import org.grails.web.util.WebUtils

public class AppUtil {

    static def createRespnse(boolean isAuthenticated, def user){

    }
    static def getAuthSession(){
        WebUtils.retrieveGrailsWebRequest().session
    }

    static saveResponse(Boolean isSuccess, def model) {
        return [isSuccess: isSuccess, model: model]
    }
}
