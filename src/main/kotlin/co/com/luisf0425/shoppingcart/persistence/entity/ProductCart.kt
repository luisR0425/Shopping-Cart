package co.com.luisf0425.shoppingcart.persistence.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "products_cars")
data class ProductCart(
        @EmbeddedId
        var id: ProductCartPK,

        var quantity: Int,

        @ManyToOne
        @JoinColumn(name = "product_id", insertable = false, updatable = false)
        var product: Product,

        @ManyToOne
        @MapsId("id")
        @JoinColumn(name = "cart_id", insertable = false, updatable = false)
        var cart: Cart?
): Serializable