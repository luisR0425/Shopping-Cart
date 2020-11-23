package co.com.luisf0425.shoppingcart.persistence.mapper

import co.com.luisf0425.shoppingcart.domain.dto.Cart
import co.com.luisf0425.shoppingcart.persistence.entity.Carts
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring", uses = [CartProductMapper::class])
interface CartMapper {
    @Mappings(
            Mapping(source = "cartsId", target = "id"),
            Mapping(source = "products", target = "cartProductList"),
    )
    fun toCartDto(carts: Carts): Cart
    fun toCartListDto(cartsList: MutableList<Carts>?): MutableList<Cart>?

    @InheritInverseConfiguration
    @Mappings(
            Mapping(target = "status", ignore = true),
    )
    fun toCarts(cart: Cart): Carts
}