package $organizationPackage$

import org.scalatra.ScalatraServlet

trait $name;format="Camel"$Stack extends ScalatraServlet {

  notFound {
    contentType = null // Clear `contentType` in case it was set previously.
    serveStaticResource() getOrElse resourceNotFound()
  }
}
