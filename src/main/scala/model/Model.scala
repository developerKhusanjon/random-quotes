package model

case class Quote(author: String, year: Int, quote: String)
case class Quotes(data: Array[Quote])
