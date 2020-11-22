package co.com.luisf0425.shoppingcart.persistence

import co.com.luisf0425.shoppingcart.domain.repository.ICartRepository
import co.com.luisf0425.shoppingcart.persistence.crud.CartCrudRepository
import co.com.luisf0425.shoppingcart.persistence.entity.Cart
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManagerFactory
import javax.transaction.Transactional

@Repository
class CartRepository : ICartRepository {

    @Autowired
    private lateinit var cartCrudRepository : CartCrudRepository

    @Autowired
    private lateinit var emf: EntityManagerFactory

    override fun save(cart: Cart) : Cart {
        return cartCrudRepository.save(cart)
    }

    @Transactional
    override fun deleteProductCart(cartId: Int, productID: Int) {
        val entityManager = emf.createEntityManager()
        entityManager.transaction.begin()
        val cart: Cart = entityManager.find(Cart::class.java, cartId)
        cart.products?.removeIf { it.product.id == productID && it.cart?.id == cartId}
        entityManager.transaction.commit()
    }

    override fun update(cart: Cart): Cart {
        val entityManager = emf.createEntityManager()
        entityManager.transaction.begin()
        val cartFind = entityManager.find(Cart::class.java, cart.id)
        cartFind.products?.clear()
        cart.products?.let { cartFind.products?.addAll(it) }
        val cartTemp = entityManager.merge(cartFind)
        entityManager.remove(cartTemp)
        entityManager.transaction.commit()
        return cart
    }
}