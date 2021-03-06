package co.com.luisf0425.shoppingcart.web.controller

import co.com.luisf0425.shoppingcart.domain.dto.Cart
import co.com.luisf0425.shoppingcart.domain.service.CartService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
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
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Error en el servidor, revisar log")])
    fun save(@RequestBody cart: Cart) = ResponseEntity(cartService.save(cart), HttpStatus.OK)

    @ApiOperation("Checkout, solo va a modificar el status a completed")
    @PostMapping("/checkout/{cartId}")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Error en el servidor, revisar log")])
    fun checkout(@PathVariable cartId: Int) = ResponseEntity(cartService.updateState(cartId), HttpStatus.OK)

    @ApiOperation("Modificar productos al carro")
    @PostMapping("/update")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Error en el servidor, revisar log")])
    fun update(@RequestBody cart: Cart): ResponseEntity<String>  {
        cartService.update(cart)
        return ResponseEntity(HttpStatus.OK)
    }

    @ApiOperation("Eliminar un producto de un carro")
    @DeleteMapping("/delete/{cartId}/{productId}")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "Error en el servidor, revisar log")])
    fun deleteProductCart(@PathVariable cartId: Int, @PathVariable productId: Int) {
        cartService.deleteProductCart(cartId, productId)
    }
}