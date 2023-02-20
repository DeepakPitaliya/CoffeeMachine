fun main() {
    val coffeeMachine = CoffeeMachine()
    while (coffeeMachine.run) {
        coffeeMachine.menu()
    }
}

class CoffeeMachine() {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var cups = 9
    private var money = 550
    var run = true

    enum class CoffeeType(val water: Int, val milk: Int, val coffeeBeans: Int, val cups: Int = 1, val money: Int) {

        ESPRESSO(250, 0, 16, 1, 4),
        LATTE(350, 75, 20, 1, 7),
        CAPPUCCINO(200, 100, 12, 1, 6);
    }

    private fun takeInput(): String {
        return readln()
    }

    fun menu() {
        println("Write action (buy, fill, take, remaining, exit):")
        when (takeInput()) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                when (takeInput()) {
                    "1" -> makeCoffee(CoffeeType.ESPRESSO)
                    "2" -> makeCoffee(CoffeeType.LATTE)
                    "3" -> makeCoffee(CoffeeType.CAPPUCCINO)
                    else -> println("Invalid input")
                }
            }

            "fill" -> fillSupplies()
            "take" -> takeMoney()
            "remaining" -> printStatus()
            "exit" -> run = false
        }
    }

    private fun printStatus() {
        val status = "The coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$coffeeBeans g of coffee beans\n" +
                "$cups disposable cups\n" +
                "$$money of money"
        println(status)
    }


    private fun makeCoffee(coffeeType: CoffeeType) {
        if (water >= coffeeType.water && milk >= coffeeType.milk && coffeeBeans >= coffeeType.coffeeBeans && cups >= 1) {
            water -= coffeeType.water
            milk -= coffeeType.milk
            coffeeBeans -= coffeeType.coffeeBeans
            cups -= 1
            println("I have enough resources, making you a coffee!")
            money += coffeeType.money
        } else {
            if (water < coffeeType.water) println("Sorry, not enough water!")
            if (milk < coffeeType.milk) println("Sorry, not enough milk!")
            if (coffeeBeans < coffeeType.coffeeBeans) println("Sorry, not enough coffee beans!")
            if (cups < 1) println("Sorry, not enough cups!")
        }
    }

    private fun fillSupplies() {
        println("Write how many ml of water you want to add:")
        water += takeInput().toInt()
        println("Write how many ml of milk you want to add:")
        milk += takeInput().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans += takeInput().toInt()
        println("Write how many disposable cups you want to add: ")
        cups += takeInput().toInt()
    }

    private fun takeMoney() {
        println("I gave you $$money")
        money = 0
    }
}


