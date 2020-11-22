package co.com.luisf0425.shoppingcart.persistence.entity

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ProductCartPK(
        @Column(name = "product_id")
        var productId: Int?,

        @Column(name = "cart_id")
        var cartId: Int?
): Serializable