package woowacourse.shopping.presentation.view.cart.adapter

import androidx.recyclerview.widget.DiffUtil
import woowacourse.shopping.presentation.model.CartProductModel

class CartDiffUtil(
    private val oldItems: List<CartProductModel>,
    private val newItems: List<CartProductModel>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}
