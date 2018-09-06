package grails.login.app

import grails.gorm.transactions.Transactional

@Transactional
class RequestMapService {

    def create(String url, String role){
        RequestMap requestMap = new RequestMap()
        requestMap.url = url
        requestMap.role = role
        if (!requestMap.findAll()?.contains(requestMap)){
            requestMap.save()
        }
    }

    def getMatchedUriList(String path){
        def  criteria = RequestMap.createCriteria()
        def results = criteria.list {
            like('url', '%/'+path+'/%')
        }
        return results
    }

    def getAllUrlList(){
        return RequestMap.findAll()
    }
}
