package com.demo.scala.gatling

import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.jdbc.Predef._

class BlazeMeterGatlingTest extends Simulation {
  private val dbConnectionString = "jdbc:mysql://localhost:3306/BlazeDemo"
  private val sqlQuery = "SELECT data FROM original_data"
  private val sqlUserName = "root"
  private val sqlPassword = "B00Xware"

  private val baseUrl = "http://localhost:16666"
  private val uri = "http://localhost:16666/api/1.0/users/"
  private val contentType = "application/json"
  private val endpoint = "/api/1.0/users/"

  private val authPass = "Q1w2e3r4"
  private val authUser = "blaze"
  private val basicAuthHeader = "Basic YmxhemU6UTF3MmUzcjQ="
  private val message = "${data}"
  private val requestCount = 1000

  val sqlQueryFeeder: RecordSeqFeederBuilder[Any] = jdbcFeeder(dbConnectionString,
    sqlUserName,
    sqlPassword,
    sqlQuery
  )

  val httpProtocol: HttpProtocolBuilder = http
    .baseURL(baseUrl)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .authorizationHeader(basicAuthHeader)
    .contentTypeHeader(contentType)
    .userAgentHeader("curl/7.54.0")

  val headers_0 = Map("Expect" -> "100-continue")

  val scn: ScenarioBuilder = scenario("RecordedSimulation")
    .feed(sqlQueryFeeder)
    .exec(http("request_0")
      .post(endpoint)
      .body(StringBody(message)).asJSON
      .headers(headers_0)
      .basicAuth(authUser, authPass)
      .check(status.is(200)))

  setUp(scn.inject(atOnceUsers(requestCount))).protocols(httpProtocol)
}
