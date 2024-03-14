class Order() {
    var listDishes : MutableList<Dish> = mutableListOf()

    fun addDishToOrder(dish : Dish) {
        listDishes.add(dish)
    }

    fun cooking() {
        for (element in listDishes) {
            element.cook()
        }
    }

    fun priceOfOrder() : Double {
        var summary : Double = 0.0
        for (element in listDishes) {
            summary += element.price
        }
        return summary
    }
}