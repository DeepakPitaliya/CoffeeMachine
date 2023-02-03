fun main() {
    val coffeeMachine = CoffeeMachine()
    while (coffeeMachine.run) {
        coffeeMachine.menu()
    }
}

class CoffeeMachine {

    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var cups = 9
    private var money = 550
    var run = true  // Machine is running

    private fun takeInput(): String {
        return readln()
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

    fun menu() {
        println("Write action (buy, fill, take, remaining, exit):")
        when (takeInput()) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                when (takeInput()) {
                    "1" -> {
                        if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                            water -= 250
                            coffeeBeans -= 16
                            cups -= 1
                            println("I have enough resources, making you a coffee!")
                            money += 4
                        } else {
                            if (water < 250) println("Sorry, not enough water!")
                            if (coffeeBeans < 16) println("Sorry, not enough coffee beans!")
                            if (cups < 1) println("Sorry, not enough cups!")
                        }
                    }

                    "2" -> {
                        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                            water -= 350
                            milk -= 75
                            coffeeBeans -= 20
                            cups -= 1
                            println("I have enough resources, making you a coffee!")
                            money += 7
                        } else {
                            if (water < 350) println("Sorry, not enough water!")
                            if (milk < 75) println("Sorry, not enough milk!")
                            if (coffeeBeans < 20) println("Sorry, not enough coffee beans!")
                            if (cups < 1) println("Sorry, not enough cups!")
                        }
                    }

                    "3" -> {
                        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                            water -= 200
                            milk -= 100
                            coffeeBeans -= 12
                            cups -= 1
                            println("I have enough resources, making you a coffee!")
                            money += 6
                        } else {
                            if (water < 200) println("Sorry, not enough water!")
                            if (milk < 100) println("Sorry, not enough milk!")
                            if (coffeeBeans < 12) println("Sorry, not enough coffee beans!")
                            if (cups < 1) println("Sorry, not enough cups!")
                        }
                    }

                    else -> menu()
                }
            }

            "fill" -> {
                println("Write how many ml of water you want to add:")
                water += takeInput().toInt()
                println("Write how many ml of milk you want to add:")
                milk += takeInput().toInt()
                println("Write how many grams of coffee beans you want to add:")
                coffeeBeans += takeInput().toInt()
                println("Write how many disposable cups you want to add: ")
                cups += takeInput().toInt()
            }

            "take" -> {
                println("I gave you $$money")
                money = 0
            }

            "remaining" -> printStatus()
            "exit" -> run = false
        }
    }
}
