package app100.jain.com.intents

data class Product(
    val name:String,
    val isDelivered:Boolean,
    val price:Double
)
data class Shop(
    val name: String,
    val products: List<Product>
) {
    fun getDeliveredMax(): Product {
        var max: Double = 0.0
        products.forEach {
            if (it.price >= max)
                max = it.price
        }
        val deliverlist = products.filter {
            it.isDelivered &&
            it.price == max
        }
        return deliverlist[0]
    }
}
val shop=Shop(
    products = listOf(
        Product("Android" +
                "",false,9000.0),
        Product("Web",true,10000.0),
        Product("ML",true,8000.0),
        Product("Python",false,9900.0),
        Product("C++",false,9780.0)
    ),
        name="CB"
)
fun main(){
    val max= shop.getDeliveredMax()
    print(max)
}
fun List<Int>.filter(filterLogic: (Int) -> Boolean): List<Int>{
    val filteredList = arrayListOf<Int>()
    for (item in this){
        if (filterLogic(item)){
            filteredList.add(item)
        }
    }
    return filteredList
}