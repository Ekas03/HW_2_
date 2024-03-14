import kotlin.concurrent.thread

class Dish(val name: String, val price: Int, val time: Double) {
    var status = "\nБлюдо $name принято!"


    fun cook() {

        thread {
            println(status)
            println("\nГотовится: $name")
            Thread.sleep((time * 1000).toLong())
            println("\nБлюдо $name готово!")
        }
    }
}