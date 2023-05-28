package woowacourse.shopping.data.respository.product.source.remote

import woowacouse.shopping.model.product.Product

interface ProductRemoteDataSource {
    fun requestDatas(
        onFailure: () -> Unit,
        onSuccess: (products: List<Product>) -> Unit,
    )

    fun requestData(
        productId: Long,
        onFailure: () -> Unit,
        onSuccess: (products: Product) -> Unit,
    )
}
