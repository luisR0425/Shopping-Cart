package co.com.luisf0425.shoppingcart.persistence

import co.com.luisf0425.shoppingcart.domain.dto.Product
import co.com.luisf0425.shoppingcart.domain.repository.IProductRepository
import co.com.luisf0425.shoppingcart.persistence.crud.ProductCrudRepository
import co.com.luisf0425.shoppingcart.persistence.mapper.ProductMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ProductRepository : IProductRepository {

    @Autowired
    private lateinit var productCrudRepository : ProductCrudRepository

    @Autowired
    private lateinit var mapper: ProductMapper

    override fun getAllProducts(): Iterable<Product> {
        return mapper.toProductListDto(productCrudRepository.findAll())
    }
}