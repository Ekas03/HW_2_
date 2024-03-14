import kotlin.concurrent.thread

class Dish(val name: String, val price: Int, val time: Double) {
    var status = "Блюдо $name принято!"


    fun cook() {

        thread {
            println(status)
            println("Готовится: $name")
            Thread.sleep((time * 1000).toLong())
            println("\nБлюдо $name готово!")
        }
    }
}