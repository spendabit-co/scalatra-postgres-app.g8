package $organizationPackage$

import org.scalatra._
import javax.servlet.http.HttpServletRequest
import collection.mutable

trait $name;format="Camel"$Stack extends ScalatraServlet with ScalateSupport {

  notFound {
    contentType = null // Clear `contentType` in case it was set previously.
    serveStaticResource() getOrElse resourceNotFound()
  }
}
