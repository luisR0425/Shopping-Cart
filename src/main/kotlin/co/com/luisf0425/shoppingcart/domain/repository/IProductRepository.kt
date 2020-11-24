package co.com.luisf0425.shoppingcart.domain.repository

import co.com.luisf0425.shoppingcart.domain.dto.Product

interface IProductRepository {
    fun getAllProducts() : Iterable<Product>
}