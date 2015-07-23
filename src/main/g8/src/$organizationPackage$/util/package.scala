package $organizationPackage$

import org.mindrot.jbcrypt.BCrypt

package object util {

  def isPasswordCorrect(enteredPass: String, hashedPass: String): Boolean =
    BCrypt.checkpw(enteredPass, hashedPass)

  def hashPassword(pw: String) = bcryptHash(pw)

  def bcryptHash(s: String, logRounds: Int = 12) =
    BCrypt.hashpw(s, BCrypt.gensalt(logRounds))
}
