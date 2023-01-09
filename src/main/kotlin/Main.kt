// Ingredients required per cup of coffee
val waterPerCup = 200
val milkPerCup = 50
val coffeeBeansPerCup = 15
fun main() {
    displayMessage()
}

fun calculateCoffeeCups(): Int {
    var numberOfCoffeeCupsPossible: Int
    println("Write how many ml of water the coffee machine has:")
    val waterAvailable = readln().toInt()
    numberOfCoffeeCupsPossible = waterAvailable / waterPerCup
    println("Write how many ml of milk the coffee machine has:")
    val milkAvailable = readln().toInt()
    numberOfCoffeeCupsPossible =
        if (milkAvailable / milkPerCup < numberOfCoffeeCupsPossible) milkAvailable / milkPerCup else numberOfCoffeeCupsPossible
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeansAvailable = readln().toInt()
    numberOfCoffeeCupsPossible =
        if (coffeeBeansAvailable / coffeeBeansPerCup < numberOfCoffeeCupsPossible) coffeeBeansAvailable / coffeeBeansPerCup else numberOfCoffeeCupsPossible
    return numberOfCoffeeCupsPossible
}

fun displayMessage() {
    val numCoffeeCupsPossible = calculateCoffeeCups()
    println("Write how many cups of coffee you will need:")
    val numCupsRequired = readln().toInt()
    if (numCoffeeCupsPossible == numCupsRequired) {
        println("Yes, I can make that amount of coffee")
    } else if (numCoffeeCupsPossible > numCupsRequired) {
        println("Yes, I can make that amount of coffee (and even ${numCoffeeCupsPossible - numCupsRequired} more than that)")
    } else {
        println("No, I can make only $numCoffeeCupsPossible cups of coffee")
    }
}