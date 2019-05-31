package sm.trading.erp

class AppTagLib {
    static namespace = "app"
//    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def alert = { attr, body ->
        out << g.render(template: '/templates/alert', model: [msg: attr.msg, status: attr.status])
    }

    def fileField = { attr, body ->
        out << '<div class="form-group">'
        out << '<input type = "file" name = "file" />'
        out << '</div>'
    }
}
