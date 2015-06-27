import com.ig.service.Author
import com.ig.service.Book

class BootStrap {

    def init = { servletContext ->

        (1..10).each{
            Author author = new Author(name: "xyz ${it}",address: "Manak Vihar ${it}", age: it+25)
            author.addToBooks(new Book(name: "book ${it + 2}"))
            author.addToBooks(new Book(name: "book ${it + 4}"))
            author.save()
        }
    }
    def destroy = {
    }
}
