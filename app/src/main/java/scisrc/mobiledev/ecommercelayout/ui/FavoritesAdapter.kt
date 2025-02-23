package scisrc.mobiledev.ecommercelayout.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.model.FavoriteItem

class FavoritesAdapter(
    private val favoriteList: MutableList<FavoriteItem>,
    private val onRemoveClick: (FavoriteItem) -> Unit
) : RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewFavoriteProduct: ImageView = view.findViewById(R.id.imageViewFavoriteProduct)
        val textViewFavoriteProductName: TextView = view.findViewById(R.id.textViewFavoriteProductName)
        val textViewFavoriteProductPrice: TextView = view.findViewById(R.id.textViewFavoriteProductPrice)
        val imageViewRemoveFavorite: ImageView = view.findViewById(R.id.imageViewRemoveFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoriteList[position]
        holder.textViewFavoriteProductName.text = item.name
        holder.textViewFavoriteProductPrice.text = "Price: $${item.price}"
        holder.imageViewFavoriteProduct.setImageResource(item.imageResId)

        // ปุ่มลบสินค้าออกจาก Favorites
        holder.imageViewRemoveFavorite.setOnClickListener {
            onRemoveClick(item)
        }
    }

    override fun getItemCount(): Int = favoriteList.size
}
