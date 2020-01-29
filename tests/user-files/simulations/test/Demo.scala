package test

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ScenarioBuilder

class Demo extends Simulation {

	val webProtocol = http
		.baseUrl("https://www.google.com")
		.disableCaching
		.disableFollowRedirect

	def warmup: ScenarioBuilder = {
		scenario("warmup")
			.exec(http("GET_TEST_PAGE").get("/")).exitHereIfFailed
	}

	setUp(warmup.inject(atOnceUsers(1))).protocols(webProtocol)
}