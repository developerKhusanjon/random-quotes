package util

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import model.{Quote, Quotes}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val quoteFormat: RootJsonFormat[Quote] = jsonFormat3(Quote)
  implicit val quotesFormat: RootJsonFormat[Quotes] = jsonFormat1(Quotes)
}
