package co.com.luisf0425.shoppingcart.persistence.mapper

import co.com.luisf0425.shoppingcart.domain.dto.CartProduct
import co.com.luisf0425.shoppingcart.persistence.entity.CartsProducts
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring", uses = [ProductMapper::class])
interface CartProductMapper {
    @Mappings(
            Mapping(source = "id.productId", target = "productId"),
            Mapping(source = "quantity", target = "quantity")
    )
    fun toCartProductDto(cartsProducts: CartsProducts): CartProduct

    @InheritInverseConfiguration
    @Mappings(
            Mapping(target = "id.cartId", ignore = true),
            Mapping(target = "products", ignore = true),
            Mapping(target = "carts", ignore = true)
    )
    fun toCartsProducts(cartProduct :CartProduct): CartsProducts
}