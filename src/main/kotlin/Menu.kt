class Menu {
    var menu : MutableMap<Int, String>
    var prices : MutableList<Int>
    var time : MutableList<Double>

    init {
        menu = mutableMapOf(1 to "PIZZA", 2 to "PASTA", 3 to "CAPPUCCINA", 4 to "TEA")
        prices = mutableListOf(100, 200, 150, 80)
        time = mutableListOf(20.0, 20.0, 10.0, 5.0)
    }

    fun getMenu() {
        var count : Int = 1
        for(dish in menu) {
            println("$count. ${dish.value}")
            count += 1
        }
    }
}