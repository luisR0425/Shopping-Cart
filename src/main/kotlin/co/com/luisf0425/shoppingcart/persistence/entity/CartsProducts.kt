package co.com.luisf0425.shoppingcart.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "products_cars")
data class CartsProducts(
        @JsonIgnore
        @Access(AccessType.FIELD)
        @EmbeddedId
        var id: CartsProductsPK?,

        @JsonIgnore
        var quantity: Int?,

        @JsonIgnore
        @ManyToOne
        @MapsId("cartsId")
        @JoinColumn(name = "cart_id", insertable = false, updatable = false)
        var carts: Carts?,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "product_id", insertable = false, updatable = false)
        var products: Products?

)