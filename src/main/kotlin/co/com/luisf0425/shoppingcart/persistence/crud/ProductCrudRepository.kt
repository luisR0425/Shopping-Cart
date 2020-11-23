package co.com.luisf0425.shoppingcart.persistence.crud

import co.com.luisf0425.shoppingcart.persistence.entity.Products
import org.springframework.data.repository.CrudRepository

interface ProductCrudRepository : CrudRepository<Products, Int> {
}