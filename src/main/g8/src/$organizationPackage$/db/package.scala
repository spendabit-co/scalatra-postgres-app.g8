package $organizationPackage$

import scala.slick.driver.PostgresDriver

package object db {

  type Session = PostgresDriver.simple.Session

  trait DatabaseDriver extends PostgresDriver {}
  object DatabaseDriver extends DatabaseDriver

  private val driverName = (new org.postgresql.ds.PGSimpleDataSource).getClass.getName
  private val defaultHost = "localhost"
  private val defaultUser = "$name;format="snake"$_dev"
  private val defaultPass = "password"
  private val defaultDBName = "$name;format="snake"$_dev"
  private val defaultJdbcURI = "jdbc:postgresql://" + defaultHost + "/" +
    defaultDBName + "?characterEncoding=utf-8" // + "&ssl=true"
}
