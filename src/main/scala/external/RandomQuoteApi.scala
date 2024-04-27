package external

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.http.scaladsl.unmarshalling.Unmarshal
import model.Quote
import util.JsonSupport

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

object RandomQuoteApi extends API with JsonSupport {

  override val endpoint = "http://localhost:9191/api/v1"

  def getRandomAnimeQuote(): Quote = {
    val responseFuture: Future[HttpResponse] = Http().singleRequest(HttpRequest(uri = s"$endpoint/random"))
    val ftRes = Await.result(responseFuture, 2.second)
    val resFuture = Unmarshal(ftRes.entity).to[Quote]
    val animeQuote = Await.result(resFuture, 2.second)
    animeQuote
  }
}
