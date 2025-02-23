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
import scisrc.mobiledev.ecommercelayout.model.FavoriteItem

class FavoritesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var favoritesAdapter: FavoritesAdapter
    private var favoriteList = mutableListOf<FavoriteItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewFavorites)

        favoriteList = generateMockFavorites()
        favoritesAdapter = FavoritesAdapter(favoriteList) { item ->
            removeFromFavorites(item)
        }

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = favoritesAdapter

        return view
    }

    private fun generateMockFavorites(): MutableList<FavoriteItem> {
        return mutableListOf(
            FavoriteItem(1, "Wireless Mouse", 29.99, R.drawable.product_mouse),
            FavoriteItem(2, "Mechanical Keyboard", 89.99, R.drawable.product_keyboard),
            FavoriteItem(3, "Gaming Headset", 59.99, R.drawable.product_headset)
        )
    }

    private fun removeFromFavorites(item: FavoriteItem) {
        favoriteList.remove(item)
        favoritesAdapter.notifyDataSetChanged()
        Toast.makeText(context, "${item.name} removed from favorites", Toast.LENGTH_SHORT).show()
    }
}
