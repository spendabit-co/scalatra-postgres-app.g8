package $organizationPackage$

import org.scalatest.FunSuite
import org.scalatra.test.scalatest.ScalatraSuite

class $servletName$Tests extends FunSuite with ScalatraSuite {

  addServlet(classOf[MyServlet], "/*")

  test("accessing homepage") {
    get("/") {
      assert(status == 200)
    }
  }
}
