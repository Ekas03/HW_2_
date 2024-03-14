class Administrator(login : Int, password : String) {

    fun addDish() {
        print("Введите название блюда: ")
        var name : String = readln()

        print("Введите стоимость блюда: ")
        var price : Int = readln().toInt()

        print("Введите время приготовления: ")
        var time : Double = readln().toDouble()


        MenuVisitor.menu.put(MenuVisitor.menu.size + 1, name)
        MenuVisitor.prices.add(price)
        MenuVisitor.time.add(time)

    }

    fun deleteDish() {
        print("Введите название блюда: ")
        var name : String = readln()

        var count : Int = 1

        for (el in MenuVisitor.menu) {
            if (el.value == name) {
                MenuVisitor.menu.remove(count)
            } else {
                count += 1
            }
        }

    }

    fun changeDish() {
        print("Введите название блюда: ")
        var name : String = readln()

        print("Введите новое название блюда: ")
        var newName : String = readln()

        print("Введите новую стоимость блюда: ")
        var price : Int = readln().toInt()

        print("Введите новое время приготовления: ")
        var time : Double = readln().toDouble()

        var count : Int = 1

        for (el in MenuVisitor.menu) {
            if (el.value == name) {
                MenuVisitor.menu.replace(count, newName)
                MenuVisitor.prices.add(price)
                MenuVisitor.time.add(time)
            } else {
                count += 1
            }
        }

    }
}