package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.model.Product

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProduct)
        val textViewProductName: TextView = view.findViewById(R.id.textViewProductName)
        val textViewProductPrice: TextView = view.findViewById(R.id.textViewProductPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.textViewProductName.text = product.name
        holder.textViewProductPrice.text = "Price: $${product.price}"

        // ใช้ resource ID จาก drawable
        holder.imageViewProduct.setImageResource(product.imageResId)
    }

    override fun getItemCount(): Int = productList.size
}
