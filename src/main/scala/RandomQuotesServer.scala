import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.Http

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}
import scala.util.{Failure, Success}

object RandomQuotesServer extends App {

  def run(): Unit = {

    implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "RandomQuotesWebServer")
    implicit val executionContext: ExecutionContextExecutor = system.executionContext

    val host = "localhost"
    val port = 9000

    val randomQuotesRoutes = pathPrefix("random") {
      get {
        path("random") {
          complete(s"Random Route")
        }
      }
    }

    val route = pathPrefix("api") {
      randomQuotesRoutes
    }

    val binding = Http().newServerAt(host, port).bindFlow(route)

    binding.onComplete {
      case Failure(exception) =>
        println(s"Failure : $exception")
        system.terminate()
      case Success(_) => println(s"Server is listening on http://$host:$port")
    }
  }

}
