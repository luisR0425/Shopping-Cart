package co.com.luisf0425.shoppingcart.domain.repository

import co.com.luisf0425.shoppingcart.domain.dto.Cart
import co.com.luisf0425.shoppingcart.persistence.entity.Carts

interface ICartRepository {
    fun save(cart: Cart): Cart
    fun deleteProductCart(cartId: Int, productId: Int)
    fun update(cart: Cart): Cart
    fun updateState(cartId: Int)
}