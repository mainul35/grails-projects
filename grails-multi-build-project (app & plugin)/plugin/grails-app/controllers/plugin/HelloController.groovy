package plugin

class HelloController {

    def index() {
        [name: params.name]
    }
}
