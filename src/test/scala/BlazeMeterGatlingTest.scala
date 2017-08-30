package com.demo.scala.gatling

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class BlazeMeterGatlingTest extends Simulation {
  private val baseUrl = "http://localhost:16666"
  private val basicAuthHeader = "Basic YmxhemU6UTF3MmUzcjQ="
  private val authPass = "Q1w2e3r4"
  private val uri = "http://localhost:16666/api/1.0/arrival/all"

  private val contentType = "application/json"
  private val endpoint = "/api/1.0/arrival/all"
  private val authUser = "blaze"
  private val requestCount = 1000

  val httpProtocol: HttpProtocolBuilder = http
    .baseURL(baseUrl)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .authorizationHeader(basicAuthHeader)
    .contentTypeHeader(contentType)
    .userAgentHeader("curl/7.54.0")

  val headers_0 = Map("Expect" -> "100-continue")

  val scn: ScenarioBuilder = scenario("RecordedSimulation")
    .exec(http("request_0")
      .get(endpoint)
      .headers(headers_0)
      .basicAuth(authUser, authPass)
      .check(status.is(200)))

  setUp(scn.inject(atOnceUsers(requestCount))).protocols(httpProtocol)
}
