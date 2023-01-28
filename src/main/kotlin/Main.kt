// Initial state
var water = 400
var milk = 540
var coffeeBeans = 120
var cups = 9
var money = 550
fun main() {
    printStatus()
    menu()
}

fun printStatus() {
    val status = "The coffee machine has:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$coffeeBeans g of coffee beans\n" +
            "$cups disposable cups\n" +
            "$$money of money"
    println(status)
}

// Ask user what to do and take action accordingly
fun menu() {
    println("Write action (buy, fill, take):")
    when (readln()) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
            when (readln()) {
                "1" -> {
                    water -= 250
                    milk -= 0
                    coffeeBeans -= 16
                    cups -= 1
                    money += 4
                }

                "2" -> {
                    water -= 350
                    milk -= 75
                    coffeeBeans -= 20
                    cups -= 1
                    money += 7
                }

                "3" -> {
                    water -= 200
                    milk -= 100
                    coffeeBeans -= 12
                    cups -= 1
                    money += 6
                }
            }
        }

        "fill" -> {
            println("Write how many ml of water you want to add:")
            water += readln().toInt()
            println("Write how many ml of milk you want to add:")
            milk += readln().toInt()
            println("Write how many grams of coffee beans you want to add:")
            coffeeBeans += readln().toInt()
            println("Write how many disposable cups you want to add: ")
            cups += readln().toInt()
        }

        "take" -> {
            println("I gave you $$money")
            money = 0
        }
    }
    printStatus()
}
