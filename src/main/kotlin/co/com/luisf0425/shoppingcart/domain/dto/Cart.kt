package co.com.luisf0425.shoppingcart.domain.dto

data class Cart (
        var id: Int?,
        var cartProductList: MutableList<CartProduct>?
)