package co.com.luisf0425.shoppingcart.persistence

import co.com.luisf0425.shoppingcart.domain.dto.Cart
import co.com.luisf0425.shoppingcart.domain.repository.ICartRepository
import co.com.luisf0425.shoppingcart.persistence.crud.CartCrudRepository
import co.com.luisf0425.shoppingcart.persistence.entity.Carts
import co.com.luisf0425.shoppingcart.persistence.mapper.CartMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.persistence.EntityManagerFactory

@Repository
class CartRepository : ICartRepository {

    @Autowired
    private lateinit var cartCrudRepository : CartCrudRepository

    @Autowired
    private lateinit var emf: EntityManagerFactory

    @Autowired
    private lateinit var mapper: CartMapper

    override fun save(cart: Cart) : Cart {
        val cartsSave = cartCrudRepository.save(Carts(null, 'P', null))
        cartsSave.products = mapper.toCarts(cart).products
        cartsSave.products?.forEach {
            it.carts = cartsSave
            it.id?.cartId = cartsSave.cartsId
        }
        val cartDto = cartCrudRepository.save(cartsSave)
        return mapper.toCartDto(cartDto)
    }

    override fun deleteProductCart(cartId: Int, productId: Int) {
        val entityManager = emf.createEntityManager()
        entityManager.transaction.begin()
        val carts: Carts = entityManager.find(Carts::class.java, cartId)
        carts.products?.removeIf { it.id?.productId == productId && it.id?.cartId == cartId }
        entityManager.merge(carts)
        entityManager.transaction.commit()
    }

    override fun update(cart: Cart): Cart {
        val entityManager = emf.createEntityManager()
        entityManager.transaction.begin()
        val cartFind = entityManager.find(Carts::class.java, cart.id)
        cartFind.products?.clear()
        mapper.toCarts(cart).products?.let { cartFind.products?.addAll(it) }
        cartFind.products?.forEach { it.id?.cartId = cart.id }
        entityManager.merge(cartFind)
        entityManager.transaction.commit()
        return cart
    }

    override fun updateState(cartId: Int) {
        val cartFind = cartCrudRepository.findById(cartId)
        cartFind.get().status = 'C'
        cartCrudRepository.save(cartFind.get())
    }
}