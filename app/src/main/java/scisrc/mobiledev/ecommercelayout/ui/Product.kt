package scisrc.mobiledev.ecommercelayout.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val imageResId: Int // ใช้ resource ID แทน URL
)
