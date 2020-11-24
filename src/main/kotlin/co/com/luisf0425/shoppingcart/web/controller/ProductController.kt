package co.com.luisf0425.shoppingcart.web.controller

import co.com.luisf0425.shoppingcart.domain.dto.Product
import co.com.luisf0425.shoppingcart.domain.service.ProductService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/product")
class ProductController {

    @Autowired
    private lateinit var productService : ProductService

    @GetMapping("/all")
    @ApiOperation("Lista de productos")
    @ApiResponse(code = 200, message = "OK")
    fun getAllProducts() : ResponseEntity<Iterable<Product>> =
            ResponseEntity(productService.getAllProducts(), HttpStatus.OK)
}