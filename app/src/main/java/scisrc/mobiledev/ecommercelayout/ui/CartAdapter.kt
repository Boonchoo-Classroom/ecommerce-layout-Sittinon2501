package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.model.CartItem

class CartAdapter(
    private val cartList: MutableList<CartItem>,
    private val onRemoveClick: (CartItem) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCartProduct: ImageView = view.findViewById(R.id.imageViewCartProduct)
        val textViewCartProductName: TextView = view.findViewById(R.id.textViewCartProductName)
        val textViewCartProductPrice: TextView = view.findViewById(R.id.textViewCartProductPrice)
        val imageViewRemove: ImageView = view.findViewById(R.id.imageViewRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartList[position]
        holder.textViewCartProductName.text = item.name
        holder.textViewCartProductPrice.text = "Price: $${item.price}"
        holder.imageViewCartProduct.setImageResource(item.imageResId)

        // ปุ่มลบสินค้าออกจากตะกร้า
        holder.imageViewRemove.setOnClickListener {
            onRemoveClick(item)
        }
    }

    override fun getItemCount(): Int = cartList.size
}
