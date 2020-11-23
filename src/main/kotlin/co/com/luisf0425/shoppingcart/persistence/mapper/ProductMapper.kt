package co.com.luisf0425.shoppingcart.persistence.mapper

import co.com.luisf0425.shoppingcart.domain.dto.Product
import co.com.luisf0425.shoppingcart.persistence.entity.Products
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface ProductMapper {
    @Mappings(
        Mapping(source = "id", target = "id"),
        Mapping(source = "name", target = "name"),
        Mapping(source = "sku", target = "sku"),
        Mapping(source = "description", target = "description")
    )
    fun toProductDto(products: Products): Product
    fun toProductListDto(productsList: MutableList<Products>?): MutableList<Product>?

    @InheritInverseConfiguration
    fun toProducts(product: Product): Products
}