    package scisrc.mobiledev.ecommercelayout.ui

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.recyclerview.widget.RecyclerView
    import scisrc.mobiledev.ecommercelayout.R
    import scisrc.mobiledev.ecommercelayout.model.Product

    class ProductListFragment : Fragment() {

        private lateinit var recyclerView: RecyclerView
        private lateinit var productAdapter: ProductAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_product_list, container, false)
            recyclerView = view.findViewById(R.id.recyclerViewProducts)

            val productList = generateProductList()
            productAdapter = ProductAdapter(productList)
            recyclerView.adapter = productAdapter

            return view
        }

        private fun generateProductList(): List<Product> {
            return listOf(
                Product(1, "Wireless Mouse", 29.99, R.drawable.product_mouse),
                Product(2, "Mechanical Keyboard", 89.99, R.drawable.product_keyboard),
                Product(3, "Gaming Headset", 59.99, R.drawable.product_headset),

            )
        }

    }
