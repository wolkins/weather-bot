package example
import skinny.http._
import org.json4s._
import org.json4s.native.JsonMethods._


object Hello extends Greeting with App {
  val res = HTTP.get("http://weather.livedoor.com/forecast/webservice/json/v1?city=130010")
  println(parse(res.textBody))
}

trait Greeting {
  lazy val greeting: String = "Hello  "
}
