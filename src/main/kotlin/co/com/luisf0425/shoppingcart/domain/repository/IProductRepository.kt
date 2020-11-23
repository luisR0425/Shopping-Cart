package co.com.luisf0425.shoppingcart.domain.repository

import co.com.luisf0425.shoppingcart.persistence.entity.Products

interface IProductRepository {
    fun getAllProducts() : Iterable<Products>
}