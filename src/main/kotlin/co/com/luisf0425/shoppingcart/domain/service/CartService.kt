package co.com.luisf0425.shoppingcart.domain.service

import co.com.luisf0425.shoppingcart.domain.repository.ICartRepository
import co.com.luisf0425.shoppingcart.persistence.entity.Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CartService {

    @Autowired
    private lateinit var iCartRepository : ICartRepository

    fun save(cart: Cart): Cart {
        return iCartRepository.save(cart)
    }

    fun deleteProductCart(cartId: Int, productID: Int) {
        iCartRepository.deleteProductCart(cartId, productID)
    }

    fun update(cart: Cart): Cart {
        return iCartRepository.update(cart)
    }
}