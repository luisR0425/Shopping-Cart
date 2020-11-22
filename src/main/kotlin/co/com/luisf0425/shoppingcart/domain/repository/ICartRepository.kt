package co.com.luisf0425.shoppingcart.domain.repository

import co.com.luisf0425.shoppingcart.persistence.entity.Cart

interface ICartRepository {
    fun save(cart: Cart): Cart
    fun deleteProductCart(cartId: Int, productID: Int)
    fun update(cart: Cart): Cart
}