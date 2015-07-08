package $organizationPackage$

import org.scalatra.test.scalatest.ScalatraSuite

class $servletName$Tests extends FunSuite with ScalatraSuite {

  addServlet(classOf[Servlet], "/*")

  test("accessing homepage") {
    get("/") {
      assert(status == 200)
    }
  }
}
