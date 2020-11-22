package co.com.luisf0425.shoppingcart.persistence.crud

import co.com.luisf0425.shoppingcart.persistence.entity.Cart
import org.springframework.data.repository.CrudRepository

interface CartCrudRepository : CrudRepository<Cart, Int> {


}