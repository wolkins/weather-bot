package example
import skinny.http._
import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.JsonDSL.WithDouble._

object Hello extends Greeting with App {
  val res = HTTP.get("http://weather.livedoor.com/forecast/webservice/json/v1?city=130010")
  val desc: List[String] = for {
      JObject(description) <- parse(res.textBody)
      JField("text", JString(text)) <- description
    } yield text
  val json =  compact(render(("text" -> desc.head)))
  HTTP.post("https://hooks.slack.com/services/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", json)

}

trait Greeting {}
