package co.com.luisf0425.shoppingcart.persistence.crud

import co.com.luisf0425.shoppingcart.persistence.entity.ProductCart
import co.com.luisf0425.shoppingcart.persistence.entity.ProductCartPK
import org.springframework.data.repository.CrudRepository

interface ProductCartRepository : CrudRepository<ProductCart, ProductCartPK> {
}