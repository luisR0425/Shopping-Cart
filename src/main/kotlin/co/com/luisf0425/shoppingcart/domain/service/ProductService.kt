package co.com.luisf0425.shoppingcart.domain.service

import co.com.luisf0425.shoppingcart.domain.dto.Product
import co.com.luisf0425.shoppingcart.domain.repository.IProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    private lateinit var IProductRepository : IProductRepository

    fun getAllProducts() : Iterable<Product> {
        return IProductRepository.getAllProducts()
    }
}