package co.com.luisf0425.shoppingcart.web.config

import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class GeneralFilter: Filter {
    private val log = LoggerFactory.getLogger(javaClass)

    fun GeneralFilter() {
        log.info("CORSFilter init")
    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {

        /* CORS CONFIGURATION */
        val request = req as HttpServletRequest
        val response = res as HttpServletResponse
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"))
        response.setHeader("Access-Control-Allow-Credentials", "true")
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE")
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Accept, remember-me")
        if ("OPTIONS".equals(request.method, ignoreCase = true)) {
            response.status = HttpServletResponse.SC_OK
        } else {
            // apply CORS filter
            chain.doFilter(req, res)
        }
    }

    override fun init(filterConfig: FilterConfig?) {}

    override fun destroy() {}
}