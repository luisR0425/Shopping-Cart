package co.com.luisf0425.shoppingcart.persistence.crud

import co.com.luisf0425.shoppingcart.persistence.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductCrudRepository : CrudRepository<Product, Int> {
    fun findAllOrderBy(): List<Product>
}