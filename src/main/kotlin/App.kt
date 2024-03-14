class App {

    private val error_format = Exception()

    private var listVisitor = mutableMapOf<String, String>()
    private var objectsVisitor = mutableMapOf<String, Visitor>()

    private var objectsAdministrator = mutableMapOf<Int, Administrator>()
    var countAdmin : Int = 0

    fun authentication() {

        val commands : String = "\"Выберите, пожалуйста, как вы хотите войти:\n" +
                "1. Войти как посетитель\n" +
                "2. Войти как администратор\n" +
                "3. Выйти"

        while (true) {

            println(commands)
            print("Введите 1 или 2 в зависимости от способа входа: ")

            var choice: Int = 0

            try {
                choice = readln().toInt()
                if (choice < 1 || choice > 3) {
                    throw error_format
                }
            } catch (e: Exception) {
                println("Неверный формат данных! Введите 1 или 2")
            }

            when (choice) {
                1 -> authenticationVisitor()
                2 -> authenticationAdministrator()
                else -> {
                    println("Вы вышли из программы!")
                    return
                }
            }
        }
    }

    fun authenticationVisitor() {
        val visitor : Visitor
        print("Введите логин: ")
        val login : String = readln()

        print("Введите пароль: ")
        var password : String = readln()

        if (!listVisitor.containsKey(login)) {
            listVisitor.put(login, password)
            visitor = Visitor(login, password)
            objectsVisitor.put(login, visitor)
        } else {
            while (listVisitor[login] != password) {
                print("Неверный пароль у данного пользователя! Введите другой пароль: ")
                password = readln()
            }
            visitor = objectsVisitor[login]!!
        }

        print("Что хотели бы сделать?\n" +
                "1. Оставить заказ\n" +
                "2. Добавить блюдо к заказу\n" +
                "3. Отменить заказ\n")

        var choice: Int = 0

        try {
            choice = readln().toInt()
            if (choice < 1 || choice > 3) {
                throw error_format
            }
        } catch (e: Exception) {
            println("Неверный формат данных! Введите 1 или 2")
        }

        when (choice) {
            1 -> visitor.order()
            2 -> visitor.addDish()
            3 -> visitor.cancelOrder()
        }

    }

    fun authenticationAdministrator() {
        print("Введите логин: ")
        var login: String = readln()

        print("Введите пароль: ")
        var password: String = readln()


        while(login != "admin" && password != "password") {
            println("Неверный логин или пароль!")

            print("Введите логин: ")
            login = readln()

            print("Введите пароль: ")
            password = readln()
        }

        var admin = Administrator(countAdmin, password)
        objectsAdministrator.put(countAdmin, admin)
        countAdmin += 1

        print("Что хотели бы сделать?\n" +
                "1. Добавить блюдо в меню\n" +
                "2. Удалить блюдо\n" +
                "3. Изменить блюдо\n" +
                "Введите цифру: ")

        var choice: Int = 0
        choice = readln().toInt()

        when (choice) {
            1 -> admin.addDish()
            2 -> admin.deleteDish()
            3 -> admin.changeDish()
        }

    }
}