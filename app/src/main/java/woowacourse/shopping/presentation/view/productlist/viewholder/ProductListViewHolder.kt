package woowacourse.shopping.presentation.view.productlist.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.R
import woowacourse.shopping.databinding.ItemProductListBinding
import woowacourse.shopping.presentation.model.CartModel
import woowacourse.shopping.presentation.view.productlist.ProductListener

class ProductListViewHolder(
    parent: ViewGroup,
    productListener: ProductListener,
) : RecyclerView.ViewHolder(
    LayoutInflater.from((parent.context))
        .inflate(R.layout.item_product_list, parent, false),
) {
    private val binding = ItemProductListBinding.bind(itemView)

    init {
        binding.productListener = productListener

        binding.productCountView.countStateChangeListener = { count ->
            binding.product?.let { productListener.onCountClick(it.id, count) }
        }
    }

    fun bind(cartProduct: CartModel) {
        binding.product = cartProduct.product
        binding.productCountView.setCount(cartProduct.count)

        // binding.product = product
        // binding.productCountView.setCount(1) // TODO 어댑터는 상품이 아닌 CartModel을 갖도록 함
    }
}
