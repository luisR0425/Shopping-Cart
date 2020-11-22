package co.com.luisf0425.shoppingcart.web.controller

import co.com.luisf0425.shoppingcart.domain.service.CartService
import co.com.luisf0425.shoppingcart.persistence.entity.Cart
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/cart")
class CartController {
    @Autowired
    private lateinit var cartService: CartService

    @ApiOperation("Agregar productos al carro")
    @PostMapping("/save")
    fun save(@RequestBody cart: Cart) = ResponseEntity(cartService.save(cart), HttpStatus.OK)

    @ApiOperation("Modificar productos al carro")
    @PostMapping("/update")
    fun update(@RequestBody cart: Cart) = ResponseEntity(cartService.update(cart), HttpStatus.OK)

    @DeleteMapping("/delete/{idCart}/{idProduct}")
    fun deleteProductCart(@PathVariable idCart: Int, @PathVariable idProduct: Int) {
        cartService.deleteProductCart(idCart, idProduct)
    }
}