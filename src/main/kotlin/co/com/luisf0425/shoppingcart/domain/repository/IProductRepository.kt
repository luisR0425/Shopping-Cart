package co.com.luisf0425.shoppingcart.domain.repository

import co.com.luisf0425.shoppingcart.persistence.entity.Product

interface IProductRepository {
    fun getAllProducts() : Iterable<Product>
}