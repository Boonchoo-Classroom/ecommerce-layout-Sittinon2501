package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.model.CartItem

class CartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private var cartList = mutableListOf<CartItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewCart)

        cartList = generateMockCart()
        cartAdapter = CartAdapter(cartList) { item ->
            removeFromCart(item)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = cartAdapter

        return view
    }

    private fun generateMockCart(): MutableList<CartItem> {
        return mutableListOf(
            CartItem(1, "Wireless Mouse", 29.99, R.drawable.product_mouse),
            CartItem(2, "Mechanical Keyboard", 89.99, R.drawable.product_keyboard),
            CartItem(3, "Gaming Headset", 59.99, R.drawable.product_headset)
        )
    }

    private fun removeFromCart(item: CartItem) {
        cartList.remove(item)
        cartAdapter.notifyDataSetChanged()
        Toast.makeText(context, "${item.name} removed from cart", Toast.LENGTH_SHORT).show()
    }
}
