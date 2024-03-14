class Visitor(login: String, val password: String) {
    private val error_format = Exception()
    val order = Order()
    var listOrder : MutableList<Order> = mutableListOf()

    fun order() {

        println("Выберите блюда из меню: ")
        MenuVisitor.getMenu()

        var choice: Int = 1

        while(choice != 0) {
            choice = readln().toInt()
            if (choice == 0) {
                break
            }
            order.addDishToOrder(Dish(MenuVisitor.menu.getValue(choice),
                MenuVisitor.prices[choice - 1], MenuVisitor.time[choice - 1]))
        }
        listOrder.add(order)
        order.cooking()

        print("Пожалуйста, оплатите заказ! Сумма заказа: ${order.priceOfOrder()}\n" +
                "Введите сумму для оплаты: ")

        var pau : Double = readln().toDouble()

        if (pau < order.priceOfOrder()) {
            println("НЕ ХВАТАЕТ ${order.priceOfOrder()-pau}")
            while ((order.priceOfOrder() - pau) != 0.0) {
                print("Добавьте денег: ")
                var money : Double = readln().toDouble()
                pau += money
            }
        } else
        {
            println("Спасибо! До свидания!")
        }
    }

    fun addDish() {
        val MenuVisitor = Menu()
        MenuVisitor.getMenu()

        var choice: Int = 1

        while(choice != 0) {
            choice = readln().toInt()

            order.addDishToOrder(Dish(MenuVisitor.menu.getValue(choice),
                MenuVisitor.prices[choice - 1], MenuVisitor.time[choice - 1]))
        }
        listOrder.add(order)
        order.cooking()
        println("Пожалуйста, оплатите заказ! Сумма заказа: ${order.priceOfOrder()}\n" +
                "Введите сумму для оплаты: ")

        var pau : Double = readln().toDouble()

        if (pau < order.priceOfOrder()) {
            println("НЕ ХВАТАЕТ ${order.priceOfOrder()-pau}")
            while ((order.priceOfOrder() - pau) != 0.0) {
                print("Добавьте денег: ")
                var money : Double = readln().toDouble()
                pau += money
            }
        } else
        {
            println("Спасибо! До свидания!")
        }
    }

    fun cancelOrder() {
        listOrder.remove(order)
    }
}