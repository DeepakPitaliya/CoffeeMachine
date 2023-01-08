
fun main() {
    // Ingredients required per cup of coffee
    val waterReqd = 200
    val milkReqd = 50
    val coffeeBeansReqd = 15
    println("Write how many cups of coffee you will need:")
    val numCups = readln().toInt()
    println("For $numCups cups of coffee you will need:\n${numCups * waterReqd} ml of water\n${numCups * milkReqd} ml of milk\n${numCups * coffeeBeansReqd} g of coffee beans")
}
