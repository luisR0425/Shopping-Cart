package co.com.luisf0425.shoppingcart.persistence

import co.com.luisf0425.shoppingcart.domain.repository.IProductRepository
import co.com.luisf0425.shoppingcart.persistence.crud.ProductCrudRepository
import co.com.luisf0425.shoppingcart.persistence.entity.Products
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ProductRepository : IProductRepository {

    @Autowired
    private lateinit var productCrudRepository : ProductCrudRepository

    override fun getAllProducts(): Iterable<Products> {
        return productCrudRepository.findAll()
    }
}