package co.com.luisf0425.shoppingcart.persistence.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class CartsProductsPK(
        @JsonIgnore
        @Column(name = "product_id") var productId: Int?,
        @JsonIgnore
        @Column(name = "cart_id") var cartId: Int?
) : Serializable